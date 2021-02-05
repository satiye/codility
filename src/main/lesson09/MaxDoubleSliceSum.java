package main.lesson09;
/*
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * X is the starting index, Z is the ending index.
 * Task is to find max sum for different Y values
 * 
 * First, compute the maximum ending at each index for the left-side slice - maxEndingIndex
 * Second, compute the maximum ending at each index for the right-side slice - maxStartingIndex
 * Then, move Y to find maximum double slice sum
 * 
 * A                = { 3,  2,  6, -1,  4,  5, -1, 2 }
 * maxEndingIndex   = { 0,  2,  8,  7, 11, 16, 15, 0 }
 * maxStartingIndex = { 0, 16, 14,  8,  9,  5,  0, 0 }
 * 
 * Example: Y=3, maximum double slice sum is maxEndingIndex[Y-1] + maxStartingIndex[Y+1] = 8 + 9 = 17 (triplet (X, Y, Z)=(0, 3, 6))
 * 
 */

public class MaxDoubleSliceSum {
	public int solution(int[] A) {
        int N = A.length;
        int[] maxEndingIndex = new int[N];
        int[] maxStartingIndex = new int[N];

        for(int i=1; i<N-1; i++){
            maxEndingIndex[i] = Math.max(0, maxEndingIndex[i-1]+A[i]);
        }

        for(int i=N-2; i>0; i--){
            maxStartingIndex[i] = Math.max(0, maxStartingIndex[i+1]+A[i]);
        }

        int maxSlice = 0;

        for(int i=N-2; i>0; i--){
            maxSlice = Math.max(maxSlice, maxEndingIndex[i-1] + maxStartingIndex[i+1]);
        }

        return maxSlice;
    }
}
