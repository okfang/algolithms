package leetcode.easy;

/**
 * Created by tjoe on 2017/4/21.
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

 Subscribe to see which companies asked this question.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int result = nums.length;
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }else {
                result--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
        int[] nums = {-3,-1,-1,0,0,0,0,0,2};
        System.out.println(r.removeDuplicates(nums));
    }
}
