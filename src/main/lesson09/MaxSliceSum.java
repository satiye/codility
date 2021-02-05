package main.lesson09;
/*
 * For each position, compute the largest sum that ends in that position. 
 * If the max value of the slice that can end at the previous position is smaller than 0, then the value should start with current position.
 * (Since negative values will not contribute to largest sum)
 */
public class MaxSliceSum {
	public int solution(int[] A) {
        if(A.length == 1) 
            return A[0];

        int maxEnding=A[0];
        int maxSlice=A[0];
        
        for(int i=1; i < A.length; i++){
            if (maxEnding < 0) {
            	maxEnding = 0;
            }
				
            maxEnding += A[i];
            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }
}
