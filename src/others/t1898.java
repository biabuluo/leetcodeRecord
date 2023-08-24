package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{24}:{14:12}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 可移除字符的最大数目
 */
public class t1898 {
    public boolean isValid(int cur, int []removable, String s, String p){
        //删除字符
        char[] str_s = s.toCharArray();
        char[] str_p = p.toCharArray();
        for(int i=0;i<=cur;i++)
            str_s[i] = 0;
        //确认是否为子序列
        int idx = 0;
        for(int i=0;i<str_s.length;i++){
            if(str_s[i]==str_p[idx]) {
                idx++;
                if(idx>=str_p.length)
                    return true;
            }
        }
        return false;
    }

    //思路：二分查找
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 1;
        int r = removable.length;
        int ans = 0;
        //二分查找
        while (l<=r){
            int mid = (l+r)/2;
            if(isValid(mid, removable, s, p)){
                ans = mid;
                l = mid+1;
            }else
                r = mid-1;
        }
        return ans;
    }
}
