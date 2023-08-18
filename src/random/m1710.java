package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{17}:{14:27}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class m1710 {
    //思路：摩尔投票法
    public int majorityElement(int[] nums) {
        if(nums.length<=0) return -1;
        int val = nums[0];
        int power = 1;
        for(int i=1;i<nums.length;i++){
            if(power==0){
                val = nums[i];
                power = 1;
                continue;
            }
            if(nums[i]==val)
                power++;
            else
                power--;
        }
        power = 0;
        for(int num : nums){
            if(num==val)
                power++;
        }
        return power>nums.length/2?val:-1;
    }
}
