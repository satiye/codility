package main.lesson06;

/*
 * !Edge cases should be considered carefully in this question.!
 * Array length should be at least 3, to be a triangle.
 * Length of the triangle cannot be 0.
 * After sorting array values, if sum of two values bigger than next value, triangle van be formed.
 * (A<B<C, it is known C+B>A, C+A>B. If A+B>C, then triangle can be formed.
 */

import java.util.*;
public class Triangle {
	public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 2; i < A.length; ++i) {
            if (A[i] > 0 && A[i - 2] > A[i] - A[i - 1]) {
              return 1;        
            }
        }
        return 0;
    }

}
