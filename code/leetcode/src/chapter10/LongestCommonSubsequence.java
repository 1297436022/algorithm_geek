package chapter10;

class LongestCommonSubsequence {

    //O(MN)  O(MN)
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];//初始化默认 0
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
    //O(MN)  O(N)
    public int longestCommonSubsequence1(String text1, String text2) {
        int[] dp = new int[text2.length()+1];
        for(int i = 0; i< text1.length(); i++){
            int prev = dp[0];
            for(int j = 1; j < dp.length; j++){
                int temp = dp[j];
                if(text1.charAt(i) != text2.charAt(j-1)){
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }else{
                    dp[j] = prev +1;
                }
                prev = temp;
            }
        }
        return dp[dp.length-1];
    }
}
