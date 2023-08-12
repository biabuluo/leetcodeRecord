package others;

import java.util.*;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{22:57}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 单词接龙
 */
public class t127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //处理数据
        Set<String> set = new HashSet<>(wordList);
        if(set.size()==0 || !set.contains(endWord)) return 0;
        //数据结构
        Queue<String> queue = new LinkedList<>();   //广搜索队列
        Map<String, Integer>map = new HashMap<>();  //记录经过单词+长度
        //初始化
        queue.add(beginWord);
        map.put(beginWord, 1);
        //bfs
        while (!queue.isEmpty()){
            //获取第一个单词
            String word = queue.poll();
            int len = map.get(word);
            for(int i=0;i<word.length();i++){
                char[] wordlist = word.toCharArray();
                for(char j='a';j<='z';j++){
                    wordlist[i] = j;
                    String newString = String.valueOf(wordlist);
                    if (newString.equals(endWord)) return len+1;
                    //字典中存在，且没有经历过
                    if (set.contains(newString) && !map.containsKey(newString)){
                        queue.add(newString);
                        map.put(newString, len+1);
                    }
                }
            }
        }
        return 0;
    }
}
