package main.lesson15;
/*
 * Use upper bound M for track seen values of array elements
 * 
 * As every time we extend the range,  
 * 	  - all the possible length of the slices before extension((rightEnd - leftEnd) will have one more move
 *    - and one new slice(with itself)
 * So increase number of slice by (rightEnd - leftEnd + 1)
 * 
 * Example: M:6 A: [3, 4, 5, 5, 2]  
 * 			leftEnd:0, rightEnd:0, seen[3] = false, new slice number = 1 new Slice: (0, 0)
 *  		leftEnd:0, rightEnd:1, seen[4] = false, new slice number = 2 new Slice: (0, 1), (1, 1)
 *   		leftEnd:0, rightEnd:2, seen[5] = false, new slice number = 3 new Slice: (0, 2), (1, 2), (2, 2)
 *   		leftEnd:0, rightEnd:3, seen[5] = true,
 *    		leftEnd:1, rightEnd:3, seen[5] = true,
 *        	leftEnd:2, rightEnd:3, seen[5] = true,
 *        	leftEnd:3, rightEnd:3, seen[5] = false, new slice number = 1 new Slice: (3, 3)
 *          leftEnd:3, rightEnd:4, seen[2] = false, new slice number = 2 new Slice: (3, 4),  (4, 4)
 * 
 */
public class CountDistinctSlices {
	public int solution(int M, int[] A) {
        boolean[] seen = new boolean[M+1];
        
        int leftEnd=0;
        int rightEnd=0;
        int numSlice =0;
        
        while(leftEnd < A.length && rightEnd < A.length){
            if(!seen[A[rightEnd]]){ 
                // there could be (rightEnd - leftEnd + 1) combinations (be careful)
                numSlice = numSlice + (rightEnd - leftEnd + 1);
                if(numSlice >= 1000000000)
                    return 1000000000;
                
                seen[A[rightEnd]] = true;
                rightEnd++; 
            }else{ 
                seen[A[leftEnd]] = false;
                leftEnd++;
            } 
        }
        
        return numSlice;
    }
}
