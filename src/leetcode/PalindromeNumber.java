package leetcode;

/**
 * Created by tjoe on 2017/3/28.
 * 判断数字是否为回文数转化为回文数
 *
 *
 * 解决方案：从左至右，每次除10取余，并求出右半部分反序的数值。
 * 当两侧游标会和，或者交叉，判断左半部分和右半部分的值是否相等。
 */
public class PalindromeNumber {
//    public boolean isPalindrome(int x) {
//        if (x < 0){
//            return false;
//        }
//        if (x < 10){
//            return true;
//        }
//        int xx = x;
//        int count = 0;
//        do{
//             xx = xx/10;
//             count++;
//        }while (xx > 0);
//
//        boolean flag = true;
//        int left = 1;
//        int right = count - 1;
//        while (left <= right){
//            if (x%(int)Math.pow(10,left) == x/(int)Math.pow(10,right)){
//                x = x/(int)Math.pow(10, left);//去掉尾数字
//                right--;
//                x = x%(int)Math.pow(10,right);//去掉首数字
//                //剩余的数字重置游标
//                left = 1;
//                right--;
//            }else {
//                flag = false;
//                break;
//            }
//        }
//        return flag;
//    }

    public boolean isPalindrome(int x){
        if (x<0 || (x!=0 && x%10 == 0)) return false;
        if (x < 10) return true;
        int rev = 0 ;
        while (x > rev){
            rev = x%10 + rev*10;
            x = x/10;
        }
        return (x == rev || x == rev/10);
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(10));
    }
}
