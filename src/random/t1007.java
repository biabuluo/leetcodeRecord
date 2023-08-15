package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{15}:{17:10}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 行相等的最少多米诺旋转
 */
public class t1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //寻找基准
        int base = tops[0];
        for(int i=1;i<tops.length;i++){
            if(tops[i]!=base && bottoms[i]!=base){
                base = bottoms[0];
                for(int j=1;j<tops.length;j++){
                    if(tops[j]!=base && bottoms[j]!=base){
                        return -1;
                    }
                }
                break;
            }
        }

        //统计基准数
        int top_basenum = 0;
        int bot_basenum = 0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]==base) top_basenum++;
            if(bottoms[i]==base) bot_basenum++;
        }
        return tops.length-Math.max(top_basenum, bot_basenum);
    }
}
