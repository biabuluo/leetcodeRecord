package greed;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{21:47}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:跳跃游戏
 */
public class t55 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for(int i=0;i<=cover;i++){
            cover = Math.max(i+nums[i], cover);
            if(cover>=nums.length-1) return true;
        }
        return false;
    }
}
