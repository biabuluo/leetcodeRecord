package array;

import static java.lang.Math.sqrt;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{15:09}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 寻找x的平方根，择半查找【0-x/2】
 */
public class t69 {
    public static int mySqrt(int x) {
        int left = 0, right = x/2+1, ans = -1;
        int mid = 0;

        while(left<=right){
            mid = (left+right)/2;
            if((long)mid*mid<=x){
                ans = mid;
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
