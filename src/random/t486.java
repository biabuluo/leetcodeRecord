package random;


/**
 * @author 小宇
 * @date {2023}-{08}-{22}:{14:26}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 预测赢家
 */
public class t486 {
    //递归+零和博弈
    public int optimize(int []nums, int l, int r){
        int sum = 0;
        for(int i=l;i<=r;i++)
            sum+=nums[i];
        if(l==r)
            return nums[l];
        else {
            return sum - Math.min(optimize(nums, l+1, r), optimize(nums, l, r-1));
        }
    }

    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for(var i : nums)
            sum+=i;
        return optimize(nums, 0, nums.length-1)>=sum/2.0;
    }
}
