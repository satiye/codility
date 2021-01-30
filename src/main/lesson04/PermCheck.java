package main.lesson04;

/*
 * 
 * track all the elements of the array if they appear, set the corresponding value in boolean array as true.
 * if element is greater then length or it has been seen before, return 0
 * otherwise check if all the elements in boolean array is true or not
 */
public class PermCheck {
	public int solution(int[] A) {
		int N = A.length;
		boolean[] elements = new boolean[N];

        for(int i=0; i < N; i++){
            if(A[i] > N || elements[A[i]-1] == true){
                return 0;
            }
            elements[A[i]-1] = true;
        }

        for(int i=0; i < N; i++){
            if(elements[i] == false)
                return 0;
        }
        return 1;
    }
}
