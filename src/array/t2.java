package array;

/**
 * @author 小宇
 * @date {2023}-{07}-{08}:{19:41}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode index = res;
        int add = 0;
        while (l1!=null && l2!=null){
            int val = l1.val + l2.val + add;
            ListNode tmp;
            if(val > 9){
                tmp = new ListNode(val - 10);
                add  = 1;
            }
            else {
                tmp = new ListNode(val);
                add  = 0;
            }
            index.next = tmp;
            index = index.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            int val = l1.val + add;
            ListNode tmp;
            if(val>9){
                tmp = new ListNode(val - 10);
                add = 1;
            }else {
                tmp = new ListNode(val);
                add = 0;
            }
            index.next = tmp;
            index = index.next;
            l1 = l1.next;
        }
        while (l2!=null){
            int val = l2.val + add;
            ListNode tmp;
            if(val>9){
                tmp = new ListNode(val - 10);
                add = 1;
            }else {
                tmp = new ListNode(val);
                add = 0;
            }
            index.next = tmp;
            index = index.next;
            l2 = l2.next;
        }
        if(add != 0){
            ListNode tmp = new ListNode(1);
            index.next = tmp;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode input3 = new ListNode(3);
        ListNode input2 = new ListNode(4);
        ListNode a = new ListNode(2);
        a.next = input2;
        input2.next = input3;

        input3 = new ListNode(4);
        input2 = new ListNode(6);
        ListNode b = new ListNode(5);
        b.next = input2;
        input2.next = input3;
        ListNode res = addTwoNumbers(a, b);
    }
}

class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



