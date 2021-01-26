package main.lesson03;

/* 
  After sorting the array, each index will hold 1 element more than itself. 
  So, element in 0.index should be 1, element in 1.index should be 2.

 The element that breaks this rule is the searched element. If no element breaks, the largest element, N + 1, is missing.
*/

/*
   Arrayi sıraladıktan sonra her index kendinden 1 fazla elemanı tutar durumuna gelir. 
   Yani, 0.indexteki eleman 1, 1.indexteki eleman 2 olmalı

   Bu kuralı bozan eleman aranan elemandır. Hiçbir eleman bozmuyorsa en büyük eleman yani N+1 eksiktir.
 */
import java.util.*;
public class PermMissingElem {
	public int solution(int[] A) {
		Arrays.sort(A);
        int N = A.length;

        for(int i=0; i < N; i++){
            if(A[i] - i != 1){
                return i + 1;
            }
        }

        return N + 1;
    }
}
