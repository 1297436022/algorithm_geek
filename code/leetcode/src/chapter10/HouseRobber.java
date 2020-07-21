package chapter10;

class HouseRobber {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] a = new int[n][2]; //二维DP
        //a[0][0] 表示偷  a[0][1] 表示不偷
        a[0][0] = 0;
        a[0][1] = nums[0];

        for (int i = 1; i < n; ++i) {
            //第i个房子不偷
            a[i][0] = Math.max(a[i - 1][0], a[i - 1][1]);
            //第i个房子偷，要加上自身nums[i]
            a[i][1] = a[i - 1][0] + nums[i];
        }
        
        return Math.max(a[n - 1][0], a[n - 1][1]);
    }

    //和rob的状态空间不一样  一维数组
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] a = new int[n];

        a[0] = nums[0];
        a[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(a[0], a[1]);

        for (int i = 2; i < n; ++i) {
            //重新状态空间
            a[i] = Math.max(a[i - 1], a[i - 2] + nums[i]);
            res = Math.max(res, a[i]);
        }
        
        return res;
    }

    //滑动数组
    public int rob2(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}