package linklist;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{15:22}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 反转链表
 */

public class t206 {
    //思路1：双指针
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    //思路2：递归
    public ListNode recursion(ListNode head){
        ListNode pre = null, cur = head;
        return recurrent(pre, cur);
    }
    ListNode recurrent(ListNode pre, ListNode cur){
        if(cur==null) return pre;
        else {
            ListNode tmp = cur.next;
            cur.next = pre;
            return recurrent(cur, tmp);
        }
    }
}
