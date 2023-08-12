package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{20:20}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 环型链表
 */
public class t141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast_cur = head, slow_cur = head;
        while (fast_cur!=null && fast_cur.next!=null){
            fast_cur = fast_cur.next.next;
            slow_cur = slow_cur.next;
            if(slow_cur == fast_cur) return true;
        }
        return false;
    }
}
