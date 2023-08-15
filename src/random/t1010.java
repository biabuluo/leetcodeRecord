package random;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{15}:{21:37}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 总持续时间可被60整除的歌曲
 */
public class t1010 {
    //OK没毛病， 超时了

    //思路：两数和
    public static int func(int []time){
        int []newTime = Arrays.stream(time).boxed()
                .map((a)->a%60).mapToInt(Integer::intValue)
                .toArray();
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<newTime.length;i++){
            if(map.containsKey(newTime[i]))
                res += map.get(newTime[i]);
            map.put((60-newTime[i])%60, map.getOrDefault((60-newTime[i])%60, 0)+1);
        }
        return res;
    }


    public static void main(String[] args) {
        int []time = {60, 60, 60};
        System.out.println(func(time));
    }
    public  static int res = 0;
    public static int duration = 0;
    public static List<List<Integer>> reslist = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();
    public static void backtracking(int []time, int n, int idx_s){
        if(n==2){
            if(duration%60==0) {
                reslist.add(new ArrayList<>(path));
                res++;
            }
        }else {
            for(int i=idx_s;i<time.length;i++){
                duration += time[i];
                path.add(time[i]);
                backtracking(time, n+1, i+1);
                path.remove(path.size()-1);
                duration -= time[i];
            }
        }
    }

    public static int numPairsDivisibleBy60(int[] time) {
        backtracking(time, 0, 0);
        return res;
    }
}
