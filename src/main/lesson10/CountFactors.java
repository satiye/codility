package main.lesson10;
/*
 * Check factors from 1 to sqrt(N). (i*i<=N) 
 * 
 * When the value is a factor, then increment the counter by 2.(Factors are paired) (i*i<N) 
 * When sqrt(N) is a factor, then increment the counter by 1.(not count it twice)   (i*i=N) 
 * 
 * BE CAREFUL about overflow(N is an integer within the range [1..2,147,483,647].).
 * Use long instead of int
 */
public class CountFactors {
	public int solution(int N) {
        int count = 0;
        long i = 1;
        
        while (i * i < N) {
            if (N%i == 0)
                count += 2;
            i++;
        }
        
        if (i*i == N)
            count++;
        
        return count;
    }
}
