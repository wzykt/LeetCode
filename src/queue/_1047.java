package queue;

import java.util.Stack;

/**
 * @date 2021-12-22 2021-12-22完成
 * @description 1047. 删除字符串中的所有相邻重复项
 *
 * 借助栈完成
 */
public class _1047 {
    public String removeDuplicates(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i,i+1);
            if(!stack.isEmpty() && s1.equals(stack.peek())){
                stack.pop();
            }else {
                stack.push(s1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str:stack) {
            sb.append(str);
        }
        return sb.toString();
    }
}
