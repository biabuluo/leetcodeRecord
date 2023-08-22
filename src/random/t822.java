package random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小宇
 * @date {2023}-{08}-{22}:{11:35}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 翻转卡片游戏
 */
public class t822 {
    //思路：hash
    public int flipgame(int[] fronts, int[] backs) {
        Map<Integer, Integer> map = new HashMap<>();
        //存储正面背面相等的值
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]==backs[i])
                map.put(fronts[i], i);
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<fronts.length;i++){
            if(!map.containsKey(fronts[i]) && fronts[i]<res)
                res = fronts[i];
        }
        for(int i=0;i<fronts.length;i++){
            if(!map.containsKey(backs[i]) && backs[i]<res)
                res = backs[i];
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
