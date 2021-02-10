package main.lesson16;
/*
 *
 * Use the greedy algorithm to traverse the array A. 
 * Tie adjacent ropes until the length of the new rope after being tied is not less than K. 
 * At this time, the new rope meets the conditions, and the final number of ropes is increased by one. 
 * Then restart the next judgment.
 */
public class TieRopes {
	public int solution(int K, int[] A) {
        int N = A.length;
        int ropeCount = 0;
        int currentSum = 0;
        
        for(int i=0; i < N; i++){
            currentSum += A[i];
            if(currentSum >=K){
                currentSum = 0;
                ropeCount++;
            }
        }
        
        return ropeCount;
    }
}
