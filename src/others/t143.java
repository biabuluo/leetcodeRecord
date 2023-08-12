package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{08}-{10}:{19:40}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 重排链表
 */
public class t143 {
    public void reorderList(ListNode head) {
        if(head==null) return;
        List<ListNode> list = new ArrayList<>();
        List<ListNode> newlist = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            list.add(cur);
            cur = cur.next;
        }
        int left = 0, right = list.size()-1;
        while (left<=right){
            if(left==right) {
                newlist.add(list.get(left));
                break;
            }
            newlist.add(list.get(left));
            newlist.add(list.get(right));
            left++;right--;
        }
        cur = head;
        for(int i=1;i< newlist.size();i++){
            cur.next = newlist.get(i);
            cur = cur.next;
        }
        cur.next=null;
    }
}
