package leetcode;

import java.util.concurrent.locks.Condition;

/**
 * Created by tjoe on 2017/4/8.
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai)
 * and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * 解决方案：
 * 两边收缩遍历，取小的一侧向中间靠拢，因为取小的一侧移动，才能找到最大的面积。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left  = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right){
            maxArea = Math.max(maxArea, (right - left)* Math.min(height[left], height[right]));
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] height = {1,3,2,1,3,1};
        int h = c.maxArea(height);
        System.out.println(h);
    }
}
