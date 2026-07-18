export interface University {
  id: number;
  name: string;
  code?: string | null;
  country?: string | null;
  createdAt?: string;
}

export interface Professor {
  id: number;
  universityId: number;
  firstName: string;
  lastName: string;
  email: string;
  department?: string | null;
  researchAreas?: string | null;
  seniority: 'JUNIOR' | 'SENIOR' | 'TENURED';
  maxActiveReviews: number;
  activeReviewCount: number;
}

export interface Student {
  id: number;
  universityId: number;
  firstName: string;
  lastName: string;
  email: string;
  department?: string | null;
  yearLevel?: number | null;
  interests?: string | null;
}

export interface StudentReview {
  id: number;
  studentId: number;
  professorId: number;
  universityId: number;
  title: string;
  body?: string | null;
  rating?: number | null;
  status: 'DRAFT' | 'SUBMITTED' | 'PUBLISHED';
  submittedAt?: string | null;
}

export interface Suggestion {
  professorId: number;
  professorName: string;
  score: number;
  reason: string;
}

export interface SuggestAssignmentResponse {
  studentId: number;
  suggestions: Suggestion[];
}

export interface ReviewAssignment {
  id: number;
  studentId: number;
  professorId: number;
  universityId: number;
  status: string;
  score: number;
  reason?: string | null;
  ruleTrace?: string | null;
}
