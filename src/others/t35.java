package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{14:45}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 收缩插入位置
 */
public class t35 {
    public int searchInsert(int[] nums, int target) {
        //思路：二分
        int left = 0, right = nums.length-1;
        int mid = 0;
        while (left<=right){
            mid = (left+right)/2;
            if(nums[mid]>target) right=mid-1;
            else if(nums[mid]<target) left=mid+1;
            else return mid;
        }
        if(nums[mid]>target) return left;
        else return right;
    }
}
