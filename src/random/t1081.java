package random;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 小宇
 * @date {2023}-{08}-{15}:{18:19}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 不同字符的最小序列
 */
public class t1081 {

    public static void main(String[] args) {
        String s = "ecbacba";
        System.out.println(smallestSubsequence(s));
    }
    public static String smallestSubsequence(String s) {
        //思路：使用单调栈
        //记录元素出现的最后一次下标
        int []lastIndex = new int[26];
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            lastIndex[str[i]-'a'] = i;
        }
        //记录栈中的元素
        boolean []isExist = new boolean[26];
        //维护栈
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<str.length;i++){
            //栈中存在，不需要
            if(isExist[str[i]-'a']) continue;
            //字典序非递增
            while (!stack.isEmpty() && stack.peekLast()>str[i] && lastIndex[stack.peekLast()-'a']>i){
                char tmp = stack.removeLast();
                isExist[tmp-'a'] = false;
            }
            stack.addLast(str[i]);
            isExist[str[i]-'a'] = true;
        }
        //输出结果
        StringBuffer res = new StringBuffer();
        for(char i: stack){
            res.append(i);
        }
        return res.toString();
    }
}
