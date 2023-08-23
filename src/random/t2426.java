package random;

import java.util.Arrays;
import java.util.Dictionary;

/**
 * @author 小宇
 * @date {2023}-{08}-{23}:{12:47}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 满足不等式的数对数目
 */
public class t2426 {
    int rescnt = 0;
    int d = 0;

    public int[] merge(int []a, int []b){
        int len_a = a.length;
        int len_b = b.length;
        int cur_a = 0, cur_b = 0;
        int cur = 0;
        int []res = new int[len_a+len_b];
        //用满足不等式的计数更新结果
        for(int i=0;i<len_b;i++){
            int idx = len_a-1;
            while (idx>=0 && a[idx]>b[i]+d)
                idx--;
            if(idx>=0)
                rescnt += idx+1;
        }
        while (cur_a<len_a && cur_b<len_b){
            if(a[cur_a]<b[cur_b])
                res[cur++] = a[cur_a++];
            else
                res[cur++] = b[cur_b++];
        }
        while (cur_a<len_a)
            res[cur++] = a[cur_a++];
        while (cur_b<len_b)
            res[cur++] = b[cur_b++];
        return res;
    }

    public int[] mergeSort(int []num){
        if(num.length==1)
            return num;
        else {
            int mid = num.length/2;
            return merge(mergeSort(Arrays.copyOfRange(num, 0, mid)), mergeSort(Arrays.copyOfRange(num, mid, num.length)));
        }
    }

    //移项+归并排序
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        d = diff;
        int len = nums1.length;
        int []numDiff = new int[len];
        for(int i=0;i<len;i++)
            numDiff[i] = nums1[i] - nums2[i];
        mergeSort(numDiff);
        return rescnt;
    }
}
