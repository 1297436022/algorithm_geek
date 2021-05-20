package chapter1;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 0};
        //moveZeroes1(a);
        moveZeroes2(a);
        //moveZeroes3(a);
        for (int j : a) {
            System.out.print(j + " ");
        }
    }

    public static void moveZeroes1(int[] nums) {
        //慢指针j之前的所有元素都是非零的。
        //快指针i和慢速指针j之间的所有元素都是零。
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (j++ != i) {
                    nums[i] = 0;
                }
                //j++;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        //先统计所有非零的个数，将非零元素移动到数组前部，后半部赋值零
        int lastNoZeroes = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[lastNoZeroes++] = nums[i];
            }
        }
        for (int i = lastNoZeroes; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                //交换非0和0
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
                //++j;
            }
        }
    }

}
