package main.lesson04;

/*
 * Numbers from 1 to X should be tracked in array values. 
 * If all the numbers appear in array that index should be returned. If not,  -1 should be returned value.
 * 
 * 
 * 1'den X'e kadar olan sayıların dizi değerlerinde görülüp görülmediği kontrol edilmelidir. 
 * Tüm değerler görüldüğü andaki index,  dönen değer olmalıdır. 
 * Tüm sayılar dizide görülememişse -1 döndürülmelidir.
 */
public class FrogRiverOne {
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
