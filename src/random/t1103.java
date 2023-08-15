package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{15}:{20:39}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 分糖果II
 */
public class t1103 {
    public static void main(String[] args) {
        int candiex = 60, num_people = 4;
        System.out.println(distributeCandies(candiex, num_people));
    }
    public static int[] distributeCandies(int candies, int num_people) {
        int []res = new int[num_people];
        int curcandies = 1;
        int idx = 0;
        while (candies > 0){
            //糖果足够的情况
            if(candies>=curcandies){
                res[idx] += curcandies;
                candies -= curcandies;
                curcandies++;
                idx = (idx+1)%num_people;

            }else {
                res[idx] += candies;
                candies -= curcandies;
                idx = (idx+1)%num_people;
            }
        }
        return res;
    }
}
