package stack;

import java.util.Stack;

/**
 * @Author qqg
 * @Date 2019/2/12
 * @Description: PACKAGE_NAME
 */
//括号匹配
public class Solution {
    public static void main(String[] args) {

        boolean b = isValid("()");
        System.out.println(b);
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.pop();
                if (ch == ')' &&top != '(') {
                    return false;
                }
                if (ch == '}' &&top != '{') {
                    return false;
                }
                if (ch == ']' && top!= '[') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
