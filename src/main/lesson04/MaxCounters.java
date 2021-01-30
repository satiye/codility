package main.lesson04;

/*
 * Problem can be solved efficiently by tracking lastUpdated value. It is set when all values needed to be updated. 
 * When a single value needed to be incremented, first check if before it needed to be updated(its value less than lastUpdated), then update accordingly
 * 
 *
 */

public class MaxCounters {
	public int[] solution(int N, int[] A) {
        int[] output = new int[N];
        int maxCounter = 0;
        int lastUpdate = 0;

        for(int i=0; i < A.length; i++){
            if(A[i] == N+1){
                lastUpdate = maxCounter;
            }else{
                if(output[A[i] - 1] < lastUpdate){
                     output[A[i] - 1] = lastUpdate;
                }
                output[A[i] - 1]++;
                maxCounter = Math.max(maxCounter, output[A[i] - 1]);
            }
        }

        for(int i=0; i < N; i++){
            if(output[i] < lastUpdate){
                output[i] = lastUpdate;
            }
        }

        return output;
    }
}
