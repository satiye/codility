package main.lesson02;

/* 
   When each index is returned K times, the new index will be (K + i)% n.(where n is the length of the array)
 */

/*
   Her bir index K defa döndürüldüğünde yeni indexi (K+i) % n olacaktır. (n:array'in eleman sayısı)
   Döngüye girmeden K'nın n'den büyük olma durumu kontrol edilebilir. Ancak bu durumda n'nin 0 olma durumu da dikkate alınmalıdır.
 */
public class CyclicRotation {
	public int[] solution(int[] A, int K) {
		int n = A.length;
		int[] output = new int[n];

        for(int i=0; i < n; i++){
            output[(K+i) % n] = A[i];
        }

        return output;
    }
}
