package main.lesson14;

/*
 * Binary search with min sum block is the biggestElement, max sum block is the sum of all elements
 * 
 */
public class MinMaxDivision {
	public int solution(int K, int M, int[] A) {
        int minSum = 0;
        int maxSum = 0;

        for(int i=0; i<A.length; i++){
            maxSum += A[i];
            minSum = Math.max(minSum, A[i]);
        }

        int minMaxSum = maxSum;
        while(minSum <= maxSum){
            int midSum = minSum + (maxSum-minSum)/2;

            if(checkDivision(midSum, K, A)){ //succeed
                minMaxSum = midSum;
                maxSum = midSum - 1;  //try the block sum with a smaller one  
            }else{ //failed
               minSum = midSum + 1; //try the block sum with a bigger one
            }
        }

        return minMaxSum;
    }
    //check if A can be divided by using the expectedMaxSum into allowedBlock blocks
    private boolean checkDivision(int expectedMaxSum, int allowedBlock, int[] A){
        int currentSum = 0;

        for(int i=0; i < A.length; i++){
            currentSum += A[i];

            if(currentSum > expectedMaxSum){ //means: need one more block
                allowedBlock--;
                currentSum = A[i]; //send A [i] to other block
            }

            // When I add A [i], there is a separate block need for the exceeding part because it passes expectedMaxSum.
            if(allowedBlock == 0){
                return false;
            }
        }

        //if I have divided A into allowedBlock blocks that do not exceed the expectedMaxSum, the remaining blocks may be empty 
        return true;
    }
}
