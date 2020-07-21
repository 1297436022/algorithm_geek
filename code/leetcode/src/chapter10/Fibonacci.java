package chapter10;

class Fibonacci {

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib1(5, new int[6]));
        //System.out.println(f.fib2(5));
    }

    //直接递归 O(2^n)
    public int fib(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }

    //记忆化递归 O(n)  自顶向下 5->4->3->2->1
    public int fib1(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] == 0) {
            memo[n] = fib1(n - 1, memo) + fib1(n - 2, memo);
        }
        return memo[n];
    }

    //递推 为自底向上 for循环  DP熟练的标志
    public int fib2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
