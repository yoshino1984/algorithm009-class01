package medium6;

/**
 * 回文子串
 **/
public class PalindromicSubstrings {

    /**
     * 动态规划 dp[i,j] = s[i] == s[j] && dp[i + 1, j - 1] (考虑i==j和i+1=j的边界情况)
     * 时间复杂度O(N^2)
     * 空间复杂度O(N^2)
     */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = i == j || dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

}
