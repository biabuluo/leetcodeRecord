package random;

/**
 * @author 小宇
 * @date 2023-08-27:11:42
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 1比特与2比特
 */
public class t717 {
    //正序遍历
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int cur = 0;
        while (true){
            if(cur==len-1)
                return true;
            if(cur>len-1)
                return false;
            if(bits[cur]==0)
                cur++;
            if(bits[cur]==1)
                cur+=2;
        }
    }
}
