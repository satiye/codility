package main.lesson08;

/*
 * Since two sequences have leaders of the same value, the leader value is the leader of the array.
 * That is, only the leader of the whole array can be an equi leader. 
 * 
 * Based on this, first find the leader of the array(if any). 
 * If there is no leader, there won't be no equi leader. So, just return 0.
 * 
 * After finding a leader, scan the whole array again,  
 * 			count the occurrence of the leader at the current scanning position(i), comparing if the position can be an equi leader or not.
 */
public class EquiLeader {
	public int solution(int[] A) {
        int N = A.length;
        if(N == 1){
            return 0;
        }

        int size = 0;
        int candidate = -1;
        for(int i=0; i < N; i++){
            if(size == 0){
            	candidate = A[i];
                size++;
            }else{
                if(A[i] == candidate){
                    size++;
                }else{
                    size--;
                }
            }
        }

        if (size == 0) {
        	return 0;
        }
        
        int leaderCount = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                leaderCount++;
            }
        }
        
        if (leaderCount <= N / 2){
            return 0;
        }
        

        int leader = candidate;
        int count = 0;
        int equiCount = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == leader) {
                count++;
            }

            if((count > (i + 1) / 2) &&  ((leaderCount - count) > (N - (i + 1)) / 2))
                equiCount += 1;
        }
        
        return equiCount; 
    }
}
