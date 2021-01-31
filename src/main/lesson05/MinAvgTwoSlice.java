package main.lesson05;

/*
 * 
 * The slices are a minimum length of 2. 
 * The trick to this problem is that the minimum average slice also cannot be longer than 3. 
 * So we only have to calculate the average of the slices of length 2 and 3.
 * 
 * No matter which way we split up this array, 
 * if the slices aren't exactly the same, then one of them must have a lower average than the full slice.
 */
public class MinAvgTwoSlice {
	 public int solution(int[] A) {
		 int N = A.length;
		 double minAvg = Integer.MAX_VALUE;
		 int startIndex = 0;
	    
		 for(int i=0; i<N-2; i++) {
			 if((A[i]+A[i+1]) / 2.0 < minAvg) {
	             minAvg = (A[i]+A[i+1]) / 2.0;
	             startIndex = i;
			 }
	    
			 if((A[i]+A[i+1]+A[i+2]) / 3.0 < minAvg)  {
	              minAvg = (A[i]+A[i+1]+A[i+2]) / 3.0;
	              startIndex = i;
			 }
		 }

		 if((A[N-2]+A[N-1]) / 2.0 < minAvg) {
	        minAvg = (A[N-2]+A[N-1]) / 2.0;
	        startIndex = N-2;
		 }
	    
	     return startIndex;
	}
}
