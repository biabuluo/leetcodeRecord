package nowcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 小宇
 * @date 2023-09-04:14:25
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 小美的子序列
 */
public class mtt2 {
    //思路：暴力
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        if(n<7){
            System.out.println("No");
            return;
        }
        char[] rsc = {'m', 'e', 'i', 't', 'u', 'a', 'n'};
        int idx = 0;
        for(int i=0;i<n;i++){
            String str = input.nextLine();
            if(str.contains(String.valueOf(rsc[idx]))){
                idx++;
            }
            //剪枝
            if(n-i<7-idx){
                System.out.println("No");
                break;
            }
        }
        if(idx>=7)
            System.out.println("Yes");
        else System.out.println("No");
    }
}
