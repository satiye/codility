package main.lesson07;

/*
 * use stack to hold down stream fishes.
 * if a fish goes to upstream, check stack size
 * 		- if no fishes goes to downstream(i.e. stack is empty) increase live fish count. That is, that fish will be alive.
 * 		- if there are fishes go to downstream check sizes of the fishes and determine who will alive.
 * 				*if upstream flowing fish eats all the downstream flowing fishes, increase live fish count
 * 				*if downstream flowing fishes eat the upstream flowing one, pop fish from stack.(do it until no more fish can be eaten)
 * 
 */

import java.util.*;
public class Fish {
	public int solution(int[] A, int[] B) {
        Stack<Integer> downstreamFishes = new Stack<>();
        int liveFishCount = 0;

        for(int i=0; i < A.length; i++){
            if(B[i] == 0){                
                if(downstreamFishes.size() != 0){
                    while(downstreamFishes.size() != 0 && A[i] > downstreamFishes.peek()){
                        downstreamFishes.pop();
                    }

                    if(downstreamFishes.size() == 0){
                        liveFishCount++;
                    }
                }else{
                    liveFishCount++;
                }
            }else{
                downstreamFishes.push(A[i]);
            }
        }

        liveFishCount += downstreamFishes.size();

        return liveFishCount;

    }
}
