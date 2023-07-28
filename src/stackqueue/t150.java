package stackqueue;

import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{13:12}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 逆波兰表达式求值
 */
public class t150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> myStack = new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||
                    tokens[i].equals("-")||
            tokens[i].equals("*")||
            tokens[i].equals("/")){
                int val1 = myStack.pop();
                int val2 = myStack.pop();
                if(tokens[i].equals("+")) myStack.push(val1+val2);
                else if(tokens[i].equals("-")) myStack.push(val1-val2);
                else if(tokens[i].equals("*")) myStack.push(val1*val2);
                else myStack.push(val1/val2);
            }else {
                myStack.push(Integer.valueOf(tokens[i]));
            }
        }
        return myStack.pop();
    }
}
