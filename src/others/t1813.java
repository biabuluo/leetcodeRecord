package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{24}:{12:08}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 句子相似性
 */
public class t1813 {
    //思路：使用双指针
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String [] s1 = sentence1.split(" ");
        String [] s2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i<s1.length && i<s2.length && s1[i].equals(s2[i]))
            i++;
        while (j<s1.length-i && j<s2.length-i && s1[s1.length-j-1].equals(s2[s2.length-j-1]))
            j++;
        return i+j == Math.min(s1.length, s2.length);
    }
}
