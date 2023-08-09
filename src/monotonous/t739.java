package monotonous;

import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{17:01}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 每日温度
 */
public class t739 {
    //思路：使用单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int []res = new int[temperatures.length];
        //单调递增栈
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i=1;i<temperatures.length;i++){
            while (!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.add(i);
        }
        return res;
    }
}
