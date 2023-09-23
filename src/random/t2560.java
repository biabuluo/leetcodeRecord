package random;

/**
 * @author 小宇
 * @date 2023-09-19:9:47
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 打家劫舍IV
 */
public class t2560 {
    //思路：二分
    public int getCount(int[] nums, int middle){
        boolean visited = false;
        int count = 0;
        for(var i:nums){
            if(i<=middle && !visited){
                count++;
                visited = true;
            }else{
                visited = false;
            }
        }
        return count;
    }


    public int minCapability(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
        for(var i: nums){
            if(i>maxVal) maxVal = i;
            if(i<minVal) minVal = i;
        }
        //二分
        while(maxVal>=minVal){
            int mid = (maxVal+minVal)/2;
            int count = getCount(nums, mid);
            if(count>=k) {
                maxVal = mid - 1;
            }else{
                minVal = mid + 1;
            }
        }
        return minVal;
    }
}
