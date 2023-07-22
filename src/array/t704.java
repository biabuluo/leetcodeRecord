package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{10:19}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 二分查找
 */
public class t704 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        while(true){
            if(nums[left]==target) return left;
            if (nums[right]==target) return right;
            if(left==right||left+1==right) return -1;
            if(nums[mid] == target) return mid;
            if(nums[mid]>target){
                right = mid;
                mid = (left+right)/2;
            }else {
                left = mid;
                mid = (left+right)/2;
            }
        }
    }


    //正经版本
    public static int search2(int[]nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]>target)right = mid-1;
            else if (nums[mid]<target) left = mid+1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        int []nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(search2(nums, target));
    }
}
