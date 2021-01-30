package main.lesson03;

/* 
  Two different arrays can be defined in which the sums of the left and right elements up to that element. 
  The minimum absolute difference between each mutual index element between these two arrays will be the desired difference.
*/


public class TapeEquilibrium {
	public int solution(int[] A) {
		int N = A.length;

        int[] leftSum = new int[N-1];
        int[] rightSum = new int[N-1];

        leftSum[0] = A[0];
        for(int i=1; i < N-1; i++){
            leftSum[i] = A[i] + leftSum[i-1];
        }

        rightSum[N-2] = A[N-1];
        for(int i=N-2; i > 0; i--){
            rightSum[i-1] = rightSum[i] + A[i];
        }

        int minDiff = Integer.MAX_VALUE;
        
        for(int i=0; i < N-1; i++){
            minDiff = Math.min(minDiff, Math.abs(leftSum[i] - rightSum[i]));
        }

        return minDiff;
    }
}
