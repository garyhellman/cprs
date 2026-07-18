import { CommonModule } from '@angular/common';
import { Component, OnInit, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../core/api.service';
import { ReviewAssignment, Student, Suggestion } from '../../core/models';

@Component({
  selector: 'app-assignments-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './assignments.page.html',
  styleUrl: './assignments.page.css',
})
export class AssignmentsPage implements OnInit {
  private readonly api = inject(ApiService);

  readonly students = signal<Student[]>([]);
  readonly suggestions = signal<Suggestion[]>([]);
  readonly accepted = signal<ReviewAssignment[]>([]);
  readonly error = signal<string | null>(null);
  readonly message = signal<string | null>(null);

  studentId: number | null = null;

  ngOnInit(): void {
    this.api.listStudents().subscribe({
      next: (data) => {
        this.students.set(data);
        if (data.length) {
          this.studentId = data[0].id;
          this.loadAccepted();
        }
      },
      error: () => this.error.set('Could not load students'),
    });
  }

  onStudentChange(): void {
    this.suggestions.set([]);
    this.message.set(null);
    this.loadAccepted();
  }

  suggest(): void {
    if (!this.studentId) {
      return;
    }
    this.error.set(null);
    this.message.set(null);
    this.api.suggestAssignments(this.studentId).subscribe({
      next: (res) => {
        this.suggestions.set(res.suggestions);
        if (!res.suggestions.length) {
          this.message.set('No eligible professors. Check capacity, conflicts, or university match.');
        }
      },
      error: () => this.error.set('Suggestion failed'),
    });
  }

  accept(suggestion: Suggestion): void {
    if (!this.studentId) {
      return;
    }
    this.api
      .acceptAssignment({
        studentId: this.studentId,
        professorId: suggestion.professorId,
        score: suggestion.score,
        reason: suggestion.reason,
      })
      .subscribe({
        next: () => {
          this.message.set(`Assigned ${suggestion.professorName}`);
          this.suggest();
          this.loadAccepted();
        },
        error: () => this.error.set('Accept failed'),
      });
  }

  private loadAccepted(): void {
    if (!this.studentId) {
      return;
    }
    this.api.listAssignments(this.studentId).subscribe({
      next: (data) => this.accepted.set(data),
    });
  }
}
