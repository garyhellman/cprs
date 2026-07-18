import { CommonModule } from '@angular/common';
import { Component, OnInit, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../core/api.service';
import { Professor, University } from '../../core/models';

@Component({
  selector: 'app-professors-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './professors.page.html',
  styleUrl: './professors.page.css',
})
export class ProfessorsPage implements OnInit {
  private readonly api = inject(ApiService);

  readonly universities = signal<University[]>([]);
  readonly items = signal<Professor[]>([]);
  readonly error = signal<string | null>(null);

  universityId: number | null = null;
  firstName = '';
  lastName = '';
  email = '';
  department = '';
  researchAreas = '';
  seniority: Professor['seniority'] = 'JUNIOR';

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
    this.api.listProfessors(this.universityId ?? undefined).subscribe({
      next: (data) => this.items.set(data),
      error: () => this.error.set('Could not load professors'),
    });
  }

  create(): void {
    if (!this.universityId || !this.firstName || !this.lastName || !this.email) {
      return;
    }
    this.api
      .createProfessor({
        universityId: this.universityId,
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        department: this.department || null,
        researchAreas: this.researchAreas || null,
        seniority: this.seniority,
      })
      .subscribe({
        next: () => {
          this.firstName = '';
          this.lastName = '';
          this.email = '';
          this.department = '';
          this.researchAreas = '';
          this.reload();
        },
        error: () => this.error.set('Create failed'),
      });
  }
}
