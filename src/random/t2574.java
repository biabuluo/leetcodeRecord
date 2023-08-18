package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{18}:{17:37}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 左右元素和的差值
 */
public class t2574 {
    public int[] leftRightDifference(int[] nums) {
        //前缀和
        int []res = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]+nums[i-1];
        }
        //后缀和
        int sum = 0;
        for(int i=nums.length-1;i>=0;i--){
            res[i] = Math.abs(res[i]-sum);
            sum+=nums[i];
        }
        return  res;
    }
}
