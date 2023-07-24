package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{23:35}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:比较含退格的字符串
 */
public class t844 {

    //解法2：使用双指针
    public static boolean func2(String s, String t){
        int index_s = s.length()-1;
        int index_t = t.length()-1;
        int counter_s = 0, counter_t = 0;
        while(index_t>=0 || index_s>=0) {
            while (index_s>=0){
                if(s.charAt(index_s)=='#'){
                    counter_s++;
                    index_s--;
                }
                else if (counter_s>0&&s.charAt(index_s)!='#'){
                    counter_s--;
                    index_s--;
                }else break;
            }
            while (index_t>=0){
                if(t.charAt(index_t)=='#'){
                    counter_t++;
                    index_t--;
                }
                else if (counter_t>0&&t.charAt(index_t)!='#'){
                    counter_t--;
                    index_t--;
                }else break;
            }
            if(index_s>=0 && index_t>=0){
                if(s.charAt(index_s) == t.charAt(index_t)){
                    index_t--; index_s--;
                }else return false;
            }else {
                if(index_s<0 && index_t<0) break;
                else return false;
            }
        }
        return true;
    }


    //解法1：使用stringbuffer利用栈实现字符串重构
    public static boolean backspaceCompare(String s, String t) {
        System.out.println(rebuild(s));
        System.out.println(rebuild(t));
        return rebuild(s).equals(rebuild(t));
    }
    public static String rebuild(String s){
        StringBuffer stringBuffer = new StringBuffer();
        int len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='#'){
                if(stringBuffer.length()>0) stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }else stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {


        String s = "bxj##tw";
        String t = "bxj###tw";
        System.out.println(func2(s, t));
    }
}
