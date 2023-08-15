package interview150;

/**
 * @author 小宇
 * @date {2023}-{08}-{14}:{17:38}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 除自身以外数组的乘积
 */
public class t238 {
    public int[] productExceptSelf(int[] nums) {
        int []left = new int[nums.length];
        int []right = new int[nums.length];
        left[0] = 1;
        right[right.length-1] = 1;
        for(int i=1;i<left.length;i++)
            left[i] = left[i-1]*nums[i-1];
        for(int j=right.length-2;j>=0;j--)
            right[j] = right[j+1]*nums[j+1];
        for(int i=0;i<nums.length;i++){
            nums[i] = left[i]*right[i];
        }
        return nums;
    }
}
