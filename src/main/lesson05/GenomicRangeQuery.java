package main.lesson05;
/*
 * occurences array holds which letter occurs in which index
 * occurenceSum array holds how many letter occurs up to that index
 * Then execute query on occurenceSum array.
 * 
 * For string S = CAGCCTA (A-1, C-2, G-3, T-4)
 * occurences = {
 * 					{0, 1, 0, 0},
 * 					{1, 0, 0, 0},
 * 					{0, 0, 1, 0}, // G letter is in 2nd index(it is in second row in the matrix)
 * 					{0, 1, 0, 0},
 * 					{0, 1, 0, 0},
 * 					{0, 0, 0, 1},
 * 					{1, 0, 0, 0}
 * 				}
 * occurenceSum = {
 * 					{0, 0, 0, 0},
 * 					{0, 1, 0, 0},
 * 					{1, 1, 0, 0},
 * 					{1, 1, 1, 0}, // up to index 3, 1-A letter, 1-C letter and 1-G letter seen
 * 					{1, 2, 1, 0},
 * 					{1, 3, 1, 0},
 * 					{1, 3, 1, 1},
 * 					{2, 3, 1, 1}
 * 				}
 * 
 * 
 * For P[0] = 2, Q[0] = 4 ({1, 3, 1, 0} - {1, 1, 0, 0} = {0, 2, 1, 0}(2-C and 1-G occurs)) - min factor is C = 2
 */
public class GenomicRangeQuery {
	public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int[][] occurences = new int[N][4];

        for(int i=0; i < N; i++){
            char c = S.charAt(i);
            if(c == 'A'){
                occurences[i][0] = 1;
            }else if(c == 'C'){
                occurences[i][1] = 1;
            }else if(c == 'G'){
                occurences[i][2] = 1;
            }else{
                occurences[i][3] = 1;
            }
        }

        int[][] occurenceSum = new int[N+1][4];

        for(int i=1; i < N+1; i++){
            occurenceSum[i][0] = occurenceSum[i-1][0] + occurences[i-1][0];
            occurenceSum[i][1] = occurenceSum[i-1][1] + occurences[i-1][1];
            occurenceSum[i][2] = occurenceSum[i-1][2] + occurences[i-1][2];
            occurenceSum[i][3] = occurenceSum[i-1][3] + occurences[i-1][3];
        }

        int[] result = new int[P.length];
        for(int i=0; i< P.length; i++){
            int start = P[i];
            int end = Q[i]+1;
            if(occurenceSum[end][0] - occurenceSum[start][0] > 0){
                result[i] = 1;
            }else if(occurenceSum[end][1] - occurenceSum[start][1] > 0){
                result[i] = 2;
            }else if(occurenceSum[end][2] - occurenceSum[start][2] > 0){
                result[i] = 3;
            }else{
                result[i] = 4;
            }
        }

        return result;
    }
}
