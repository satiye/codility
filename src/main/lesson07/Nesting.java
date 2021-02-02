package main.lesson07;
/*
 * For each open one, there must be a closing parentheses.
 * Count the number of opened ones, decrease when it is closed.
 * If there is no opened ones for the paired with the closed one return 0.
 * If all open and closed ones are paired, return 1.
 */
public class Nesting {
	public int solution(String S) {
        int openCount = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '('){
               openCount++;
            }else{
                if(openCount == 0){
                    return 0;
                }
                openCount--;
            }
        }

        return (openCount==0) ? 1 : 0;
    }
}
