package random;

/**
 * @author 小宇
 * @date 2023-09-07:10:01
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 修车最少时间
 */
public class t2594 {
    //思路：二分

    public static void main(String[] args) {
        int []ranks = {4,2,3,1};
        int cars = 10;
        repairCars(ranks, cars);
    }

    public static Boolean isSatisfy(int[] ranks, int cars, long time){
        long sum = 0;
        for(var i:ranks){
            sum+=(long)Math.sqrt(time/i);
        }
        return sum>=cars;
    }

    public static long repairCars(int[] ranks, int cars) {
        //计算上界
        long res = Long.MAX_VALUE;
        long upper = (long) ranks[0] * cars * cars;
        //二分
        long left = 0;
        long right = upper;
        while (left<=right){
            long mid = (left+right)/2;
            if(isSatisfy(ranks, cars, mid)){
                res = Math.min(res, mid);
                right = mid-1;
            }else
                left = mid+1;
        }
        return res;
    }
}
