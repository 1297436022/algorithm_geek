package chapter2;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] a = {6, 7, 5,2,4,5,9, 3};
        //int[] a = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea1(a));

    }

    public static int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();//保存下标
        stack.push(-1); //栈底放-1非常的巧妙
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            //下标从0开始的
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return maxarea;
    }
}
