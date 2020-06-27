package hard6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 青蛙过河
 **/
public class FrogJump {

    /**
     * 动态规划
     * 时间复杂度O(N^2) 可以使用map来存储跳跃的可能性，缩减时间复杂度的常数部分（预计可以优化10+倍的性能）
     * 空间复杂度O(N^2)
     */
    public boolean canCross(int[] stones) {
        Set<Integer>[] dp = new Set[stones.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                if (dp[j].contains(k)) {
                    dp[i].add(k - 1);
                    dp[i].add(k);
                    dp[i].add(k + 1);
                }
            }
        }

        return dp[dp.length - 1].size() > 0;
    }

    /**
     * 使用hash表减少当前石头下一跳可能性
     * @param stones
     * @return
     */
    public boolean canCross2(int[] stones) {
        Map<Integer, Set<Integer>> stoneStepMap = new HashMap<>();
        stoneStepMap.computeIfAbsent(1, key -> new HashSet<>()).add(1);

        for (int i = 1; i < stones.length - 1; i++) {
            if (stoneStepMap.containsKey(stones[i])) {
                Set<Integer> fromSteps = stoneStepMap.get(stones[i]);
                for (int step : fromSteps) {
                    for (int j = -1; j <= 1; j++) {
                        int toStep = step + j;
                        if (toStep != 0) {
                            stoneStepMap.computeIfAbsent(stones[i] + toStep, key -> new HashSet<>()).add(toStep);
                        }
                    }
                }
            }
        }

        return stoneStepMap.containsKey(stones[stones.length - 1]);
    }


    public static void main(String[] args) {
        System.out.println(new FrogJump().canCross2(new int[]{0,1,3,5,6,8,12,17}));;
        System.out.println(new FrogJump().canCross2(new int[]{0,1,2,3,4,8,9,11}));;
    }
}
