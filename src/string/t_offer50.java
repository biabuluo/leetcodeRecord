package string;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{19:59}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 替换空格
 */
public class t_offer50 {
    public static String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                stringBuffer.append("%20");
            }else stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
