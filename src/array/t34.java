package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{14:08}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:在排序数组中查找元素的第一个和最后一个位置 (方法：二分查找)
 */
public class t34 {
    public static int binarySearch(int []nums, int target){
        int left = 0; int mid = 0;
        int right = nums.length-1;
        while (left<=right){
            mid = (left+right)/2;
            if(nums[mid]>target) right = mid-1;
            else if(nums[mid]<target)left = mid+1;
            else return mid;
        }
        return -1;
    }
    public static int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        int left = index; int right = index;
        int []res = {index, index};
        if(index == -1) return res;
        else {
            while (right<=nums.length-1 && nums[right]==target){
                res[1] = right;
                right++;
            }
            while (left>=0 && nums[left]==target){
                res[0] = left;
                left--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums = {5,7,7,8,8,10};
        int target = 8;
        int []res = searchRange(nums, target);
        System.out.println(res);
    }
}
