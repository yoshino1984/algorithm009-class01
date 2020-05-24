package simple;

import java.util.Arrays;

/**
 * 旋转数组
 **/
public class RotateArray {

    /**
     * 每次移动1，循环k次
     * 时间复杂度O(N * k)
     * 空间复杂度O(1)
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    /**
     * 使用额外数组存放移动后的数组，然后拷贝回来
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int[] temps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temps[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temps[i];
        }
    }

    /**
     * 环状替换
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }

        k = k % nums.length;
        // 记录替换的起始索引，当碰到该索引时，表示构成了一个环，
        int startIndex = 0;
        int lastNum = nums[0];
        int lastIndex = 0;

        // 执行次数等于数组的长度
        for (int i = 0; i < nums.length; i++) {
            int targetIndex = (lastIndex + k) % nums.length;
            int temp = nums[targetIndex];
            nums[targetIndex] = lastNum;

            // 碰到了环，则开始下一个环
            if (targetIndex == startIndex) {
                startIndex = (startIndex + 1) % nums.length;
                lastNum = nums[startIndex];
                lastIndex = startIndex;
            } else {
                lastNum = temp;
                lastIndex = targetIndex;
            }
        }
    }

    /**
     * 两次反转的方式
     * @param nums
     * @param k
     */
    public static void rotate4(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        rotate4(new int[] {1,2,3,4,5,6,7,8,9,10}, 2);
    }
}
