package main.lesson04;

/*
 * Existence of integers 1 to N should be checked by using boolean exist array.
 * For each array value exist array should be updated. No need to consider values less than 0 or greater than length
 */
public class MissingInteger {
	public int solution(int[] A) {
		int N = A.length;
        boolean[] exist = new boolean[N+1];

       for(int i=0; i < N; i++){
           if(A[i] > 0 && A[i] < N+1){
               exist[A[i] -1] = true;
           }
       }

       for(int i=0; i < N+1; i++){
           if(!exist[i]){
               return i+1;
           }
       }

       return -1;
    }
}
