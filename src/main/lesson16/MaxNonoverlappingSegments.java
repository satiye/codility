package main.lesson16;
/*
 * The segments are sorted by their ends, so the first segment will always be the first one.
 * Then increase count when encounter with segment whose start comes after ending previous
 */
public class MaxNonoverlappingSegments {
	 public int solution(int[] A, int[] B) {
	        int N = A.length;
	        if(N<1){
	            return 0;
	        }

	        int nonOverLappingCount = 1;
	        int prevEnd = B[0];

	        for(int i=1; i < N; i++){
	            if(A[i] > prevEnd){
	                nonOverLappingCount++;
	                prevEnd = B[i];
	            }
	        }

	        return nonOverLappingCount;
	    }
}
