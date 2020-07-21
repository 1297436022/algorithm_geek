package chapter2;

import java.util.Stack;

public class StackBase {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(4));

        stack.pop();
        stack.pop();
        Integer topElement = stack.peek();
        System.out.println(topElement);
        System.out.println("3的位置：" + stack.search(3));
    }
}
