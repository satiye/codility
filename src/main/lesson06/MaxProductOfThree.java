package main.lesson06;

/*
 * Since array contains negative integers also, the maximum product of three numbers will be
 * either product of two minimum negative integers and one biggest positive integer
 * or, three biggest positive integers
 */

import java.util.*;
public class MaxProductOfThree {
	 public int solution(int[] A) {
	    int N = A.length;

	    Arrays.sort(A);

	    return Math.max(A[0]*A[1]*A[N-1], A[N-1]*A[N-2]*A[N-3]);
	 }
}
