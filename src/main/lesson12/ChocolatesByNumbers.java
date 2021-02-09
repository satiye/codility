package main.lesson12;
/*
 * N=10, M=4
 * 0 1 2 3 4 5 6 7 8 9
 * x 1 x 3 x 5 x 7 x 9
 * 
 * First empty wrapper will be encountered in lcm(N, M). In example, lcm(10,4) = 20
 * The number of eaten chocolates can be found by dividing lcm(N, M) by M. Since, at each M step chocolates are eaten.
 * 
 *  N*M = lcm(N,M) * gcd(N,M)  => lcm(N, M)/M = N/gcd(N,M)
 * 
 */
public class ChocolatesByNumbers {
	 public int solution(int N, int M) {
	        return N / gcd(N,M);
	 }

	 private int gcd(int A, int B) {
		 if(A % B == 0) 
	         return B;
	     else           
	         return gcd(B, A % B);
	 }
}
