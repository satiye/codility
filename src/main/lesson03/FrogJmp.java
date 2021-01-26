package main.lesson03;

/* 
   To find number of jumps, divide distance between X and Y by D. If there is a remainder, it means one more jump is required
 */

/*
   Sıçrama sayısını bulmak için, X ve Y arasındaki mesafeyi D'ye bölün. 
   Tam bölünmemesi, bir atlama daha yapılması gerektiği anlamına gelir.
 */
public class FrogJmp {
	 public int solution(int X, int Y, int D) {
		 int numberOfJumps = 0;
		 int distance = Y - X;
				      
		 if(distance%D == 0){
			numberOfJumps = distance/D;
		 }else{
			numberOfJumps = (distance/D)+1;
		 }
				      
		return numberOfJumps;
    }
}
