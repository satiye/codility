package main.lesson11;
/*
 * Use the sieve algorithm for factorization. 
 * For every crossed number, remember the smallest prime that divides this number. (F)
 * 
 * With this approach, every number holds one of its  prime factors.
 * If the number is divided by with this prime factor and the resulting number is prime(can be checked from F). Then, the number is semiprime.
 * 
 * To compute range queries faster, prepare prefix sum of each number holds how many semiprime number exists up to that number. (prefixSum)
 * Finally, compute queries very fast.
 * 
 */
public class CountSemiprimes {
	public int[] solution(int N, int[] P, int[] Q) {
        int [] F =  new int[N+1];
       
        for(int i=2; i*i <= N; i++){
            if(F[i] == 0){
                int k = i*i;
                while(k <= N){
                    if(F[k] == 0){
                        F[k] = i;
                    }
                    k += i;
                }
            }
        }

        boolean[] isSemiPrime = new boolean[N+1];
        isSemiPrime[0] = false;
        isSemiPrime[1] = false;

        for(int i=2; i < N+1; i++){
            if(F[i] == 0){
                isSemiPrime[i] = false;
            }else{
                isSemiPrime[i] = (F[i/F[i]] == 0) ? true : false;
            }
        }

        int[] prefixSum = new int[N+1];
        prefixSum[0] = 0;
        prefixSum[1] = 0;

         for(int i=2; i < N+1; i++){
             prefixSum[i] = (isSemiPrime[i] == true) ? prefixSum[i-1]+1 : prefixSum[i-1];
         }


        int[]  result = new int[P.length];

         for(int i=0; i < P.length; i++){
             result[i] = prefixSum[Q[i]] - prefixSum[P[i]-1];
         }

         return result;
    }
}
