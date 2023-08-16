package random;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{16}:{14:27}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 最长不含重复字符的子字符串
 */
public class offer48 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(func(s));
    }
    //思路：滑动窗口
    public static int func(String s){
        char[]str = s.toCharArray();
        int len = s.length();
        int res = 1;
        if(s.length()==1) return res;
        //使用set存储不重复字符
        Map<Character, Integer> map = new HashMap<>();
        map.put(str[0], 0);
        int idx_s = 0;
        for(int idx_e=1;idx_e<len;idx_e++){
            if(map.containsKey(str[idx_e])){
                idx_s = map.get(str[idx_e])+1;
                //删除map中idx<idx_s的元素
                Iterator<Integer> iter = map.values().iterator();
                while (iter.hasNext()){
                    if(iter.next()<idx_s){
                        iter.remove();
                    }
                }
            }
            map.put(str[idx_e], idx_e);
            res = Math.max(res, idx_e-idx_s+1);
        }
        return res;
    }




    //思路：dp  :结果：内存超标！！！！
    public static int lengthOfLongestSubstring(String s) {
        char []str = s.toCharArray();
        int res = 0;
        //定义dp数组
        int [][]dp = new int[s.length()][s.length()];
        //初始化dp数组
        //遍历dp数组
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(i==j) dp[i][j] = 1;
                else{
                    int idx = j-1;
                    while (idx>=i){
                        if(str[idx]==str[j]){
                            dp[i][j] = dp[idx+1][j];
                            break;
                        }
                        idx--;
                    }
                    if(idx<i)
                        dp[i][j] = dp[i][j-1]+1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
