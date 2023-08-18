package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{17}:{15:00}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 回文链表
 */
public class m0206 {

    public ListNode reverse(ListNode head){
        ListNode tmp;
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    public boolean isEqual(ListNode a, ListNode b){
        ListNode cur_a = a, cur_b = b;
        while (a!=null && b!=null){
            if(a.val!=b.val)
                return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        //获取链表长度
        ListNode cur = head;
        int len = 0;
        while (cur!=null){
            len++;
            cur = cur.next;
        }
        if(len<=1) return true;
        //求分界点
        int count = len/2;
        ListNode a = head;
        ListNode b = head;
        ListNode pre = null;
        while (count>0){
            pre = b;
            b = b.next;
            count--;
        }
        pre.next = null;
        //分奇 偶
        if(len%2!=0){
            b = b.next;
        }
        b = reverse(b);
        return isEqual(a, b);
    }
}
