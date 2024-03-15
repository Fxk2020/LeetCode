package day8;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 */
public class T4 {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] str = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {

            switch (str[i]){
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    if (stack.pop()!='(') return false;
                    break;

                case ']':
                    if (stack.isEmpty()) return false;
                    if (stack.pop()!='[') return false;
                    break;

                case '}':
                    if (stack.isEmpty()) return false;
                    if (stack.pop()!='{') return false;
                    break;

            }

        }

        return stack.isEmpty();

    }


}
