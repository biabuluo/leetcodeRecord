package hashlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{9:36}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 判断快乐数
 */
public class t202 {
    public static boolean isHappy(int n) {
        Set<Integer> hashset = new HashSet<>();
        while (n!=1){
            if(hashset.contains(n)) return false;
            hashset.add(n);
            int next = 0;
            while (n>0){
                next += (n%10)*(n%10);
                n /= 10;
            }
            n = next;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 19;
        System.out.println(isHappy(num));
    }
}
