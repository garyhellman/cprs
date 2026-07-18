import { Routes } from '@angular/router';
import { AssignmentsPage } from './features/assignments/assignments.page';
import { ProfessorsPage } from './features/professors/professors.page';
import { ReviewsPage } from './features/reviews/reviews.page';
import { StudentsPage } from './features/students/students.page';
import { UniversitiesPage } from './features/universities/universities.page';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'assignments' },
  { path: 'universities', component: UniversitiesPage },
  { path: 'professors', component: ProfessorsPage },
  { path: 'students', component: StudentsPage },
  { path: 'reviews', component: ReviewsPage },
  { path: 'assignments', component: AssignmentsPage },
];
