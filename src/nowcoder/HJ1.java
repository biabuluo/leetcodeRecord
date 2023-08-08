package nowcoder;
import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{06}:{14:58}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class HJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine().trim();
            String[] b = a.split(" ");
            System.out.println(b[b.length-1].length());
        }
    }
}
