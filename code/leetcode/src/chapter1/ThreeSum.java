package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ArrayList<>();
        //res = threeSum1(a);
        res = threeSum3(a);

        //遍历List
        for (int i = 0; i < res.size(); ++i) {
            for (int j = 0; j < res.get(i).size(); ++j) {
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }

    }

    //a + b + c = 0  --->  a + b = -c
    public static List<List<Integer>> threeSum1(int[] nums) {
        //暴力求解  O(n^3)  有bug
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        }
        return res;
    }

    public static int[] threeSum2(int[] nums) {
        //哈希表  a, b , a+b = -c
        return nums;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        //双指针 排序 左右下边往中间推进
        //https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; ++k) {//固定K指针
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {//固定k指针,sum<0且已排序,所以nums[i]小,向右移动i
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {//固定k指针,sum>0且已排序,所以nums[j]大,向左移动j
                    while (i < j && nums[j] ==  nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);//同时移动i,j指针
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
