package chapter5;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    //https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/

    public static void main(String[] args) {
        GenerateParentheses gen = new GenerateParentheses();
        System.out.println(gen.generateParenthesis(3));
    }

    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        generate(0,0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        //检测括号的合法性 并添加括号
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
    }
}
