package others;

import java.util.Arrays;
import java.util.*;
/**
 * @author 小宇
 * @date 2023-09-21:9:41
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 收集树中的金币
 *
 */
class t2591{
    public static void main(String[] args) {
        distMoney(16, 2);
        Queue<Integer> queue = new PriorityQueue<>();
    }

    static public int distMoney(int money, int children) {
        if(money<children)
            return -1;
        if(money<children+7)
            return 0;
        int []num = new int[children];
        for(int i=0;i<children;i++){
            num[i] = 1;
        }
        money -= children;
        for(int i=0;i<children;i++){
            if(money<7) break;
            num[i]+=7;
            money-=7;
        }
        //剩下两种情况：money<7 或者 num[i]已经全是8;
        Arrays.sort(num);
        if(num[0] == 8){
            return money==0?children:children-1;
        }
        else{
            if(num[0]+money == 4){
                num[0] += money-1;
                num[1] += 1;
            }else{
                num[0] += money;
            }
            int res = 0;
            for(var i : num){
                if(i==8) res++;
            }
            return res;
        }
    }
}
