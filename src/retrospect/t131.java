package retrospect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{14:53}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 分割回文串
 */
public class t131 {
    public List<List<String>> res = new ArrayList<>();
    public LinkedList<String> path = new LinkedList<>();

    public boolean isSatify(String s){
        int left = 0, right = s.length()-1;
        int count = s.length()/2;
        while (count!=0){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            count--;left++;right--;
        }
        return true;
    }

    //这里是左闭右闭
    public void backtracking(String s, int startIndex){
        if(startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            String test = s.substring(startIndex, i+1);
            if(isSatify(test)){
                path.add(test);
                backtracking(s, i+1);
                path.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }
}
