package hashlist;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{14:39}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 赎金信
 */
public class t383 {
    //思路：构造字母哈希表
    public boolean canConstruct(String ransomNote, String magazine) {
        int []hashlist = new int[26];
        for(int i=0;i<magazine.length();i++){
            hashlist[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(hashlist[ransomNote.charAt(i)-'a']>0){
                hashlist[ransomNote.charAt(i)-'a']--;
            }else return false;
        }
        return true;
    }
}
