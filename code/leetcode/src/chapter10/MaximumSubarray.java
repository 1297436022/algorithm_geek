package chapter10;

import java.util.Arrays;

class MaximumSubarray {
    public static void main(String[] args) {

        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(ms.maxSubArray(nums));
    }
    
    public int maxSubArray(int[] nums) {
        //1.dp问题 公式为: dp[i] = max(nums[i], nums[i] + dp[i - 1])
        //2.最大子序和 = 当前元素自身最大  或者  包含之前后最大
        for (int i = 1; i < nums.length; ++i) {
            //nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            nums[i] = Math.max(0, nums[i - 1]) + nums[i];
        }
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }

    public int maxSubArray1(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
    
}
