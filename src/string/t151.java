package string;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{20:03}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 反转字符串中的单词
 */
public class t151 {
    //使用split分割
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for(int i= words.length-1;i>=0;i--){
            if(words[i].equals("")){
                continue;
            }
            stringBuffer.append(words[i]);
            if(i!=0) {
                stringBuffer.append(" ");
            }
        }

        return stringBuffer.toString().trim();
    }

    public static void main(String[] args) {
        String test = "a good   example";
        System.out.println(reverseWords(test));
    }
}
