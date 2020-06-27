package hard6;

/**
 * 矩形区域不超过K的最大数值和
 **/
public class MaxSumOfRectangleNoLargerThanK {

    /**
     * 动态规划： (i1,j1)(i2,j2)分别代表矩形的左上角和右下角，四层循环遍历两个坐标点的可能性
     * dp[i1,j1,i2,j2] = dp[i1,j1,i2 - 1,j2] + dp[i1,j1,i2,j2 - 1] - dp[i1,j1,i2 - 1,j2 - 1] + matrix[i2,j2];
     * 时间复杂度O((MN)^2)
     * 空间复杂度O(MN)
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for (int i1 = 1; i1 <= rowLen; i1++) {
            for (int j1 = 1; j1 <= colLen; j1++) {
                int[][] dp = new int[rowLen + 1][colLen + 1];
                for (int i2 = i1; i2 <= rowLen; i2++) {
                    for (int j2 = j1; j2 <= colLen; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] + matrix[i2 - 1][j2 - 1] - dp[i2 - 1][j2 - 1];
                        if (dp[i2][j2] < k && max < dp[i2][j2]) {
                            max = dp[i2][j2];
                        } else if (dp[i2][j2] == k) {
                            return k;
                        }
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(
            new int[][]{{2,2,-1}}, 0);
    }
}
