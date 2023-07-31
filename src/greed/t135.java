package greed;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{23:07}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t135 {
    public int candy(int[] ratings) {
        int []candynums = new int[ratings.length];
        for (int i=0;i<candynums.length;i++){
            candynums[i] = 1;
        }
        for(int i=1;i<candynums.length;i++){
            if(ratings[i]>ratings[i-1]) candynums[i]+=1;
        }
        for(int i=candynums.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) candynums[i] = Math.max(candynums[i], candynums[i+1]+1);
        }
        int res = 0;
        for (int i:candynums
             ) {
            res+=i;
        }
        return res;
    }
}
