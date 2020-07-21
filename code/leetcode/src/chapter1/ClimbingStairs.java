package chapter1;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbingStairs1(4));
        System.out.println(climbingStairs2(1));
        System.out.println(climbingStairs3(1));
    }

    public static int climbingStairs1(int n) {
        //找最近重复子问题 动态规划思路
        //根据规则，对于第n阶楼梯只能从n-1阶楼梯和n-2阶楼梯跨上来
        //得出转移方程 f(n) = f(n-1) + f(n-2)
        //且本题只求f(n),而f(n)只跟f(n-1)和f(n-2)有关，故可用滑动数组思想
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            //滑动操作
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static int climbingStairs2(int n) {
        //用数组保存每一步的结果
        int[] dp = new int[n + 3];
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbingStairs3(int n) {
        //观察得知本题是斐波那契数列，可用通项公式
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5)/2, n + 1) - Math.pow((1 - sqrt_5)/2, n + 1);
        return (int)(fib_n/sqrt_5);
    }

    //矩阵快速幂
    public static int climbingStairs4(int n) {

        return 0;
    }


}
