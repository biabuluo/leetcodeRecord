package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{16}:{16:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 字母移位
 */
public class t848 {
    //思路：前缀和
    public String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;
        shifts[len-1] %= 26;
        for(int i=len-2;i>=0;i--){
            shifts[i] = (shifts[i]+shifts[i+1])%26;
        }
        //遍历数组
        char []str = s.toCharArray();
        for(int i=0;i<len;i++){
            str[i] = (char)('a'+(str[i]-'a'+shifts[i])%26);
        }
        return String.valueOf(str);
    }
}
