package hashlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{10:10}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 四数相加II
 */
public class t454 {
    //使用hashmap
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                hashmap.put(-(nums1[i]+nums2[j]), hashmap.getOrDefault(-(nums1[i]+nums2[j]), 0)+1);
            }
        }
        for(int i=0;i< nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                if(hashmap.containsKey(nums3[i]+nums4[j])) res+=hashmap.get(nums3[i]+nums4[j]);
            }
        }
        return res;
    }
}
