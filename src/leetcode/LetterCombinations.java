package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tjoe on 2017/4/11.
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * 解决方法：遍历，队列
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits){
        int len = digits.length();
        LinkedList<String> res = new LinkedList<String>();
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.isEmpty()) return res;
        res.add("");
        for (int i = 0; i < len; i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String temp = res.poll();
                for (char chr : map[index].toCharArray()) {
                    res.add(temp+chr);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        System.out.println(lc.letterCombinations("23"));
    }
}
