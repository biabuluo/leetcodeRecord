package retrospect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{07}-{30}:{13:58}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description:
 */
public class t17 {
    public String[] map = {
            "abc","def","ghi","jkl", "mno","pqrs","tuv","wxyz"
    };

    List<String> res = new ArrayList<>();
    StringBuffer path = new StringBuffer();

    public void backtracking(String digits, int startIndex){
        if(startIndex==digits.length()){
            res.add(path.toString());
            return;
        }
        String set = map[digits.charAt(startIndex)-'2'];
        for(int i=0;i<set.length();i++){
            path.append(set.charAt(i));
            backtracking(digits, startIndex+1);
            path.deleteCharAt(path.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return res;
        backtracking(digits, 0);
        return res;
    }
}
