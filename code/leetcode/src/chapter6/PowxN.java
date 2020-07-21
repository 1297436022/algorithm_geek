package chapter6;

class PowxN {

    public static void main(String[] args) {
        PowxN pow = new PowxN();
        System.out.println(pow.myPow1(2.0, 10));
        System.out.println(pow.myPow2(2.0, 10));
    }

    public double myPow2(double x, int n) {
        //快速幂+迭代
        long N = n;
        return N >= 0 ? quickMul1(x, N) : 1.0 / quickMul1(x, -N);
    }

    private double quickMul1(double x, long N) {
        double ans = 1.0;
        double x_contribute = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            N /= 2;
        }
        return ans;
    }

    public double myPow1(double x, int n) {
        //快速幂+递归
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2); //分而治之
        return N % 2 == 0 ? y * y : y * y * x;
    }

}
