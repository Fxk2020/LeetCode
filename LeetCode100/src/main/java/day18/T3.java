package day18;

import java.util.Stack;

public class T3 {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (c=='(') stack.push(i);
            else {
                stack.pop();//匹配到的左括号
                if (stack.isEmpty()) stack.push(i);//单独的右括号
                else maxLength = Math.max(maxLength, i-stack.peek());
            }
        }

        return maxLength;
    }

}
