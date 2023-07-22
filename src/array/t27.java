package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{11:09}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:移除元素  自己写的超出时间限制了。。。。
 */
public class t27 {
    public static int[] sortArray(int[]nums){
        int len = nums.length-1;
        for(int i=0;i<=len-1;i++){
            for(int j=0;j<=len-i-1;j++){
                if(nums[j]<nums[j+1]){
                    nums[j] = nums[j]+nums[j+1];
                    nums[j+1] = nums[j]-nums[j+1];
                    nums[j] = nums[j] - nums[j+1];
                }
            }
        }
        return nums;
    }

    public static int  binarySearch(int[]nums, int val){
        int left = 0;int mid = 0;
        int right = nums.length-1;
        while (left<=right){
            mid = (right+left)/2;
            if(nums[mid]<val) right = mid-1;
            else if(nums[mid]>val) left = mid+1;
            else return mid;
        }
        return -1;
    }

    public static int removeElement(int[] nums, int val) {
        int count = nums.length;
        nums = sortArray(nums);
        int index = binarySearch(nums, val);
        while (index!=-1){
            count --;
            nums[index] = 0;
            nums = sortArray(nums);
            index = binarySearch(nums, val);
        }
        return count;
    }

    public static void main(String[] args) {
        int []nums = {3,3,2,2};
        System.out.println(removeElement(nums, 3));
        System.out.println("------");
        for (int i:nums) System.out.println(i);
    }

}
