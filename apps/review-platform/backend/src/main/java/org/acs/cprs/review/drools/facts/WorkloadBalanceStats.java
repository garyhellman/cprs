package org.acs.cprs.review.drools.facts;

/**
 * Peer workload snapshot for equalizing how many students each professor is assigned.
 */
public class WorkloadBalanceStats {

    private int minActiveReviewCount;
    private int maxActiveReviewCount;
    private int candidateCount;

    public WorkloadBalanceStats() {
    }

    public WorkloadBalanceStats(int minActiveReviewCount, int maxActiveReviewCount, int candidateCount) {
        this.minActiveReviewCount = minActiveReviewCount;
        this.maxActiveReviewCount = maxActiveReviewCount;
        this.candidateCount = candidateCount;
    }

    public int getMinActiveReviewCount() {
        return minActiveReviewCount;
    }

    public void setMinActiveReviewCount(int minActiveReviewCount) {
        this.minActiveReviewCount = minActiveReviewCount;
    }

    public int getMaxActiveReviewCount() {
        return maxActiveReviewCount;
    }

    public void setMaxActiveReviewCount(int maxActiveReviewCount) {
        this.maxActiveReviewCount = maxActiveReviewCount;
    }

    public int getCandidateCount() {
        return candidateCount;
    }

    public void setCandidateCount(int candidateCount) {
        this.candidateCount = candidateCount;
    }

    public int getSpread() {
        return Math.max(0, maxActiveReviewCount - minActiveReviewCount);
    }
}
