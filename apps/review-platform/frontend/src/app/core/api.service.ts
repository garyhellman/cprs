import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import {
  Professor,
  ReviewAssignment,
  Student,
  StudentReview,
  SuggestAssignmentResponse,
  Suggestion,
  University,
} from './models';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private readonly http = inject(HttpClient);
  private readonly base = environment.apiBaseUrl;

  listUniversities(): Observable<University[]> {
    return this.http.get<University[]>(`${this.base}/universities`);
  }

  createUniversity(body: Partial<University>): Observable<University> {
    return this.http.post<University>(`${this.base}/universities`, body);
  }

  listProfessors(universityId?: number): Observable<Professor[]> {
    const params = universityId ? `?universityId=${universityId}` : '';
    return this.http.get<Professor[]>(`${this.base}/professors${params}`);
  }

  createProfessor(body: Record<string, unknown>): Observable<Professor> {
    return this.http.post<Professor>(`${this.base}/professors`, body);
  }

  listStudents(universityId?: number): Observable<Student[]> {
    const params = universityId ? `?universityId=${universityId}` : '';
    return this.http.get<Student[]>(`${this.base}/students${params}`);
  }

  createStudent(body: Record<string, unknown>): Observable<Student> {
    return this.http.post<Student>(`${this.base}/students`, body);
  }

  listReviews(): Observable<StudentReview[]> {
    return this.http.get<StudentReview[]>(`${this.base}/reviews`);
  }

  createReview(body: Record<string, unknown>): Observable<StudentReview> {
    return this.http.post<StudentReview>(`${this.base}/reviews`, body);
  }

  suggestAssignments(studentId: number, maxResults = 5): Observable<SuggestAssignmentResponse> {
    return this.http.post<SuggestAssignmentResponse>(`${this.base}/assignments/suggest`, {
      studentId,
      maxResults,
    });
  }

  acceptAssignment(body: {
    studentId: number;
    professorId: number;
    score?: number;
    reason?: string;
  }): Observable<ReviewAssignment> {
    return this.http.post<ReviewAssignment>(`${this.base}/assignments`, body);
  }

  listAssignments(studentId: number): Observable<ReviewAssignment[]> {
    return this.http.get<ReviewAssignment[]>(`${this.base}/assignments/student/${studentId}`);
  }
}
