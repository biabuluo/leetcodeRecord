package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{16}:{14:15}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 链表求和
 */
public class m0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位
        int add = 0;
        ListNode cur1 = l1, cur2 = l2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (cur1!=null && cur2!=null){
            int sum = cur1.val+cur2.val+add;
            add = sum/10;
            ListNode tmp = new ListNode(sum%10);
            cur.next = tmp;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //没有遍历完的情况
        while (cur1!=null){
            int sum = cur1.val+add;
            add = sum/10;
            ListNode tmp = new ListNode(sum%10);
            cur.next = tmp;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2!=null){
            int sum = cur2.val+add;
            add = sum/10;
            ListNode tmp = new ListNode(sum%10);
            cur.next = tmp;
            cur = cur.next;
            cur2 = cur2.next;
        }
        //进位不为0情况
        if (add>0){
            ListNode tmp = new ListNode(add);
            cur.next = tmp;
        }
        return res.next;
    }
}
