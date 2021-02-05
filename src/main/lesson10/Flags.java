package main.lesson10;
/*
 * 
 * Create an array(next) that holds the next peek on the right side of the array at each index
 * iterate through all the indices in reverse order and remember the earliest peak.
 * 
 * Start from the 1st peak and then pick up the nearest peek that satisfies the given constraint.
 * if a flag is set at position pos then the next flag can only be set in positions pos + i(can be found from array next)
 * 
 * It is enough to check if k flags can be set or not.
 * 
 */

public class Flags {
	public int solution(int[] A) {
        int N = A.length;
        if (N < 3){
            return 0;
        }
        
        int[] next = new int[N];
        next[N - 1] = -1; //-1 stands for there is no more peek.
        //iterate in reverse order and remember the earliest peak
        int i;
        for (i = N - 2; i > 0; i--){
            if (A[i - 1] < A[i] && A[i] > A[i + 1]){
                next[i] = i;
            }
            else {
                next[i] = next[i + 1];
            }
        }
        next[0] = next[1];
       
        //now let's check
        int maxFlag=0; 
        for (i = 1; (i-1)*i <= N ; i++){
            int pos = 0;
            int num = 0;
            while (pos < N && num < i){
                pos = next[pos];
                //we don't have any more peek. exit this loop.
                if (pos == -1){
                    break;
                }
                //set a flag at the pos. 
                //increment pos to seek the next peek
                num++;
                pos += i;
            }
        
            maxFlag = Math.max(maxFlag, num);
        }
        
        return maxFlag;
    }
}
