package chapter8;

class JumpGame {
    public boolean canJump(int[] nums) {
        //贪心
        if (nums == null) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >=0; --i) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }
}
