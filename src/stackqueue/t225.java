package stackqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{10:52}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 使用队列实现栈
 */
public class t225 {
    Queue<Integer> myQueue ;


    public t225() {
        myQueue = new LinkedList<>();
    }

    public void push(int x) {
        myQueue.add(x);
    }

    public int pop() {
        int size = myQueue.size()-1;
        while (size!=0){
            myQueue.add(myQueue.poll());
            size--;
        }
        return myQueue.poll();
    }

    public int top() {
        int top = pop();
        myQueue.add(top);
        return top;
    }

    public boolean empty() {
        return myQueue.isEmpty();
    }
}
