package leetcode;

import java.util.Arrays;

/**
 * Created by tjoe on 2017/4/10.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * 解决办法：
 * 对数组排序，确定第一个数，然后从两端开始尝试，如果三个数的和比target小，则移动左端游标，如果大就移动右端游标，更新最接近的值。
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2 ; i++) {
            if (i==0 || i > 0 && nums[i] != nums[i -1]) {
                int start = i + 1;
                int end = nums.length - 1;
                while(start < end){
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == target) {
                        return sum;
                    }else if (sum < target){
                        while(start < end && nums[start] == nums[start + 1]) start++;
                        start++;
                    }else{
                        while(start < end && nums[end - 1] == nums[end]) end--;
                        end--;
                    }
                    if (Math.abs(sum - target) < Math.abs(result - target)){
                        result = sum;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int[] s = {-1,2,1,-4};
        int target = tsc.threeSumClosest(s,2);
        System.out.println(target);
    }
}
