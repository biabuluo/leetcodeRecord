package linklist;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{16:48}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 删除链表的倒数第n个结点
 * */
public class t19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode scout = new ListNode(0, head);
        ListNode slowp = scout, fastp = scout;
        n++;
        while (n!=0 && fastp!=null){
            fastp = fastp.next;
            n--;
        }
        while (fastp!=null){
            fastp = fastp.next;
            slowp = slowp.next;
        }
        //删除操作
        slowp.next = slowp.next.next;
        return scout.next;
    }
}
