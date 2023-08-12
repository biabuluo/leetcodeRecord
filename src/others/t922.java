package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{14:22}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 按奇偶排序数组II
 */
public class t922 {
    public int[] sortArrayByParityII(int[] nums) {
        //思路：双指针
        int odd = 1, pair = 0;
        while (odd<nums.length && pair<nums.length-1){
            while(odd<nums.length && nums[odd]%2==1) odd+=2;
            while (pair<nums.length-1 && nums[pair]%2==0) pair+=2;
            if(odd<nums.length && pair<nums.length){
                int tmp = nums[odd];
                nums[odd] = nums[pair];
                nums[pair] = tmp;
                odd+=2;pair+=2;
            }
            else break;
        }
        return nums;
    }
}
