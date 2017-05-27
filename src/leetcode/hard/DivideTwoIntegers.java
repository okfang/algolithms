package leetcode.hard;
/**
 * Created by tjoe on 2017/4/28.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1) ){
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0)? -1:1;
        long  divd = Math.abs((long)dividend);
        long divs = Math.abs((long)divisor);
        System.out.printf("%d,%d\n",divd,divs);
        int res = 0;
        while (divd >= divs){
            long temp = divs;
            int multiple = 1;
            while (divd >= (temp << 1)){
                temp <<= 1;
                multiple <<= 1;
                System.out.println(temp);
            }
            divd -= temp;
            res += multiple;
        }
        return sign == 1? res: -res;

    }

    public static void main(String[] args) {
//        DivideTwoIntegers dt = new DivideTwoIntegers();
//        System.out.println(dt.divide(-2147483648,1));
        System.out.println(""+Integer.MIN_VALUE+"  "+Integer.MAX_VALUE);
        System.out.println((long)1 << 31);
    }
}
