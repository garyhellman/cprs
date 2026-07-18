import { CommonModule } from '@angular/common';
import { Component, OnInit, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../core/api.service';
import { Professor, Student, StudentReview } from '../../core/models';

@Component({
  selector: 'app-reviews-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reviews.page.html',
  styleUrl: './reviews.page.css',
})
export class ReviewsPage implements OnInit {
  private readonly api = inject(ApiService);

  readonly students = signal<Student[]>([]);
  readonly professors = signal<Professor[]>([]);
  readonly items = signal<StudentReview[]>([]);
  readonly error = signal<string | null>(null);

  studentId: number | null = null;
  professorId: number | null = null;
  title = '';
  body = '';
  rating: number | null = 5;

  ngOnInit(): void {
    this.api.listStudents().subscribe({
      next: (data) => {
        this.students.set(data);
        if (data.length) {
          this.studentId = data[0].id;
        }
      },
    });
    this.api.listProfessors().subscribe({
      next: (data) => {
        this.professors.set(data);
        if (data.length) {
          this.professorId = data[0].id;
        }
      },
    });
    this.reload();
  }

  reload(): void {
    this.api.listReviews().subscribe({
      next: (data) => this.items.set(data),
      error: () => this.error.set('Could not load reviews'),
    });
  }

  create(): void {
    if (!this.studentId || !this.professorId || !this.title.trim()) {
      return;
    }
    this.api
      .createReview({
        studentId: this.studentId,
        professorId: this.professorId,
        title: this.title.trim(),
        body: this.body,
        rating: this.rating,
        status: 'SUBMITTED',
      })
      .subscribe({
        next: () => {
          this.title = '';
          this.body = '';
          this.reload();
        },
        error: () => this.error.set('Create failed'),
      });
  }
}
