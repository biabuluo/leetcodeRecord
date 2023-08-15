package interview150;

/**
 * @author 小宇
 * @date {2023}-{08}-{14}:{16:03}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 删除有序数组中的重复项
 */
public class t26 {
    public int removeDuplicates(int[] nums) {
        int s = 1;
        for(int f=1;f<nums.length;f++){
            if(nums[f]!=nums[f-1])
                nums[s++] = nums[f];
        }
        return s;
    }
}
