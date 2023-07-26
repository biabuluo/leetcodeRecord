package linklist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{19:44}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 环形链表II
 */
public class t142 {
    //思路1：快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
    //思路2：hashset
    public static ListNode func(ListNode head){
        ListNode cur = head;
        Set<ListNode> nodeSet  =new HashSet<>();
        while (cur!=null){
            if(!nodeSet.contains(cur)){
                nodeSet.add(cur);
                cur = cur.next;
            }else {
                return cur;
            }
        }
        return null;
    }
}
