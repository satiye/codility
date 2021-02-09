package main.lesson14;

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
