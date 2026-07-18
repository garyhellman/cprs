import { CommonModule } from '@angular/common';
import { Component, OnInit, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../core/api.service';
import { University } from '../../core/models';

@Component({
  selector: 'app-universities-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './universities.page.html',
  styleUrl: './universities.page.css',
})
export class UniversitiesPage implements OnInit {
  private readonly api = inject(ApiService);

  readonly items = signal<University[]>([]);
  readonly error = signal<string | null>(null);
  readonly loading = signal(false);

  name = '';
  code = '';
  country = '';

  ngOnInit(): void {
    this.reload();
  }

  reload(): void {
    this.loading.set(true);
    this.error.set(null);
    this.api.listUniversities().subscribe({
      next: (data) => {
        this.items.set(data);
        this.loading.set(false);
      },
      error: () => {
        this.error.set('Could not load universities. Is the API running?');
        this.loading.set(false);
      },
    });
  }

  create(): void {
    if (!this.name.trim()) {
      return;
    }
    this.api
      .createUniversity({
        name: this.name.trim(),
        code: this.code.trim() || null,
        country: this.country.trim() || null,
      })
      .subscribe({
        next: () => {
          this.name = '';
          this.code = '';
          this.country = '';
          this.reload();
        },
        error: () => this.error.set('Create failed'),
      });
  }
}
