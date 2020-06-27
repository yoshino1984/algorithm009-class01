package medium6;

/**
 * 最大正方形
 **/
public class MaximalSquare {

    /**
     * 动态规划
     * 时间复杂度O(MN)
     * 空间复杂度O(MN) 可以优化为 O(N)
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        int max = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    // dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        char[][] nums = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        new MaximalSquare().maximalSquare(nums);
    }
}
