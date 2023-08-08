package dp;

/**
 * @author 小宇
 * @date {2023}-{08}-{08}:{23:02}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 判断子序列
 */
public class t392 {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int idx_s = 0;
        for(int j=0;j<t.length();j++){
            if(t.charAt(j)==s.charAt(idx_s)) idx_s++;
            if(idx_s==s.length()) break;
        }
        return idx_s == s.length();
    }
}
