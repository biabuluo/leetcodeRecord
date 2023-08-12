package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{15:37}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 分割平衡字符串
 */
public class t1221 {
    //思路：贪心
    public int balancedStringSplit(String s) {
        int res = 0;
        //R+1   L-1
        int flag = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R') flag++;
            if(s.charAt(i)=='L') flag--;
            if(flag==0){
                flag = 0;
                res++;
            }
        }
        return res;
    }
}
