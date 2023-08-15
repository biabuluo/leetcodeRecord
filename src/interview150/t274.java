package interview150;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{08}-{14}:{17:13}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: H指数
 */
public class t274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=citations.length;i>=0;i--){
            if(citations[citations.length-i]>=i)
                return i;
        }
        return 0;
    }
}
