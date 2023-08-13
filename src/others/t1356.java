package others;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 小宇
 * @date {2023}-{08}-{13}:{17:02}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 根据数字二进制下1的数目排序
 */
public class t1356 {

    public int countbits(int num){
        int tmp = num;
        int counter = 0;
        while (tmp!=0){
            tmp &= (tmp-1);
            counter++;
        }
        return counter;
    }

    public int[] sortByBits(int[] arr) {
        //使用流式风格
        return Arrays.stream(arr)
                .boxed()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        int o1_bitsnum = countbits(o1);
                        int o2_bitsnum = countbits(o2);
                        return o1_bitsnum==o2_bitsnum? Integer.compare(o1, o2) : Integer.compare(o1_bitsnum, o2_bitsnum);
                    }
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
