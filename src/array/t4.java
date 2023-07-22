package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{09}:{13:52}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int a = 0; int b = 0;
        List<Integer> newlist = new ArrayList<Integer>();
        while (true){
            if (a==l1&&b==l2) break;
            if (a==l1) {
                newlist.add(nums2[b]);
                b+=1;
                continue;
            }
            if (b==l2) {
                newlist.add(nums1[a]);
                a+=1;
                continue;
            }
            if (nums1[a]<nums2[b]){
                newlist.add(nums1[a]);
                a++;
            }else {
                newlist.add(nums2[b]);
                b++;
            }
        }
        if(newlist.size()%2!=0){
            return newlist.get(newlist.size()/2);
        }else {
            return (double) (newlist.get(newlist.size()/2)+newlist.get(newlist.size()/2-1))/2;
        }
    }

    public static void main(String[] args) {
        int []nums1 = new int[]{1,2};
        int []nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));


    }
}
