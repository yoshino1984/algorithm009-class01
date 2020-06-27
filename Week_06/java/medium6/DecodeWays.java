package medium6;

public class DecodeWays {

    /**
     * 动态规划：需要特殊考虑0的情况 0开头默认为非法，因为是解码必须是双向的，因此编码必须合法
     * 动态转移方程
     * 时间复杂度O(N)
     */
    public int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            char cur = s.charAt(i - 1);
            char last = s.charAt(i - 2);
            dp[i] = (cur != '0' ? dp[i - 1] : 0) + (isMatch(last, cur) ? dp[i - 2] : 0);
        }

        return dp[s.length()];
    }

    private boolean isMatch(char last, char cur) {
        if (last == '0') {
            return false;
        }
        int num = (last - '0') * 10 + (cur - '0');
        return num >= 10 && num <= 26;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
        System.out.println(new DecodeWays().numDecodings("226"));
        System.out.println(new DecodeWays().numDecodings("12310125"));
        System.out.println(new DecodeWays().numDecodings("12320125"));
        System.out.println(new DecodeWays().numDecodings("012320125"));
    }

}
