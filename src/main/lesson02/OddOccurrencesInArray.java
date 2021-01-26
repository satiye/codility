package main.lesson02;

import java.util.HashSet;
import java.util.Set;

/* 
   It is checked whether each of the array elements is in the set. 
   	- If set contains an array element, the element is removed from the set. 
   	- If set does not contain an array element, it is added to the set.

  After all the elements are finished, the only element left in the set will be the desired element in the question.
 */

/*
  Array elamanlarının her biri set içerisinde olup olmadığı kontrol edilir. 
   - Set array elemanını içeriyorsa eleman setten silinir. 
   - Set array elemanını içermiyorsa sete eklenir.

  Tüm elemanlar bittikten sonra sette kalan tek eleman soruda istenilen eleman olacaktır.
  
 */

public class OddOccurrencesInArray {
	public int solution(int[] A) {
		Set<Integer> mySet = new HashSet<Integer>();
		
		int result = 0;
        for(int i=0; i < A.length; i++){
            if(mySet.contains(A[i])){
                mySet.remove(A[i]);
            }else{
                mySet.add(A[i]);
            }
        }

       int oddInteger = -1;
       for (int i : mySet) {
           oddInteger = i;
       }
        
       return oddInteger;
    }
}
