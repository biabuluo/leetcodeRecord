package stackqueue;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{15:17}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 滑动窗口最大值
 */

//单调队列
class DescendQueue{
    private Deque<Integer> myqueue;
    public DescendQueue(){myqueue = new LinkedList<>();}
    public int getMax(){return myqueue.peek();}
    public int pop(int val){
        if (myqueue.isEmpty()) return -1;
        if (getMax()==val){
            return myqueue.poll();
        }
        else return -1;
    }
    public void push(int val){
        while (!myqueue.isEmpty()&&myqueue.getLast()<val){
            myqueue.removeLast();
        }
        myqueue.addLast(val);
    }
}

public class t239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int []res = new int[nums.length-k+1];
        DescendQueue queue = new DescendQueue();
        for(int i=0;i<k;i++){
            queue.push(nums[i]);
        }
        int count = -1;
        res[++count] = queue.getMax();
        for(int i=k;i< nums.length;i++){
            queue.pop(nums[i-k]);
            queue.push(nums[i]);
            res[++count] = queue.getMax();
        }
        return res;
    }

}
