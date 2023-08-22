package random;

/**
 * @author 小宇
 * @date {2023}-{08}-{22}:{15:08}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 合并两个有序链表
 */
public class t21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list2==null)
            return list1;
        if (list1==null)
            return list2;
        //构造哨兵
        ListNode res = new ListNode();
        ListNode cur = res.next;
        ListNode cur_a = list1, cur_b = list2;
        while (cur_a!=null && cur_b!=null){
            if(cur_a.val<=cur_b.val){
                cur.next = cur_a;
                cur = cur.next;
                cur_a = cur_a.next;
                cur.next = null;
            }else {
                cur.next = cur_b;
                cur = cur.next;
                cur_b = cur_b.next;
                cur.next = null;
            }
        }
        if (cur_a!=null){
            cur.next = cur_a;
        }
        if(cur_b!=null){
            cur.next = cur_b;
        }
        return res.next;
    }
}
