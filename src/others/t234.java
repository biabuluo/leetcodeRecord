package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{17:50}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 回文链表
 */
public class t234 {
    public ListNode reverse(ListNode head){
        ListNode tmp = null, pre = null;
        while (head!=null){
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
    //思路：分割两半，反转后一半，遍历比较
    public boolean isPalindrome(ListNode head) {
        if (head == null && head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null){
            pre = slow;  // 记录slow的前一个结点
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;  // 分割两个链表

        // 前半部分
        ListNode cur1 = head;
        //翻转链表
        ListNode head2 = reverse(slow);
        while (head!=null){
            if(head2.val!=head.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}
