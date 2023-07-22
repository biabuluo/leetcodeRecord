package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{07}-{08}:{21:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t3 {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> charset = new HashSet<Character>();
        char[] charlist = s.toCharArray();
        for(int i=0;i<charlist.length;i++){
            charset.clear();
            for (int j = i;j<charlist.length;j++){
                if (charset.contains(charlist[j])){
                    if (charset.size()>max) {
                        max = charset.size();
                    }
                    break;
                }else charset.add(charlist[j]);
            }
            if(charset.size()>max) max = charset.size();

        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("jbpnbwwd"));

    }
}
