package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{15}:{18:08}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 字符串的最大公因子
 */
public class t1071 {
    //辗转相除法
    public int gcd(int a, int b){
        int c = a%b;
        while (c!=0){
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    public boolean isSatify(String sub, String s){
        int num = s.length()/sub.length();
        StringBuffer stringBuffer = new StringBuffer();
        while (num>0){
            stringBuffer.append(sub);
            num--;
        }
        if(stringBuffer.toString().equals(s))
            return true;
        else return false;
    }

    public String gcdOfStrings(String str1, String str2) {
        //判断是否可行
        String s1 = str1+str2;
        String s2 = str2+str1;
        if(!s1.equals(s2)) return "";
        //求长度的最大公因子
        int idx = gcd(s1.length(), s2.length());
        String tmp = str1.substring(0, idx);
        if(isSatify(tmp, str1) && isSatify(tmp, str2))
            return tmp;
        else return "";
    }
}
