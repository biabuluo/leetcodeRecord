package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date 2023-08-26:10:39
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 汇总区间
 */
public class t228 {
    //双指针
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length==0) return res;
        if(nums.length==1){
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int l = 0; int r = 1;
        while (r<nums.length){
            while (r<nums.length && nums[r] == nums[r-1]+1)
                r++;
            if(r-l>1){
                res.add(nums[l]+"->"+nums[r-1]);
            }else res.add(String.valueOf(nums[l]));
            l = r;
            r++;
        }
        if(l<nums.length){
            if(l==nums.length-1){
                res.add(String.valueOf(nums[l]));
            }else{
                res.add(nums[l]+"->"+nums[nums.length-1]);
            }
        }
        return res;
    }
}
