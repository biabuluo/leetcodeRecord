package random;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{19}:{12:17}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 数据流中的中位数
 */
public class offer41 {
    public static void main(String[] args) {
        offer41 a = new offer41();
        a.addNum(-1);
        a.findMedian();
        a.addNum(-2);
        a.findMedian();
        a.addNum(-3);
        a.findMedian();
        a.addNum(-4);
        a.findMedian();
        a.addNum(-5);
        a.findMedian();

    }
    private List<Integer> list;
    private int mid1 = -1;
    private int mid2 = -1;
    public offer41() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int size = list.size();
        if(size%2==0){
            mid1 = size/2;
            mid2 = mid1-1;
        }else
            mid1 = mid2 = size/2;
    }

    public double findMedian() {
        if(mid1==mid2)
            return (double) list.get(mid1);
        else return (double) (list.get(mid1)+list.get(mid2))/2.0;
    }
}
