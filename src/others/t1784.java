package others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{08}-{24}:{11:57}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 检查二进制字符串字段
 */
public class t1784 {
    public static void main(String[] args) {
        String s = "111";
        checkOnesSegment(s);
    }
    public static boolean checkOnesSegment(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] str = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(str[i]=='1'){
                if(stack.isEmpty())
                    stack.push(i);
                else {
                    int pre = stack.peek();
                    if(i!=pre+1)
                        return false;
                    else
                        stack.push(i);
                }
            }
        }
        return true;
    }
}
