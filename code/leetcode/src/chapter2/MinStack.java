package chapter2;

import java.util.Stack;

public class MinStack {

    //使用两个栈：数据栈 辅助栈
    private Stack<Integer> data; //数据栈
    private Stack<Integer> helper; //辅助栈

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空,操作非法");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空,操作非法");
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(3);
        obj.push(5);
        obj.push(4);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }

}
