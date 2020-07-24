package chapter17;

class MinCostClimbingStairs {

    //f[i] = cost[i] + min(f[i+1], f[i+2])
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    //f[i] = cost[i] + min(f[i-1], f[i-2])
    public int minCostClimbingStairs1(int[] cost) {
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < cost.length; i++)
        {
            int curr = cost[i] + Math.min(c1, c2);
            c1 = c2;
            c2 = curr;
        }
        return Math.min(c1, c2);
    }

}