package others;

/**
 * @author 小宇
 * @date 2023-08-26:11:58
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 三除数
 */
public class t1952 {
    public boolean isThree(int n) {
        int[] primes = new int[]{4, 9, 25, 49, 121, 169, 289, 361, 529, 841, 961, 1369, 1681, 1849, 2209, 2809
                , 3481, 3721, 4489, 5041, 5329, 6241, 6889, 7921, 9409};
        for (int prime : primes) {
            if (n == prime) {
                return true;
            }
        }
        return false;
    }
}
