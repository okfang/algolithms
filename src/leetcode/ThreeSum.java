package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by tjoe on 2017/4/10.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * 解决方案：
 * 先将数组排序，遍历第一个数字，后面两个数字组合，跳过相同的数字。不会重复检查数字，复杂度为N*N。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0 ; i < nums.length - 2 ; i++ ) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int sum = 0 - nums[i];
                int lo = i +1;
                int hi = nums.length - 1;
                while (lo < hi){
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo + 1] == nums[lo]) lo++;
                        while(lo < hi && nums[hi - 1] == nums[hi]) hi--;
                        lo++;
                        hi--;
                    }else if (nums[lo] + nums[hi] < sum){
                        lo++;
                    }else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = ts.threeSum(nums);
        System.out.println(list);
    }
}
