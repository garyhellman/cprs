import { CommonModule } from '@angular/common';
import { Component, OnInit, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../core/api.service';
import { Student, University } from '../../core/models';

@Component({
  selector: 'app-students-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './students.page.html',
  styleUrl: './students.page.css',
})
export class StudentsPage implements OnInit {
  private readonly api = inject(ApiService);

  readonly universities = signal<University[]>([]);
  readonly items = signal<Student[]>([]);
  readonly error = signal<string | null>(null);

  universityId: number | null = null;
  firstName = '';
  lastName = '';
  email = '';
  department = '';
  yearLevel: number | null = 3;
  interests = '';

  ngOnInit(): void {
    this.api.listUniversities().subscribe({
      next: (data) => {
        this.universities.set(data);
        if (data.length) {
          this.universityId = data[0].id;
        }
        this.reload();
      },
      error: () => this.error.set('Could not load universities'),
    });
  }

  reload(): void {
    this.api.listStudents(this.universityId ?? undefined).subscribe({
      next: (data) => this.items.set(data),
      error: () => this.error.set('Could not load students'),
    });
  }

  create(): void {
    if (!this.universityId || !this.firstName || !this.lastName || !this.email) {
      return;
    }
    this.api
      .createStudent({
        universityId: this.universityId,
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        department: this.department || null,
        yearLevel: this.yearLevel,
        interests: this.interests || null,
      })
      .subscribe({
        next: () => {
          this.firstName = '';
          this.lastName = '';
          this.email = '';
          this.department = '';
          this.interests = '';
          this.reload();
        },
        error: () => this.error.set('Create failed'),
      });
  }
}
