package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{16}:{16:01}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 区域和检索-数组不可变
 */
public class t303 {
    int []nums;

    public t303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int res = 0;
        int idx = left;
        while(idx<=right){
            res += nums[idx];
            idx++;
        }
        return res;
    }
}
