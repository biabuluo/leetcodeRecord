package linklist;

/**
 * @author 小宇
 * @date {2023}-{07}-{25}:{23:01}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:移除链表元素
 */
public class t203 {
    public ListNode removeElements(ListNode head, int val) {
        //建立哨兵
        ListNode scout = new ListNode(-1, head);
        ListNode slowp = scout, fastp = head;
        while (fastp!=null){
            if(fastp.val==val){
                slowp.next = fastp.next;
                fastp = fastp.next;
            }else {
                fastp = fastp.next;
                slowp = slowp.next;
            }
        }
        return scout.next;
    }
}


