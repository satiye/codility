package main.lesson04;

public class PermCheck {
	public int solution(int X, int[] A) {
		int N = A.length;
		boolean [] appeared = new boolean[X];
		int leafCount = 0;
		
		for(int i=0; i < N; i++) {
			if(A[i] > 0 && A[i] < X) {
				if(appeared[A[i] -1] == false) {
					appeared[A[i] -1] = true;
					leafCount++;
					if(leafCount == X) {
						return i;
					}
				}
			}
		}
		
		return -1;
    }
}
