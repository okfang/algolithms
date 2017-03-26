package sort;

/**
 * Created by tjoe on 2017/3/20.
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length ;
        int n  =  nums2.length ;
        int[] temp;
        int t;
        if (n < m){                                  //保证m<n
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            t = m;
            m = n;
            n = t;
        }

        int i,j;
        int imin = 0;
        int imax = m;
        int half_len = (m + n + 1)/2;
        int left_max = 0;
        int right_min = 0;

        while (imin <= imax){
            i = (imax + imin) / 2;
            j = half_len - i;
            if (i > 0  && nums1[i-1] > nums2[j]){      //i太大了，说明中间值在左边
                imax = i - 1;
            }else if (i < m && nums1[i] < nums2[j-1]){  //i太小了，说明中间值在右边
                imin = i + 1;
            }else {
                if (i == 0) {
                    left_max = nums2[j-1];
                }else if (j == 0) {
                    left_max = nums1[i-1];
                }else {
                    left_max = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ((n + m)%2 == 1) {
                    return left_max;
                }

                if (i == m){
                    right_min = nums2[j];
                }else if (j == n){
                    right_min = nums1[i];
                }else {
                    right_min = Math.min(nums1[i], nums2[j]);
                }
                if ((n + m)%2 == 0) {
                    return (left_max + right_min) / 2.0;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {2};
        int[] c = {1, 2};
        int[] d = {3,4};
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        System.out.println(f.findMedianSortedArrays(a,b));
        System.out.println(f.findMedianSortedArrays(c,d));
    }
}
