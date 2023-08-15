package interview150;

/**
 * @author 小宇
 * @date {2023}-{08}-{14}:{16:00}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 移除元素
 */
public class t27 {
    public int removeElement(int[] nums, int val) {
        int s = 0;
        for(int f=0;f<nums.length;f++){
            if(nums[f]!=val)
                nums[s++] = nums[f];
        }
        return s;
    }
}
