package leetcode.easy;

/**
 * Created by tjoe on 2017/4/26.
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Subscribe to see which companies asked this question

 使用KMP算法解决
 */
public class StrStr {
    public int strStr(String haystack, String needle) {

//        return  haystack.indexOf(needle);//最快的方法。

        if (haystack == null || needle == null) return -1;
        if (needle.isEmpty()) return 0;
        int lenN = needle.length();
        int lenH = haystack.length();
        if (lenH < lenN){
            return -1;
        }
// 计算next数组，代表patten串中，每个位置的最长公共前缀和后缀
        int next[] = new int[lenN];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < lenN; i++){
            while (j > 0 && needle.charAt(i) != needle.charAt(j)){//如果下一个字符不匹配，则找上一个位置的next[]长度的位置
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }


        int targetIndex = 0;
        int pantenIndex = 0;
        while(targetIndex < lenH && pantenIndex < lenN){
            if (haystack.charAt(targetIndex) == needle.charAt(pantenIndex)){
                targetIndex++;
                pantenIndex++;
            }else {
                if (pantenIndex == 0){
                    targetIndex = targetIndex + 1;
                }else {
                    targetIndex = targetIndex - next[pantenIndex-1];
                }
                pantenIndex = 0;
            }
        }
        if (pantenIndex == lenN){
            return targetIndex - pantenIndex;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        StrStr s = new StrStr();
        System.out.println(s.strStr("aabaaabaaac","aabaaac"));
//        String a ="";
//        System.out.println(a.length());
    }
}
