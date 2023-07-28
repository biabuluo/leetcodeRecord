package stackqueue;

import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{11:22}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 有效的括号
 */
public class t20 {
    //思路: 使用栈处理三种情况
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        int size = s.length();
        for(int i=0;i<size;i++){
            if(s.charAt(i)=='(') myStack.push(')');
            else if (s.charAt(i)=='{') myStack.push('}');
            else if (s.charAt(i)=='[') myStack.push(']');
            else if(myStack.isEmpty()||myStack.peek()!=s.charAt(i)) return false;
            else myStack.pop();
        }
        return myStack.isEmpty();
    }
}
