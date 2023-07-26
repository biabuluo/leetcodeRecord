package linklist;

import java.util.Scanner;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{19:15}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 相交链表
 */
public class t160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur_a = headA;  int size_a = 0;
        ListNode cur_b = headB;  int size_b = 0;
        //获取链表size
        while (cur_a!=null){
            cur_a = cur_a.next;
            size_a++;
        }
        while (cur_b!=null){
            cur_b = cur_b.next;
            size_b++;
        }
        if(size_a >= size_b){
            int n = size_a-size_b;
            cur_a = headA;
            cur_b = headB;
            while (n!=0){
                cur_a = cur_a.next;
                n--;
            }
            //判断cur是否一致
            while (cur_a!=null&&cur_b!=null){
                if(cur_a == cur_b) return cur_a;
                else {
                    cur_a = cur_a.next;
                    cur_b = cur_b.next;
                }
            }
        }else {
            int n = size_b-size_a;
            cur_a = headA;
            cur_b = headB;
            while (n!=0){
                cur_b = cur_b.next;
                n--;
            }
            //判断cur是否一致
            while (cur_a!=null&&cur_b!=null){
                if(cur_a == cur_b) return cur_a;
                else {
                    cur_a = cur_a.next;
                    cur_b = cur_b.next;
                }
            }
        }
        return null;
    }
}
