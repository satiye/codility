package main.lesson05;

/*
 * Number of integers divisible by K less than B is B/K
 * Number of integers divisible by K less than B greater than A is B/K-A/K
 * Since A is included, 1 must be added to result if A is divisible by K
 */

public class CountDiv {
	public int solution(int A, int B, int K) {
        int result = (B/K) - (A/K);

        return (A%K == 0) ? result+1 : result;
    }
}
