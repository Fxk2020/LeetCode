package day9;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 */
public class T1 {

    public String decodeString(String s) {

        char[] charArray = s.toCharArray();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (Character.isLetterOrDigit(charArray[i])||charArray[i]=='['){
                stack.push(String.valueOf(charArray[i]));
            }else {

                LinkedList<String> strs = new LinkedList<>();
                while (!stack.peek().equals("[")){
                    strs.addFirst(stack.pop());
                }
                stack.pop();//[出栈
                //一定是数字
                int num = Integer.parseInt(stack.pop());
                int e = 1;
                while (!stack.isEmpty()&&Character.isDigit(stack.peek().charAt(0))){
                    num = (int) (num+Integer.parseInt(stack.pop())*Math.pow(10,e));
                    e++;
                }


                String str = "";
                for (int j = 0; j < strs.size(); j++) {
                    str = str.concat(strs.get(j));
                }
                String str2 = "";
                for (int j = 0; j < num; j++) {
                    str2 = str2.concat(str);
                }
                stack.push(str2);
            }

        }

        LinkedList<String> result = new LinkedList<>();
        while (!stack.isEmpty()){
            result.addFirst(stack.pop());
        }
        String out = "";
        for (int i = 0; i < result.size(); i++) {
            out = out.concat(result.get(i));
        }
        return out;
    }

}
