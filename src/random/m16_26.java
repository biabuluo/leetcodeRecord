package random;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{08}-{13}:{22:42}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 计算器
 */
//枚举类
enum Operator{
    ADD('+', 1), SUBTRACT('-', 1),
    MULTIPLY('*', 2), DIVIDE('/', 2);
    char value;
    int priority;

    Operator(char val, int pri){
        this.value = val;
        this.priority = pri;
    }
    //判断是否为枚举运算符
    public static boolean isOp(char val){
        for(Operator o : Operator.values()){
            if(o.value == val){
                return true;
            }
        }
        return false;
    }
    //比较优先级
    public static int cmp(char o1, char o2){
        int p1 = 0, p2 = 0;
        for(Operator o : Operator.values()){
            if(o.value == o1) p1 = o.priority;
            if(o.value == o2) p2 = o.priority;
        }
        return p1 - p2;
    }

}


public class m16_26 {
    static Stack<Character> op = new Stack<>();
    static Queue<String> res = new LinkedList<>();

    //构造逆波兰式
    public static void makePolan(String s){
        //构造逆波兰式
        int len = s.length();
        int j = 0, i = 0;
        while(i<len){
            //判断是否为数字
            j=i;
            while (i<len && Character.isDigit(s.charAt(i)) )
                i++;
            if(i!=j)
                res.add(s.substring(j, i));
                //判断是否为op
            else if(Operator.isOp(s.charAt(i))){
                if(op.isEmpty())
                    op.push(s.charAt(i++));
                else {
                    while (!op.isEmpty() && Operator.cmp(s.charAt(i), op.peek())<=0 ){
                        res.add(String.valueOf(op.pop()));
                    }
                    op.push(s.charAt(i++));
                }
            }
            else i++;
        }
        while (!op.isEmpty())
            res.add(String.valueOf(op.pop()));
    }

    public static int calculate(String s) {
        makePolan(s);
        //输出逆波兰式
        for(String tmp : res){
            System.out.print(tmp+' ');
        }
        //计算逆波兰式的值
        Stack<Integer> cal = new Stack<>();
        for(String str : res){
            if(cal.size()>=2 && str.length()==1 && Operator.isOp(str.charAt(0))){
                char op = str.charAt(0);
                int num1 = cal.pop();
                int num2 = cal.pop();
                if(op == '*') cal.push(num1*num2);
                if(op == '/') cal.push(num2/num1);
                if(op == '+') cal.push(num1+num2);
                if(op == '-') cal.push(num2-num1);
            }else
                cal.push(Integer.valueOf(str));
        }
        return cal.peek();
    }

    public static void main(String[] args) {
        String s = " 3/2 ";
        System.out.println(calculate(s));
    }
}
