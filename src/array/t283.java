package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{23:04}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:移动零
 */
public class t283 {
    //思路2：冒泡思路
    //思路1：双指针
    public static void moveZeroes(int[] nums) {
        int slowp = 0, fastp = 0;
        for(; fastp<nums.length;fastp++){
            if(nums[fastp]!=0){
                nums[slowp++] = nums[fastp];
            }
        }
        for(;slowp<nums.length;slowp++) nums[slowp] = 0;
    }

    public static void main(String[] args) {
        int []nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i:nums) {
            System.out.println(i);
        }
    }
}
