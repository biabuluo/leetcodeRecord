package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{13}:{15:24}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 机器人能否返回原点
 */
public class t657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(int i=0;i<moves.length();i++){
            char target = moves.charAt(i);
            if(target=='R') x++;
            else if(target=='L') x--;
            else if(target=='U') y++;
            else if(target=='D') y--;
        }
        if(x==0 && y==0) return true;
        else return false;
    }
}
