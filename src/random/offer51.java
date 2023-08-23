package random;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{08}-{23}:{14:20}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 数组中的逆序对
 */
public class offer51 {
    int res = 0;


    public int[] merge(int []a, int []b){
        int len_a = a.length;
        int len_b = b.length;
        int []resArray = new int[len_a+len_b];
        int cur_a = 0, cur_b = 0;
        int cur = 0;
        while (cur_a<len_a && cur_b<len_b){
            if(b[cur_b]<a[cur_a]){
                //更新结果
                res += (len_a-cur_a);
                //加入新数组
                resArray[cur++] = b[cur_b++];
            }else {
                resArray[cur++] = a[cur_a++];
            }
        }
        while (cur_a<len_a)
            resArray[cur++] = a[cur_a++];
        while (cur_b<len_b)
            resArray[cur++] = b[cur_b++];
        return resArray;
    }
    //归并排序
    public int[] mergeSorted(int []nums){
        if(nums.length==1)
            return nums;
        else{
            int s = 0;
            int e = nums.length;
            int mid = e/2;
            return merge(mergeSorted(Arrays.copyOfRange(nums, s, mid)), mergeSorted(Arrays.copyOfRange(nums, mid, nums.length)));
        }
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len<2)
            return 0;
        int []copy = Arrays.copyOf(nums, len);
        //使用归并排序求逆序对数
        mergeSorted(copy);
        return res;
    }
}
