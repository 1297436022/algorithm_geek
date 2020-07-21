package chapter5;

public class ClimbingStairs {
    public static void main(String[] args) {
        //System.out.println(climbStairs1(2));
        //System.out.println(climbStairs2(30));
        System.out.println(climbStairs3(30));
        //System.out.println(climbStairs4(30));

    }

    public static int climbStairs4(int n) {
        //动态规划
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs5(int n) {
        //记忆化递归 通过
        int[] memo = new int[n + 1];
        return v(0, n, memo);
    }

    public static int v(int i, int n, int[] memo) {
        //比较v 和vv方法的异同
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if(memo[i] > 0) {
            return memo[i];
        }
        memo[i] = v(i + 1, n, memo) + v(i + 2, n, memo);
        return memo[i];
    }

    public static int climbStairs3(int n) {
        //记忆化递归 通过
        int[] memo = new int[n + 1];
        return vv(n, memo);
    }

    public static int vv(int n, int[] memo) {
        //自上而下
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if(memo[n] > 0) {
            return memo[n];
        }
        memo[n] = vv(n - 1, memo) + vv(n - 2, memo);
        return memo[n];
    }

    public static int climbStairs2(int n) {
        //直接递归  超时
        if ( n < 0) {
           return 0;
        }
        if (n == 0) {
            return 1;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    public static int climbStairs1(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }



}
