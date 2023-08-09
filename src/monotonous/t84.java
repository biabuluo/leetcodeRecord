package monotonous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{20:26}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 柱状图中最大矩形
 */
public class t84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        //两端加0
        int []newheights = new int[heights.length+2];
        newheights[0] = 0; newheights[newheights.length-1] = 0;
        for(int i=0;i<heights.length;i++){
            newheights[i+1] = heights[i];
        }
        //遍历新数组->维护单减栈
        stack.add(0);
        for(int i=1;i<newheights.length;i++){
            while (!stack.isEmpty() && newheights[i]<newheights[stack.peek()]){
                int idx = stack.pop();
                int tmp = newheights[idx]*(i-stack.peek()-1);
                res = Math.max(res, tmp);
            }
            stack.add(i);
        }
        return res;

    }
}
