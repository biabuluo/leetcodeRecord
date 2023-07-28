package stackqueue;

import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{0:09}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 用栈来实现队列
 */


public class t232 {

    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public t232() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if(outputStack.empty()){
            while (!inputStack.empty()){
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        int i = pop();
        outputStack.push(i);
        return i;
    }

    public boolean empty() {
        return outputStack.empty()&& inputStack.empty();
    }
}
