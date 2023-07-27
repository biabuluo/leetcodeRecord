package hashlist;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{0:13}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:两个数组的交集II
 */
public class t350 {
    //hash表->通过，其实还可以用双指针（from comment）
    public int[] func(int []nums1, int []nums2){
        List<Integer> tmp = new ArrayList<>();
        int []hashlist1 = new int[1001];
        int []hashlist2 = new int[1001];
        for(int i=0;i<nums1.length;i++){
            hashlist1[nums1[i]]++;
        }
        for(int i=0;i<nums2.length;i++){
            hashlist2[nums2[i]]++;
        }
        for(int i=0;i<=1000;i++){
            int count = hashlist1[i]<hashlist2[i]?hashlist1[i]:hashlist2[i];
            while (count!=0){
                tmp.add(i);
                count--;
            }
        }
        int []res = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            res[i] = tmp.get(i);
        }
        return res;
    }



    //寄，超出内存限制
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> tmp = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0)+1);
        }
        for (int key: map1.keySet()) {
            int count=0;
            if(map2.containsKey(key)){
                count = map1.get(key)>map2.get(key)?map2.get(key):map1.get(key);
            }
            while (count!=0){
                tmp.add(map1.get(key));
            }
        }
        int []res = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
}
