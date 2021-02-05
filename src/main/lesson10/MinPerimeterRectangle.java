package main.lesson10;
/*
 * Sides of the rectangle can be found by factors of area(i.e N)
 * The perimeter can be minimized when factor is the largest possible value that is less than or equal to sqrt(N)
 */
public class MinPerimeterRectangle {
	public int solution(int N) {
        int squareRootN = (int) Math.sqrt(N);

        for(int i=squareRootN ; i>0; i--){
            if(N%i == 0){
                return 2 * (i + (N/i));
            }
        }

        return 2 * (1+N);
    }
}
