package nowcoder;

import java.util.Scanner;

/**
 * @author 小宇
 * @date 2023-09-04:14:18
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 小美的升序数组
 */
public class mtt1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] list = new int[n];
        for(int i=0;i<=n;i++){
            list[i] = input.nextInt();
        }
        //思路：模拟
        int pre = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int diff = list[i]-list[i-1];
            if(list[i]<=list[i-1] || diff>= pre){
                System.out.println("No");
                break;
            }
        }
        System.out.println("Yes");
    }
}
