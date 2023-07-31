package greed;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{22:00}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 跳跃游戏2
 */
public class t45 {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int counter = 0;int cur = 0;
        int next = 0;
        for(int i=0;i<=cur;i++){
            next = Math.max(next, i+nums[i]);
            if(i==cur){
                if(cur!=nums.length-1){
                    cur = next;
                    counter++;
                    if(cur>=nums.length-1) break;
                }else break;
            }
        }
        return counter;
    }
}
