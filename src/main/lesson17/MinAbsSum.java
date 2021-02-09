package main.lesson17;
/*
 * First, replace all array element with its absolute values, and find maximum value(M) and sum of all elements(S)
 * Then, compute count occurrences of each element(count array)
 * 
 * The aim is to find out which number closest to half the total can be obtained from occurrences array(count)
 * Because in this case the other half takes the negative value and the absolute value will be the smallest.
 * 
 * Then create an array dp such that:
 * 		dp[j] = -1, sum j cannot be obtained from count array
 * 		dp[j] >=0, sum j can be obtained from count array
 * 
 * Initially dp[0] = 0, since 0 sum can always be obtained
 * Then, scan all the values i appearing in array A(values in count array such that count[i] > 0),
 * find how many i values remains after obtaining j where j goes to from 0 to half of the sum(S/2)(since it is enough to have S/2 from array elements to reach min absolute sum)
 *		- if dp[j] >= 0, means its not -1 and it has already been obtained from another previous j values. So need to use current j. Set it as   dp[j] = count[i]
 *      - else sum j can be obtained from i values if j>=i and j-i has enough i values that can be got (that is dp[j - i] > 0) 
 *
 *  Example: 
 *  A:     [1, 5, 2, -2],  S: 10,  M: 5
 *  count: [0, 1, 2, 0, 0, 1]  --> 1 occurs 1 times, 2 occurs 2 times, 5 occurs 1 times in A
 *  
 *  Let track dp array one by one: initially dp: [0, -1, -1, -1, -1, -1]
 *  i:0, count[0]=0
 *  i:1, count[1]=1 > 0,  dp: [1, 0, -1, -1, -1, -1] (After getting the sum of 0, 1 pieces of 1 remains) (After getting the sum of 1, 0 pieces of 1 remains) (other sums cannot be obtained from 1)
 *  i:2, count[2]=2 > 0,  dp: [2, 2,  1,  1,  0,  0] (After getting the sum of 0, 2 pieces of 2 remains) so on
 *  i:3, count[3]=0 
 *  i:4, count[4]=0 
 *  i:5, count[5]=1 > 0,  dp: [1, 1,  1,  1,  1,  1] 
 *  
 *  Finally look how close to S/2(half) sum obtained, and return minimum absolute sum
 */

import java.util.*;
public class MinAbsSum {
	public int solution(int[] A) {
        int N = A.length;
        int M = 0;
        int S = 0;

        for(int i=0; i < N; i++){
            A[i] = Math.abs(A[i]);
            M = Math.max(M, A[i]);
            S += A[i];
        }

        int[] count = new int[M+1];
        for(int i=0; i < N; i++){
            count[A[i]]++;
        }

        int half = S/2;
        int[]dp = new int[half+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 0; i < M+1; i++){
            if(count[i] > 0){
                for(int j=0; j <=half; j++){
                    if(dp[j] >=0){ // you already obtained them from prev values
                        dp[j] = count[i];
                    }else if(j >= i && dp[j - i] > 0){
                        dp[j] = dp[j - i] -1;
                    }
                }
            }
            
        }

        for(int i = half; i>0; i--){
            if(dp[i] >= 0){
                return S - 2 * i;
            }
        }

        return S;
    }
}
