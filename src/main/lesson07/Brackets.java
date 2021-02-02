package main.lesson07;
/*
 * push each opening parentheses into a stack. 
 * for each closed parentheses, check whether last opened parentheses is matched or not.
 * If matched, continue checking for other ones, if not, returned not properly nested.
 */
import java.util.*;
public class Brackets {
	public int solution(String S) {
        Stack<Character> openParams = new Stack<Character>();

        for(int i=0; i < S.length(); i++){
            char current = S.charAt(i);
            if(current == '(' || current == '{' || current == '['){
                openParams.push(current);
            }else{
                if(openParams.isEmpty()){
                    return 0;
                }else{
                    char lastOpen = openParams.pop();
                    if((current == ')' && lastOpen != '(') || 
                        (current == '}' && lastOpen != '{') || 
                        (current == ']' && lastOpen != '[')){
                        return 0;
                    }
                }
            }
        }

        return (openParams.isEmpty()) ? 1 : 0;
    }
}
