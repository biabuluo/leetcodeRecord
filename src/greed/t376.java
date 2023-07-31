package greed;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{21:21}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1) return 1;
        int res = 1;
        int prediff = 0;
        for(int i=0;i<nums.length-1;i++){
            int curdiff = nums[i+1]-nums[i];
            if(prediff<=0&&curdiff>0||
            prediff>=0&&curdiff<0){
                res++;
                prediff = curdiff;
            }
        }
        return res;
    }
}
