package chapter2;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    //最近相关性 --> 栈
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if(c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
