package main.lesson14;
/*
 *
 * Binary search on how many nails are needed.(beg:1, end:M)
 * 
 * In each search, create prefix_sum[] with used nail size(mid), and then add 1 to prefix_sum[i] if there is any new nail found at the position 'i'
 * Then compute the total number of nails found so far from start to end of planks
 * 
 * Use this prefix_sum to check if all planks can be nailed with this amount of nail.
 *  - if succeed, set answer and search for smallest number of nail
 *  - if failed, try with bigger amount of nail
 */
public class NailingPlanks {
	public int solution(int[] A, int[] B, int[] C) {
        int N = A.length;
        int M = C.length;
    
        int beg = 1;
        int end = M;
        int answer = -1;

        while(beg <= end){
            int mid = beg + (end - beg)/2;

            int[] prefixSum = new int[2*M+1];
            for(int i=0; i<mid; i++){
                prefixSum[C[i]]++;
            }

            for(int i=1; i<=2*M; i++){
                prefixSum[i]+=prefixSum[i-1];
            }

            boolean failed = false;
            for(int i=0;i<N; i++){
                if(prefixSum[B[i]]-prefixSum[A[i]-1]==0)
                    failed = true;
            }

            if(failed){
                beg = mid+1;
            }else{
                answer = mid;
                end = mid-1;
            }

        }

        return answer;
    }
}
