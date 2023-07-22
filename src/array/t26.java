package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{16:02}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:删除有序数组中的重复项
 */
public class t26 {

    //正确答案
    public static int func(int[] nums){
        int lowp = 1, fastp = 1;
        for(; fastp < nums.length; fastp++){
            if(nums[fastp] != nums[fastp-1])
                nums[lowp++] = nums[fastp];
        }
        return lowp;
    }



    //思路：双指针+遍历去除所有已遍历相同的元素
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i=0; i<len; i++) {
            int target = nums[i];
            int lowp = i+1;
            for(int fastp = i+1; fastp<len; fastp++){
                if(nums[fastp] != target){
                    nums[lowp++] = nums[fastp];
                }
            }
            len = lowp;
        }
        return len;
    }

    public static void main(String[] args) {
        int []nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(func(nums));
        for (int i: nums
             ) {
            System.out.println(i);
        }
    }
}
