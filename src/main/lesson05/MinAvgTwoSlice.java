package main.lesson05;

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
