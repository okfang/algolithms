package leetcode.easy;

/**
 * Created by tjoe on 2017/4/21.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int j = 0;
        int result = nums.length;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[j++] = nums[i];
            }else {
                result--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int[] nums = {3,2,2,3};
        System.out.println(r.removeElement(nums,3));
    }
}
