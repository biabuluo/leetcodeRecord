package linklist;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{16:08}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 两两交换链表中的结点
 */
public class t24 {
    //思路：纯遍历
    public ListNode swapPairs(ListNode head) {
        ListNode scout = new ListNode(0, head);
        ListNode cur = scout;
        //分奇偶
        while (cur.next != null && cur.next.next != null){
            //swap
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = tmp.next.next;
            cur.next.next = tmp;
            cur = cur.next.next;
        }
        return  scout.next;
    }
}
