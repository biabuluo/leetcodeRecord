package stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{16:11}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 前k个高频元素
 */
public class t347 {
    //基于小顶堆实现
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        int [] res = new int[k];
        for(int i=0;i<nums.length;i++){
            hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0)+1);
        }
        //使用小顶堆
        PriorityQueue<int []> queue = new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
        for(Map.Entry<Integer, Integer> entry:hashmap.entrySet()){
            if(queue.size()<k){
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }else {
                if(queue.peek()[1]<entry.getValue()){
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }

        }
        for(int i=res.length-1;i>=0;i--){
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
