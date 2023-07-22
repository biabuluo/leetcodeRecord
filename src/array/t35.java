package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{13:45}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 搜索插入位置(方法:择半查找)
 */
public class t35 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;int mid = 0;
        int right = nums.length-1;
        while (left<=right){
            mid = (left+right)/2;
            if(nums[mid]>target) right = mid-1;
            else if(nums[mid]<target) left = mid+1;
            else return mid;
        }
        if(nums[mid]>target)return mid;
        else return mid+1;
    }

    public static void main(String[] args) {
        int []nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 0));
    }
}
