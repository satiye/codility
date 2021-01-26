package main.lesson01;

/*
  When converting the number N to its binary representation, it should be tracked to see if 1 has been seen before.

  If 1 is seen in the conversion:
  	- If there is 1 seen before, it means a binary gap has been created. Its length should be checked. And the O counter must be reset.
  	- If 1 was not seen before, 1 should be set as seen.
  If 0 is seen in the conversion:
    - If 1 is seen before, 0 count should be incremented. 
    - If 1 was not seen before, there is no need to do anything.
 */

/*
 * Verilen bir sayıyı ikili gösterimine dönüştürken 1 ile karşılaşıp karşılaşılmadığını takip ederek boşluklar bulunabilir.
 * Eğer 1 ile karşılaşılmışsa ve daha önce 1 görülmemişse 1 ile karşılaşıldığı(oneSeen = true) kaydedilir. Daha önce görülmüşse de boşluk tamamlandı anlamına gelir. 
   Bulunan boşluğun uzunluğu kontrol edilir. Sıfır sayacı tekrar 0 olarak değitirilir.
 * Eğer 1 ile karşılaşılmamışsa ve daha önce görülen 1 var sıfır sayacı artılır. Aksi durumda birşey yapma ihtiyacı yoktur.
 */

public class BinaryGap {
	public int solution(int N) {
        int maxBinaryGapLength = 0;
        int zeroCount = 0;
        boolean oneSeen = false;

        while(N != 0){
            if(N%2 == 1){
                if(oneSeen){
                    maxBinaryGapLength = Math.max(maxBinaryGapLength, zeroCount);
                    zeroCount = 0;
                }else{
                    oneSeen = true;
                }
            }else{
                if(oneSeen){
                    zeroCount++;
                }
            }

            N /= 2;
        }

        return maxBinaryGapLength;
    }
}
