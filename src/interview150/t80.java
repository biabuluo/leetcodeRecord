package interview150;

/**
 * @author 小宇
 * @date {2023}-{08}-{14}:{15:14}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 删除有序数组中的重复项II
 */
public class t80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int s = 2;
        for(int f=2;f<nums.length;f++){
            if(nums[f]!=nums[s-2]){
                nums[s++] = nums[f];
            }
        }
        return s;
    }
}
