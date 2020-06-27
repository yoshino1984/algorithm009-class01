package medium6;

import java.util.Arrays;

public class MinimumPathSum {

    /**
     * 使用动态规划法，遍历所有元素 时间复杂度为O(NM)
     * 因为只能从向下或者向右，因此  a[i][j] = min(a[i-1][j], a[i][j-1]) + a[i][j]
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    if (j != 0) {
                        grid[i][j] = grid[i][j] + grid[i][j - 1];
                    }
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 不破坏原有数组
     * 时间复杂度O(MN)
     * 空间复杂度O(M)
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[] dp = new int[grid[0].length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[grid[0].length];
    }


}
