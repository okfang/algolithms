package leetcode;

import java.util.LinkedList;

/**
 * Created by tjoe on 2017/4/12.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i< s.length(); i++){
            char symbol = s.charAt(i);
            if (symbol == '(' || symbol == '[' || symbol == '{'){
                stack.push(symbol);
            }
            if (symbol == ')' || symbol == ']' || symbol == '}'){
                if (stack.isEmpty()){
                    return false;
                }
                switch (symbol){
                    case ')':
                        if (stack.pop()  != '(') return false;
                        break;
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        break;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([]]"));
    }
}
