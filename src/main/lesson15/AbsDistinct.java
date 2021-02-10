package main.lesson15;
/*
 * One way: use set to hold absolute value of each integer. Then return set size which is the number of distinct absolute values
 * 
 * Alternative way: 
 * 		use two pointers from start and end compare absolute values and count unique values
 * Be careful in alternative way: Since you are making comparison
 *      - Math.abs(x), If x is equal to the value of Integer.MIN_VALUE(−2,147,483,648), the result is that same value(−2,147,483,648), which is negative.
 */
import java.util.*;
public class AbsDistinct {
	public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < A.length; i++){
            set.add(Math.abs(A[i]));
        }

        return set.size();
    }
	
	public int alternativeSolution(int[] A) {
        int N = A.length;
        int count = 0;

        int start=0;
        int end=N-1;

        while(start<=end){
            if(start>0 && A[start] == A[start-1]){
                start++;
                continue;
            } 
            if(end<N-1 && A[end] == A[end+1]){
                end--;
                continue;
            }

            long absStart = Math.abs(Long.valueOf(A[start]));
            long absEnd = Math.abs(Long.valueOf(A[end]));

            if(absStart > absEnd){
                start++;
            }else if(absStart < absEnd){
                end--;
            }else{
                start++;
                end--;
            }

            count++;
        }

        return count;
    }
}
