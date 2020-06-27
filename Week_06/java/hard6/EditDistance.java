package hard6;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int s1Length = word1.length();
        int s2Length = word2.length();
        int[][] dp = new int[s1Length + 1][s2Length + 1];
        // init boundaries
        for (int i = 0; i < s1Length + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < s2Length + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1] - 1);
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }

        }
        return dp[s1Length][s2Length];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("h", "r"));
        System.out.println(minDistance("h", ""));
        System.out.println(minDistance("", ""));
        System.out.println(minDistance("", "r"));
        System.out.println(minDistance("rea", "ra"));
        System.out.println(minDistance("ra", "rea"));
        System.out.println(minDistance("intention", "execution"));
    }

}
