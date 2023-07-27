package string;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{21:57}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:左旋转字符串
 */
public class t_offer58 {
    //思路：直接重构字符串
    public String reverseLeftWords(String s, int n) {
        StringBuffer res = new StringBuffer();
        res.append(s.substring(n, s.length()));
        res.append(s.substring(0, n));
        return res.toString();
    }
}
