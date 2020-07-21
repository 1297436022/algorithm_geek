package chapter1;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(a));
        System.out.println(maxArea2(a));
    }

    public static int maxArea1(int[] a) {
        //O(n^2) 暴力求解
        int max = 0;
        for (int i = 0; i < a.length; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                int area = (j - i) * Math.min(a[i], a[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static int maxArea2(int[] a) {
        //O(n) 左右边界i, j, 向中间收敛：左右夹逼
        int max = 0;
        for (int i = 0, j = a.length - 1; i < j; ) {
            //两边依次收敛到较高的棒子
            int minHeight = a[i] < a[j] ? a[i++] : a[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }


}


