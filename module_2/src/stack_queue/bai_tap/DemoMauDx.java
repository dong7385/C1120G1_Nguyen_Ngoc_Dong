package stack_queue.bai_tap;

import java.util.Stack;

public class DemoMauDx {
    public static void main(String args[]) {

        System.out.println(balancedParenthensies("{(a,b.csv)}"));
        System.out.println(balancedParenthensies("{(a},b.csv)"));
        System.out.println(balancedParenthensies("{)(a,b.csv}"));
    }

    public static boolean balancedParenthensies(String s) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
