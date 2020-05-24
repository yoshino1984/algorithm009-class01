package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 **/
public class TwoSum {

    /**
     * 暴力法，嵌套遍历
     * 时间复杂度O(N^2)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("");
    }

    /**
     * 使用map作为缓存，保存遍历过的节点信息（因为题目确保有答案，就不进行参数检查）
     * 时间复杂度O(N) 一次遍历
     * 空间复杂度O(N)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer otherIndex = numIndexMap.get(target - nums[i]);
            if (otherIndex != null) {
                return new int[] {otherIndex, i};
            } else {
                numIndexMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }

}
