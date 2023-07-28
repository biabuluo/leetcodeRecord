package stackqueue;

import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{07}-{28}:{11:57}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 删除字符串中所有相邻重复串
 */
public class t1047 {
    public String removeDuplicates(String s) {
        StringBuffer myStack = new StringBuffer();
        int size = s.length();
        for(int i=0;i<size;i++){
            if(myStack.length()==0) myStack.append(s.charAt(i));
            else {
                if(myStack.charAt(myStack.length()-1)!=s.charAt(i)) myStack.append(s.charAt(i));
                else {
                    myStack.deleteCharAt(myStack.length()-1);
                    continue;
                }
            }
        }
        return myStack.toString();
    }
}
