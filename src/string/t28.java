package string;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{20:57}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 找出字符串中第一个匹配项的下标
 */
public class t28 {
    public static int strStr(String haystack, String needle) {
        int needle_len = needle.length();
        int left = 0, right = needle_len;
        haystack+='#';
        while (right<haystack.length()){
            if(haystack.substring(left, right).equals(needle)){
                return left;
            }
            left++; right++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "leetcode", needle = "leeto";
        System.out.println(strStr(haystack, needle));
    }
}
