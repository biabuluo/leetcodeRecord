package others;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 小宇
 * @date 2023-08-26:11:52
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 可以输入的最大单词数
 */
public class t1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        char[] borken = brokenLetters.toCharArray();
        for(var i : borken){
            set.add(i);
        }
        String[] words = text.split(" ");
        int res = 0;
        for(var i : words){
            boolean flag = true;
            for(var j : set){
                if(i.contains(String.valueOf(j))){
                    flag = false;
                    break;
                }
            }
            if(flag)
                res++;
        }
        return res;
    }
}
