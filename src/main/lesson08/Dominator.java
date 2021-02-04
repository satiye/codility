package main.lesson08;

/*
 * Finding dominator is equals to finding leader.
 * After removing all pairs of different elements, remaining values are  all the same. 
 * If the sequence contains a leader, this value is a candidate for the leader. 
 * 
 * Finally, iterate through all the elements and check if this value is really a leader(its occurrence > N/2)
 */
public class Dominator {
	public int solution(int[] A) {
        int size = 0;
        int candidate = 0;
        for(int i=0; i < A.length; i++){
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

        int dominator = -1;
        if(size > 0){
            int count = 0;
            int index = -1;
            for(int i=0; i < A.length; i++){
                if(A[i] == candidate){
                    count++;
                    index = i;
                }
            }

            if(count > A.length/2){
                dominator = index;
            }
        }

        return dominator;
    }
}
