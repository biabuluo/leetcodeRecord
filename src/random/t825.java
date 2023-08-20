package random;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{08}-{20}:{13:02}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 适龄 的朋友
 */
public class t825 {
    //思路: 左右指针
    public int numFriendRequests(int[] ages) {
        int len = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0;
        int res = -1;
        for(var i : ages){
            if(i<=14)
                continue;
            //找到左边界
            while (ages[left]<=0.5* i + 7)
                left++;
            //找右边界
            while (ages[right]<i)
                right++;
            res += right-left+1;
        }
        return res;
    }
}
