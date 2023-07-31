package greed;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{20:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 分发饼干
 */
public class t455 {
    public static int findContentChildren(int[] g, int[] s) {
        int res = 0; int cookie = s.length-1;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=g.length-1;i>=0;i--){
            if(cookie>=0&&g[i]<=s[cookie]){
                res++; cookie--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []g = {1,2,3}, s ={1,1 };
        System.out.println(findContentChildren(g, s));
    }
}
