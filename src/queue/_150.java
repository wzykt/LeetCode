package queue;

import java.util.Stack;

/**
 * @date 2021-12-22
 * @description 150. 逆波兰表达式求值
 */
public class _150 {
    public static int evalRPN(String[] tokens) {
        int res = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == "*") {
                res = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                stack.push(res + "");
                continue;
            }
            if (tokens[i] == "/") {
                int i1 = Integer.parseInt(stack.pop());
                int i2 = Integer.parseInt(stack.pop());
                res = i2 / i1;
                stack.push(res + "");
                continue;
            }
            if (tokens[i] == "+") {
                res = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                stack.push(res + "");
                continue;
            }
            if (tokens[i] == "-") {
                res = -(Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop()));
                stack.push(res + "");
                continue;
            }
            stack.push(tokens[i]);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
