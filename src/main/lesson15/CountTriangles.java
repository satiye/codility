package main.lesson15;
/*
 * sort an array and be careful for overflow
 * the triangles rule for sorted array:
 * 		check if A[P] + A[Q] > A[R], because it is always A[P] <= A[Q] <= A[R]. A[P] < A[Q] + A[R] and A[R] + A[P] > A[Q] are always hold.
 * 
 * one way: two pointer technique: go from left and right, If triangle rule is satisfied then add that number to count
 * 
 * second way: Caterpillar method: hold P as constant and slide Q and R, check triangle condition
 */
import java.util.*;
public class CountTriangles {
	public int solution(int[] A) {
        int n = A.length; 
        Arrays.sort(A); 
        int count = 0; 
  
        for (int i = n - 1; i >= 1; i--) { 
            int l = 0, r = i - 1; 
            while (l < r) { 
                if (A[l] + A[r] > A[i]) {         
                    count += r - l; 
                    r--; 
                }else { 
                    l++; 
                } 
            } 
        } 

        return count;
        
	}
	
	public int alternativeSolution(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int count = 0;

        for(int P = 0; P < N-2; P++){
            int Q = P + 1;
            int R = P + 2;

            while(R < N){
                if(A[P] > A[R] - A[Q]){
                    count += R - Q;
                    R++;
                }else{
                    Q++;
                    if(Q==R){
                        R++;
                    }
                }
            }
        }

        return count;
    }
}
