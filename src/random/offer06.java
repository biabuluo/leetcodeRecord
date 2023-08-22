package random;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 小宇
 * @date {2023}-{08}-{22}:{15:03}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 从尾到头打印链表
 */
public class offer06 {
    //使用栈？
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur!=null){
            stack.push(cur.val);
            cur = cur.next;
        }
        int []res = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty())
            res[idx++] = stack.pop();
        return res;
    }
}
