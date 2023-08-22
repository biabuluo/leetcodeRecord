package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{22}:{11:51}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 移动片段得到字符串
 */
public class t2337 {
    public static void main(String[] args) {
        String start = "_L__R__R_";
        String target = "L______RR";
        System.out.println(canChange(start, target));
    }
    //双指针
    public static boolean canChange(String start, String target) {
        int len = start.length();
        int cur_s = 0, cur_t = 0;
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        //遍历
        while (cur_s<len && cur_t<len){
            while (cur_s<len && s[cur_s]=='_')
                cur_s++;
            while (cur_t<len && t[cur_t]=='_')
                cur_t++;
            if(cur_s<len && cur_t<len){
                if(s[cur_s]=='R' && t[cur_t]=='R'){
                    if(cur_s>cur_t)
                        return false;
                    else {
                        cur_s++;
                        cur_t++;
                    }
                }else if(s[cur_s]=='L' && t[cur_t]=='L'){
                    if(cur_s<cur_t)
                        return false;
                    else {
                        cur_s++;
                        cur_t++;
                    }
                }else return false;
            }
        }
        while (cur_s < len) {
            if (s[cur_s] != '_') {
                return false;
            }
            cur_s++;
        }
        while (cur_t < len) {
            if (t[cur_t] != '_') {
                return false;
            }
            cur_t++;
        }
        return true;
    }



}
