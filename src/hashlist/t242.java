package hashlist;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{21:11}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:有效的字母异位词
 */
public class t242 {
    //思路1：hash数组
    public boolean isAnagram(String s, String t) {
        int []hashlist = new int[26];
        for (int i=0;i<s.length();i++){
            hashlist[s.charAt(i)-'a'] ++;
        }
        for(int i=0;i<t.length();i++){
            hashlist[t.charAt(i)-'a'] --;
        }
        for (int i=0;i<hashlist.length;i++){
            if(hashlist[i]!=0) return false;
        }
        return true;
    }

}
