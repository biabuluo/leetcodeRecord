package random;

/**
 * @author 小宇
 * @date 2023-09-02:11:11
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最多可以摧毁的敌人城堡数目
 */
public class t2511 {
    //思路：枚举
    public int captureForts(int[] forts) {
        int cur = 0, l = 0, r = 0;
        int res = 0;
        int len = forts.length;
        for(cur=0; cur<len; cur++){
            if(forts[cur]==-1){
                int len_l = 0, len_r = 0;
                l = cur-1;
                r = cur+1;
                while (l>=0 && forts[l]==0)
                    l--;
                while (r<len && forts[r]==0)
                    r++;
                if(l>=0 && forts[l]==1)
                    len_l = cur-l-1;
                if(r<len && forts[r]==1)
                    len_r = r-cur-1;
                res = Math.max(res, len_l);
                res = Math.max(res, len_r);
            }
        }
        return res;
    }
}
