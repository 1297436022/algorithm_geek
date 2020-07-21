package chapter9;

class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

    public int search1(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            //当[0,mid]有序时，向后规约条件
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]))
                lo = mid + 1;
            //当[0,mid]发生选战士，向后规约条件
            else if (target > nums[mid] && target < nums[0])
               lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}
