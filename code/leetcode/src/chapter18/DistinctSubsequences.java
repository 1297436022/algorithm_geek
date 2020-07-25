package chapter18;

class DistinctSubsequences {
    //动态方程 dp[i][j] 代表t前i字符串可以由s前j字符串组成最多个数
    //if s[j] = t[i] , dp[i][j] = dp[i-1][j-1]+dp[i][j-1]
    //if s[j] != t[i], dp[i][j] = dp[i][j-1]   
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() + 1; ++i) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < t.length() + 1; ++i) {
            for (int j = i; j < s.length() + 1; ++j) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}