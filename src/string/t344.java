package string;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{16:34}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:反转字符串
 */
public class t344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        for(int i=0;i<s.length/2;i++){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;right--;
        }
    }
}
