package monotonous;

import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{19:54}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 接雨水
 */
public class t42 {
    public static void main(String[] args) {
        int []height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    //思路：单调栈
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.add(0);
        for(int i=1;i<height.length;i++){
            while (!stack.isEmpty() && height[i]>height[stack.peek()]){
                int idx = stack.pop();
                if(stack.isEmpty()) break;
                int tmp = Math.min(height[stack.peek()], height[i]);
                res += (tmp-height[idx])*(i-stack.peek()-1);
            }
            stack.add(i);
        }
        return res;
    }
}
