package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tjoe on 2017/4/11.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for ( int i = 0; i < nums.length - 2; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                for (int j = i + 1; j < nums.length - 2; j++){
                    if (j == i+1 || (j > 1 && nums[j] != nums[j - 1])){
                        int sum = target - nums[i] - nums[j];
                        int start = j + 1;
                        int end = nums.length - 1;
                        while (start < end){
                            if (nums[start] + nums[end] == sum){
                                res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                while (start < end && nums[end] == nums[end - 1]) end--;
                                start++;
                                end--;
                            }else if(nums[start] + nums[end] < sum){
                                start++;
                            }else {
                                end--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] s = {-3,-2,-1,0,0,1,2,3};
        System.out.println(fs.fourSum(s, 0));
    }
}
