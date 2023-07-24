package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{23}:{16:27}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:有序数组的平方+（各种排序算法实现+手撸）
 */
public class t977 {

    //官方答案：双指针法
    public static int[] boublePointer(int []nums){
        int []res = new int[nums.length];
        if(nums.length==1){
            res[0] = nums[0]*nums[0];
            return res;
        }
        int right = nums.length-1, index = nums.length-1;
        int left = 0, flag = 0;
        while (left<right){
            if(nums[right]*nums[right] > nums[left]*nums[left]){
                res[index] = nums[right]*nums[right];
                index--;
                right--;
                flag = 0;
            }else{
                res[index] = nums[left]*nums[left];
                index--;
                left++;
                flag = 1;
            }
            if(flag == 1){
                res[index] = nums[right]*nums[right];
            }else res[index] = nums[left] * nums[left];
        }
        return res;
    }


    //选择排序
    public static void selectSort(int []nums){
        int len = nums.length;
        for(int i=0; i<len; i++){
            int k = i;
            for(int j=i+1; j<len; j++) {
                if(nums[j]<nums[k]) k = j;
            }
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }
    }
    //插入排序:原始数列基本有序时排序高效
    public static void insertSort(int []nums){
        int len = nums.length;
        for(int i=1;i<len;i++){
            for(int j=i;j>=1&&nums[j]<nums[j-1];j--){
                int tmp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = tmp;
            }
        }
    }
    //希尔排序：优化版插入排序
    public static void shellSort(int []nums){
        int h = 4, len = nums.length;
        while (h>=1){
            for(int i=h;i<len;i+=h){
                for(int j=i;j>=1&&nums[j]<nums[j-h];j-=h){
                    nums[j] = nums[j-h]+nums[j];
                    nums[j-h] = nums[j]-nums[j-h];
                    nums[j] = nums[j] - nums[j-h];
                }
            }
            h/=2;
        }
    }
    //快速排序
    public static void quickSort(int []nums, int left, int right){
        int i=left, j=right;
        int pivot = nums[i];
        if(left>=right) return;
        while (i<j){
            while (i<j&&nums[j]>=pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i<j&&nums[i]<=pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }

    //自己的思路：平方再排序 时间复杂度：O(n^2)
    public static int[] sortedSquares(int[] nums) {
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        //冒泡排序
        int size = nums.length-1;
        for(int i=0; i<=size-1; i++){
            for(int j=0; j<=size-i-1; j++){
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int []nums ={-7,-3,2,3,11};
        int []res = boublePointer(nums);
        for (int i:res
             ) {
            System.out.println(i);
        }
    }
}
