package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tjoe on 2017/4/13.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * ["((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> res = new LinkedList<>();
        backtrack(res,"",0, 0, n);
        return res;

    }
    public void backtrack(List<String> res, String str, int open, int close, int n){
        int max = 2 * n;
        if (str.length() == max){
            res.add(str);
        }
        if (open < n && str.length() < max){
            backtrack(res, str + "(", open + 1, close, n);
        }
        if (close < open && str.length() < max){
            backtrack(res, str + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
    }
}
