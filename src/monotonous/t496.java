package monotonous;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{19:14}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 下一个更大的元素I
 */
public class t496 {
    //思路：单调栈+hash
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        //对nums2进行操作
        for(int i=1;i<nums2.length;i++){
            while (!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                int idx = stack.pop();
                map.put(nums2[idx], nums2[i]);
            }
            stack.add(i);
        }
        //对num1操作
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])) nums1[i] = map.get(nums1[i]);
            else nums1[i] = -1;
        }
        return nums1;
    }
}
