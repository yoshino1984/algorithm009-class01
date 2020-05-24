package simple;

import java.util.Arrays;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (index != i) {
                    // swap
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,1,0,3,12};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {0};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1, 2};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {0, 0, 1};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {0, 0, 1, 2};
        new MoveZeros().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
