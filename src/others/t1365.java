package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{22:12}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 有多少小于当前数字的数字
 */
public class t1365 {
    //思路：hash
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int []hash = new int[101];
        for(int i=0;i<nums.length;i++){
            for(int j=nums[i]+1;j<hash.length;j++) hash[j]++;
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = hash[nums[i]];
        }
        return nums;
    }
}
