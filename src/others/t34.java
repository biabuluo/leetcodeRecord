package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{12:44}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 */
public class t34 {
    public static void main(String[] args) {
        int []nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }
    //思路：二分法
    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int idx = -1;
        while (left<=right){
            int mid = (left+right)/2;
            if(target>nums[mid]) left = mid+1;
            else if(target<nums[mid]) right = mid-1;
            else {
                idx = mid;
                break;
            }
        }
        if(idx == -1) return new int[]{-1,-1};
        else {
            left = idx;right = idx;
            while (left>=0 && nums[left]==target) left--;
            while (right<nums.length && nums[right]==target) right++;
            return new int[]{left+1, right-1};
        }
    }
}
