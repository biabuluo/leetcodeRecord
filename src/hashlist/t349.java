package hashlist;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{23:50}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:两个数组交集
 */
public class t349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashset1 = new HashSet<>();
        Set<Integer> hashset2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            if (!hashset1.contains(nums1[i])){
                hashset1.add(nums1[i]);
            }
        }
        for (int i=0;i<nums2.length;i++){
            if (hashset1.contains(nums2[i])){
                hashset2.add(nums2[i]);
            }
        }
        int []arr = new int[hashset2.size()];
        Object[] tmp =  hashset2.toArray();
        for (int i=0;i< tmp.length;i++){
            arr[i] = (int)tmp[i];
        }
        return arr;
    }
}
