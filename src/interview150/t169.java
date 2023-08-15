package interview150;

/**
 * @author 小宇
 * @date {2023}-{08}-{14}:{16:32}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 多数元素
 */
public class t169 {
    //思路：摩尔投票法
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int power = 1;
        for(int i=1;i<nums.length;i++){
            if(power==0){
                res = nums[i];
                power = 1;
            }
            else if(nums[i]!=res)
                power--;
            else
                power++;
        }
        return res;
    }
}
