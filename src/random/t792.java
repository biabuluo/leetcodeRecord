package random;

import java.util.*;

/**
 * @author 小宇
 * @date 2023-08-27:11:51
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 匹配子序列的单词数
 */
public class t792 {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {
                "a","bb","acd","ace"
        };
        numMatchingSubseq(s, words);
    }
    //思路：多指针
    public static int numMatchingSubseq(String s, String[] words) {
        //对words去重把
        Map<String, Integer> map = new HashMap<>();
        for(var i : words){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        char[][] wordsList = new char[map.size()][];
        int index = 0;
        for(var i : map.entrySet()){
            wordsList[index++] = i.getKey().toCharArray();
        }
        int res = 0;
        int curNum = wordsList.length;
        int []cur = new int[curNum];
        int idx = 0;
        char[] str = s.toCharArray();
        int len = str.length;
        for(idx=0;idx<=len;idx++){
            if(idx==len) {
                for (int i = 0; i < wordsList.length; i++)
                    if (cur[i] >= wordsList[i].length) {
                        cur[i] = -1;
                        String tmp = Arrays.toString(wordsList[i]);
                        res+=map.get(tmp);
                    }
                break;
            }
            for(int i=0;i<wordsList.length;i++){
                if(cur[i]<0)
                    continue;
                if(cur[i]>= wordsList[i].length){
                    cur[i]=-1;
                    String tmp = Arrays.toString(wordsList[i]);
                    res+=map.get(tmp);
                    continue;
                }
                if(wordsList[i][cur[i]]==str[idx])
                    cur[i]++;
            }
        }
        return res;
    }
}
