package leetcode;

/**
 * Created by tjoe on 2017/3/28.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (numRows ==  1 || numRows >= length){
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder("");
        }
        int index = 0;
        int incre = 0;
        for (int i = 0; i < length; i++){
            sb[index].append(s.charAt(i));
            if (index == 0) { incre = 1;}
            if (index == numRows - 1) { incre = -1;}
            index += incre;
        }
        for (int i = 1; i < sb.length; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zc = new ZigZagConversion();
        String result = zc.convert("AB", 110);
        System.out.println(result);
    }
}
