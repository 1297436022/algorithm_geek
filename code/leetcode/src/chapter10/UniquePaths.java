package chapter10;

import java.util.Arrays;
import java.util.Vector;

class UniquePaths {

    public static void main(String[] args) {
        UniquePaths un = new UniquePaths();
        System.out.println(un.uniquePaths3(3, 2));
    }
    //https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
    public int uniquePaths1(int m, int n) {
        //O(m*n)  O(m*n)
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        //O(m*n)  O(n)
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                cur[j] = pre[j] + cur[j - 1];
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[n - 1];
    }

    public int uniquePaths(int m, int n) {
        //O(m*n)  O(1)
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    //有bug
    public int uniquePaths3(int m, int n) {
        //O(m*n)  O(1)
        Vector<Integer> cur = new Vector<>(n, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                cur.add(j, cur.get(j) + cur.get(j - 1));
            }
        }
        return cur.get(n - 1);
    }
}
