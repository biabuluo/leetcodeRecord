package linklist;

/**
 * @author 小宇
 * @date {2023}-{07}-{26}:{16:08}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
