package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{23:27}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 轮转数组
 */
public class t189 {
    public static void main(String[] args) {
        int []nums = {1};
        rotate(nums, 2);
    }
    public static void reverse(int []nums, int start, int end){
        int count = (end-start)/2;
        int left = start, right = end-1;
        while (count>0){
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            right--;left++;
            count--;
        }
    }
    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        //整体旋转
        reverse(nums, 0, nums.length);

        reverse(nums, 0, k);

        reverse(nums, k, nums.length);

    }
}
