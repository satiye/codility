package main.lesson01;

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
