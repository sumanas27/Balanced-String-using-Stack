import java.util.*;

public class Solution{
  public static char[][] CHARS = {{'{' , '}'},{'[' , ']'},{'(' , ')'}};
  
  public static boolean isOpenToken(char c){
    for(char[] cArray : CHARS){
      if(cArray[0] == c){
        return true;
      }
    }
    return false;
  }
  
  public static boolean matches(char openTerm, char closeTerm){
    for(char[] cArray : CHARS){
      if(cArray[0] == openTerm){
        return cArray[1] == closeTerm;
      }
    }
    return false;
  }
  
  public static boolean isBalanced(String expression){
    Stach<Character> stack = new Stack<Character>();
    for(char c : expression.toCharArray()){
      if(isOpenToken(c)){
        stack.push(c);
      } else {
        if(!stack.isEmpty() || !matches(stack.pop(), c)){
          return false;
        }
      }
      return stack.isEmpty();
    }
  }

}
