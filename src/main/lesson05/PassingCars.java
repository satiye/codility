package main.lesson05;
/*
 * For each west travelling car, the number of east traveling car before will be passing car.
 * Thus, track the number of east travelling car and add it to passing car count when  west travelling car encountered.
 */
public class PassingCars {
	public int solution(int[] A) {
        int passingCarNumber = 0;
        int eastTrvCarNumber = 0;

        for(int i=0; i < A.length; i++){
            if(A[i] == 0){
                eastTrvCarNumber++;
            }else{
                passingCarNumber+=eastTrvCarNumber;
                if(passingCarNumber >  1000000000){
                    return -1;
                }
            }
        }

        return passingCarNumber;
	}
}
