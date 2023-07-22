package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{07}-{08}:{19:10}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t1 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * @param nums
     * @param target
     * @return
     */

    //解法1：暴力枚举
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int [] res = new int[2];
        for(int i = 0;i<len;i++){
            for (int j =i+1;j<len;j++){
                if(nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
    //解法2：哈希表：
    /**
     * 创建一个哈希表，对于每一个 x，
     * 我们首先查询哈希表中是否存在 target - x，
     * 然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配
     */
     public int[] twoSum2(int []nums, int target){
//         构建哈希表
         Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
         //遍历数组
         int len = nums.length;
         for (int i=0;i<len;i++){
             if (hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]), i};
             }
             hashtable.put(nums[i], i);
         }
         return new int[2];
     }




}
