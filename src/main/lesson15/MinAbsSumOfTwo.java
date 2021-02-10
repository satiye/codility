package main.lesson15;
/*
 * Goal is to find two values whose sum is as close as 0.
 * So, if sum of two values > 0: slide right pointer and try to make sum smaller
 *     if sum of two values < 0: slide left pointer and try to make sum bigger
 *     if sum of two values = 0: then return
 * 
 */
import java.util.*;

public class MinAbsSumOfTwo {
	public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int minAbsSum = Math.abs(A[0]+A[0]);

        int left = 0;
        int right = N-1;

        while(left <= right){
            minAbsSum = Math.min(minAbsSum, Math.abs(A[left]+A[right]));
            
            if(A[left]+A[right] > 0){
                right--;
            }else if(A[left]+A[right] < 0){
                left++;
            }else{
                return 0;
            }
        }

        return minAbsSum;
    }
}
