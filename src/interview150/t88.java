package interview150;

/**
 * @author 小宇
 * @date {2023}-{08}-{14}:{14:43}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 合并两个数组
 */
public class t88 {
    public static void main(String[] args) {
        int []nums1 = {1,2,3,0,0,0};
        int []nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
    }
    //思路：从后往前遍历
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m+n-1;
        int p1 = m-1, p2 = n-1;
        while (p1>=0 && p2>=0){
            if(nums1[p1] >= nums2[p2]) nums1[idx--] = nums1[p1--];
            else nums1[idx--] = nums2[p2--];
        }
        while (p2>=0)
            nums1[idx--] = nums2[p2--];
    }
}
