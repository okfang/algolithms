package leetcode;

/**
 * Created by tjoe on 2017/3/29.
 **********题目描述**********
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true

 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s ==  null || p == null){
            return false;
        }
        if (!p.isEmpty() && p.charAt(0) == '*'){//匹配模式串不能以*开头
            return false;
        }
        boolean[][] state = new boolean[s.length()+1][p.length()+1]; //双序列匹配问题，使用动态规划，一般使用的是二维的动态规划，用一个二维数组记录每个匹配的状态
        state[0][0] = true;
        for (int j = 1; j < state[0].length; j++){ //初始化，匹配空字符串。*看前面是否匹配，如果上一个和上上一个都不匹配，说明*号不匹配
            if (p.charAt(j-1) == '*'){
                if (state[0][j-1] || (j>1 && state[0][j-2])){
                    state[0][j] = true;
                }
            }
        }
        for (int i = 1; i < state.length; i++){//字符匹配··
            for (int j = 1; j < state[0].length; j++){
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j-1) == '.'){
                    state[i][j] = state[i-1][j-1];
                }
                if (p.charAt(j-1) == '*'){//如果当前匹配项为*，则出现以下三种情况
                    if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.'){//1.*前一个字符失配，则看前前面的字符能否匹配，因为*可以消掉前面一个匹配字符
                        state[i][j] = state[i][j-2];
                    }else {//*号前面字符匹配，以下情况满足一种即可：1.*匹配了字符串的上一个字符 2.*的上一个匹配字符匹配状态， 3.*的上上个字符匹配状态
                        state[i][j] = state[i-1][j] || state[i][j-1] || state[i][j-2]; //
                    }
                }
            }
        }
        return state[s.length()][p.length()];


    }

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch("a", ""));
//        String s = "";
//        System.out.println(s.isEmpty());
//        System.out.println(s.length());
    }
}
