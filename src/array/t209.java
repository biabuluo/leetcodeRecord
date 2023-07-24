package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{24}:{20:27}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 长度最小子数组
 */
public class t209 {
    //自己的思路：快慢指针
    public static int minSubArrayLen(int target, int[] nums) {
        int bound = nums.length-1;
        int sum = 0;
        int slowp = 0, res = Integer.MAX_VALUE;
        for (int fastp=0;fastp<=bound;fastp++){
            sum += nums[fastp];
            while (sum>=target){
                res = Math.min(res, fastp-slowp+1);
                sum -= nums[slowp++];
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }

    public static void main(String[] args) {
        int []nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));

    }
}
