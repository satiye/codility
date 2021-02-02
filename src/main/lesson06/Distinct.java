package main.lesson06;
/*
 * Put all the array values in a set, and the set size is the required value.
 */
import java.util.*;
public class Distinct {
	public int solution(int[] A) {
        Set<Integer> distictNumbersSet = new HashSet<Integer>();

        for(int i=0; i < A.length; i++){
            distictNumbersSet.add(A[i]);
        }

        return distictNumbersSet.size();
    }
}
