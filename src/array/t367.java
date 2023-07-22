package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{22}:{15:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 有效完全平方数
 */
public class t367 {
    //二分
    public static boolean isPerfectSquare(int num) {
        int right = num/2+1;
        int left = 0, mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if((long)mid*mid>num) right = mid-1;
            else if((long)mid*mid<num) left = mid+1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }
}
