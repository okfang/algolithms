package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tjoe on 2017/3/20.
 * 最大回文子序列：暴力解法 和 Manacher's ALGORITHM: O(n)时间求字符串的最长回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null){
            return null;
        }
        int n = s.length();
        int end = n;
        int max = 1;
        int flag = 0;
        for (int i = 0; i < end; i++){
            Stack<Integer> indexs = new Stack<>();
            for (int j = i; j < n; j++){//以第i个字母为起点的所有可能的回文数终点
                if (s.charAt(i) == s.charAt(j)){
                    indexs.add(j);
                }
            }
            int index = indexs.pop();
            while (index != i ){//逐个判断最长回文字符串
                if (isPalindrome(s, i, index)){
                    if (index -i + 1 > max){
                        max = index - i + 1;
                        flag = i;
                        end = n - max; //舍弃后面的max个字母
                    }
                    break;//如果以该字母为起点的最长回文数都没有当前的长，则跳过该字母
                }else {
                    index = indexs.pop();//继续查看后面的回文数
                }
            }

        }
        return s.substring(flag, flag + max);
    }
    public boolean isPalindrome(String s, int start, int end){
        start++;
        end--;
        while(start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
    /*核心思想就是，在已经搜过的回文串内，右边的回文串肯定是和左边的对称的，所以直接找左边的就可以了，多出来的就继续匹配*/
    public void manacherForPalindrome(String s){
        final char FLAG = '*';
        int n = s.length();
        char[] charArray = s.toCharArray();
        int m = n*2+2;
        char[] newString = new char[m];
        newString[0] = '$';
        Arrays.fill(newString,1,m, FLAG);
        for (int j=0,i = 2; j < n ;i+=2,j++){
            newString[i] = charArray[j];
        }
        System.out.println(new String(newString));

        int[] p = new int[m];
        Arrays.fill(p, 0);
        int mx = 0;
        int id = 0;

        for (int i = 1; i < m; i++){
            p[i] = mx > i? Math.min(p[2*id - i], mx - i): 1;//初始p[i]，就是在某回文数右边范围内的回文数，在左边已经搜索过了，所以这部分不用再比较
            while (i>= p[i] && i+p[i] <m && newString[i+p[i]] == newString[i-p[i]]){
                p[i]++;
            }
            if (i+ p[i] > mx){
                mx = i + p[i];
                id = i;
                if (mx >= m){//已经到头了，后面的回文数串肯定没有前一个那么长，如果需要找到所有回文数，可以注释掉
                    break;
                }
            }
        }

        for (int i : p){
            System.out.println(i);
        }

        int max = 0;
        int index = 0;
        for (int i=1; i<m; i++){
            if (p[i] > max){
                max = p[i];
                index = i;
            }
        }

        char[] result = new char[max - 1];
        for (int i = index - max +1,j = 0; i< index + max; i++){
            if (newString[i] != FLAG){
                result[j] = newString[i];
                j++;
            }
        }
        System.out.println(new String(result));
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
//        System.out.println(lp.manacherForPalindrome("aaaaaaaaa"));
        lp.manacherForPalindrome("cbbd");

    }
}
