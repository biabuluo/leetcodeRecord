package others;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{15:23}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: Dota2 参议院
 */
public class t649 {
    public String predictPartyVictory(String senate) {
        byte[] newsenate = senate.getBytes();
        boolean R = true, D = true;
        //当flag大于0时，R在D前出现，小于0时，D在R前出现
        int flag = 0;
        while (R && D){
            R = false;
            D = false;
            for(int i=0;i<newsenate.length;i++){
                if(newsenate[i] == 'R'){
                    if(flag < 0) newsenate[i] = 0;
                    else R = true;
                    flag++;
                }
                if(newsenate[i] == 'D'){
                    if(flag > 0) newsenate[i] = 0;
                    else D = true;
                    flag--;
                }
            }
        }
        return R == true? "Radiant" : "Dire";
    }
}
