package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{21:34}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 长按键入
 */
public class t925 {
    public boolean isLongPressedName(String name, String typed) {
        //使用双指针
        int np = 0, tp = 0;
        while (np<name.length() && tp<typed.length()){
            if(name.charAt(np)==typed.charAt(tp)){
                np++; tp++;
            }
            else {
                if(np==0 || typed.charAt(tp)!=typed.charAt(tp-1)) return false;
                while (tp<typed.length() && typed.charAt(tp)==typed.charAt(tp-1)) tp++;
            }
        }
        if(np<name.length()) return false;
        while (tp<typed.length()){
            if (typed.charAt(tp) == typed.charAt(tp-1)) tp++;
            else return false;
        }
        return true;
    }
}
