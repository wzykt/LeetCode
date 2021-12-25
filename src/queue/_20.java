package queue;

import java.util.Stack;

/**
 * @date 2021-12-20  2021-12-20完成
 * @description 20. 有效的括号
 *
 * ([)]{} false  这种就不满足括号匹配，开始以为是满足的
 */
public class _20 {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String t = s.substring(i, i + 1);
            if(t.equals("(") || t.equals("[") || t.equals("{")){
                stack.push(t);
            }else if(t.equals(")") || t.equals("]") || t.equals("}")){
                if(stack.isEmpty()){
                    return false;
                }
                String s1 =stack.pop();
                if(s1.equals("[") && t.equals("]")){
                    continue;
                }
                if(s1.equals("{") && t.equals("}")){
                    continue;
                }
                if(s1.equals("(") && t.equals(")")){
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    //还是答案聪明
    //Deque<Character> deque = new LinkedList<>();
    //        char ch;
    //        for (int i = 0; i < s.length(); i++) {
    //            ch = s.charAt(i);
    //            //碰到左括号，就把相应的右括号入栈
    //            if (ch == '(') {
    //                deque.push(')');
    //            }else if (ch == '{') {
    //                deque.push('}');
    //            }else if (ch == '[') {
    //                deque.push(']');
    //            } else if (deque.isEmpty() || deque.peek() != ch) {
    //                return false;
    //            }else {//如果是右括号判断是否和栈顶元素匹配
    //                deque.pop();
    //            }
    //        }
    //        //最后判断栈中元素是否匹配
    //        return deque.isEmpty();
}
