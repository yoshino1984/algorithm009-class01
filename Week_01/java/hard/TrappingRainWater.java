package hard;

import java.util.Stack;

/**
 * 接雨水
 **/
public class TrappingRainWater {

    /**
     * 使用暴力求解的方式。找每根柱子的左右边界，然后求当前柱子的积水
     * 时间复杂度O(N^2)
     * 空间复杂度O(1)
     */
    public static int trap1(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = findMaxHeight(height, 0, i);
            int rightMax = findMaxHeight(height, i, height.length - 1);
            ans += (Math.min(leftMax, rightMax) - height[i]);
        }
        return ans;
    }

    private static int findMaxHeight(int[] height, int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(height[i], max);
        }
        return max;
    }

    /**
     * 动态规划的方法分两次求解左右边界，然后使用当前柱子的左右边界来求解当前柱子的接雨水量
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public static int trap2(int[] height) {
        int ans = 0;
        if (height == null || height.length == 0) {
            return ans;
        }
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 双指针解法 主要根据左右边界短边才是限定积水的高度的基本条件推断指针的移动方式
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     */
    public static int trap3(int[] height) {
        int ans = 0;
        int left = 1, right = height.length - 2;
        int maxLeft = 0, maxRight = 0;

        while (left <= right){
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(height[left - 1], maxLeft);
                ans += Math.max(maxLeft - height[left], 0);
                left++;
            } else {
                maxRight = Math.max(height[right + 1], maxRight);
                ans += Math.max(maxRight - height[right], 0);
                right--;
            }
        }

        return ans;
    }

    /**
     * 使用栈的方式，遍历元素，存放高度递减的元素，如果高度高于栈顶，则弹出元素进行计算。
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public static int trap4(int[] height) {
        int ans = 0;
        Stack<Integer> heightIndexStack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!heightIndexStack.isEmpty() && height[heightIndexStack.peek()] < height[i]) {
                // 本地次所求的列
                int curIndex = heightIndexStack.pop();
                if (heightIndexStack.isEmpty()) {
                    break;
                }
                int distance = i - heightIndexStack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[heightIndexStack.peek()]) - height[curIndex];
                ans += distance * boundedHeight;
            }
            heightIndexStack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap3(new int[]{4,2,0,3,2,5}));
        System.out.println(trap3(new int[]{2, 0, 2}));
        System.out.println(trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
