package chapter1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        //a = twoSum1(a, 9);
        //a = twoSum2(a, 9);
        a = twoSum3(a, 9);
        System.out.println("[" + a[0] + "," + a[1] + "]");
    }

    public static int[] twoSum1(int[] nums, int target) {
        //暴力破解 O(n^2)
        for (int i=0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        //两遍哈希表 O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum3(int[] nums, int target) {
        //一遍哈希 O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
