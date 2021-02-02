package main.lesson06;

/*
 * Construct two arrays:
 * 	first holds the opening points of the discs, second holds the closing points of the discs
 * 
 * After sorting starts and end points of the discs, track the number of open disc
 * (since every open disc after that will be intersect with that)
 * Then, if disc is closed decrease the open disc count. 
 * 
 */

import java.util.*;
public class NumberOfDiscIntersections {
	 public int solution(int[] A) {
	        int N = A.length;
	        int[] starts = new int[N];
	        int[] ends = new int[N];

	        for(int i=0; i < N; i++){
	            starts[i] = i - A[i]; 
	            ends[i] = (Integer.MAX_VALUE - A[i] < i) ? Integer.MAX_VALUE : i + A[i];
	        }

	        Arrays.sort(starts);
	        Arrays.sort(ends);

	        int openCount = 0;
	        int intersectCount = 0;

	        int openIndex = 0;
	        int closeIndex = 0;

	        while(openIndex < N){
	            if(starts[openIndex] <= ends[closeIndex]){
	                intersectCount+=openCount;
	                if(intersectCount > 10000000){
	                    return -1;
	                }
	                openCount++;
	                openIndex++;
	            }else{
	                openCount--;
	                closeIndex++;
	            }
	        }

	        return intersectCount;
	    }
}
