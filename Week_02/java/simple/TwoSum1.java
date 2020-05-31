package simple;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(nums[i])) {
                return new int[] {numIndexMap.get(nums[i]), i};
            } else {
                numIndexMap.put(target - nums[i], i);
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    public static void main(String[] args) {
        new TwoSum1().twoSum(new int[]{2,7}, 9);
    }
}
