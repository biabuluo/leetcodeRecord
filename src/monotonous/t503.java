package monotonous;

import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{19:43}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 下一个更大元素II
 */
public class t503 {
    //思路：单调上升栈
    public int[] nextGreaterElements(int[] nums) {
        int []res = new int[nums.length];
        for(int i=0;i<nums.length;i++) res[i]=-1;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i=1;i<nums.length*2;i++){
            while (!stack.isEmpty()&&nums[i%nums.length]>nums[stack.peek()]){
                int idx = stack.pop();
                res[idx] = nums[i%nums.length];
            }
            stack.add(i%nums.length);
        }
        return res;
    }
}
