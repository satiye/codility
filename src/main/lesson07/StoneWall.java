package main.lesson07;

/*
 * Finding the minimum blocks required to construct a stone wall
 * 
 * 1. If the current height is less than the previous height, remove the stack until it is higher 
 *    (If the current height is low based on the previous height of the stone wall, 
 *       the reference point is lowered based on the current height, and the previous height is removed as a separate block.)
 *       
 * 2. If the current height is higher than the previous height, the count increases, the stack is added. 
 *    
 *   
 * If the current height and the previous block are the same, it can be combined into the same block, so it is kept.  
 *   
 *   
 */
import java.util.*;
public class StoneWall {
	public int solution(int[] H) {
        Stack<Integer> stones = new Stack<>();
        int neededBlocks = 0;

        for(int i=0; i<H.length; i++){
            while(!stones.isEmpty() && stones.peek() > H[i]){
                stones.pop();
            }

            if(stones.isEmpty() || stones.peek() < H[i]){
                stones.push(H[i]);
                neededBlocks++;
            }
        }

        return neededBlocks;
    }
}
