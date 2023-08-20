package random;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{20}:{12:29}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 链表组件
 */
public class t817 {
    //我的思路：dp
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(var i : nums)
            set.add(i);
        //遍历一遍head，生成集合
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        //定义dp数组
        int res = 0;
        int []dp = new int[list.size()];
        //初始化dp数组
        if(set.contains(list.get(0)))
            dp[0] = 1;
        //遍历数组
        for(int i=1;i<list.size();i++){
            if( set.contains(list.get(i))){
                dp[i] = 1;
                if(dp[i-1]==1)
                    dp[i-1] = 0;
            }
        }
        for(var i : dp)
            res += i;
        return res;
    }
}
