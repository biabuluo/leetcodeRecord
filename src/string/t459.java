package string;

/**
 * @author 小宇
 * @date {2023}-{07}-{27}:{22:02}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 重复的子字符串
 */

/**
 * KMP算法：解决子串匹配的问题
 */

public class t459 {
    //KMP获取next数组函数
    public static int[] getNext(String s){
        int[] res = new int[s.length()];
        res[0] = 0;
        int prefix = 0;
        for(int suffix=1;suffix<s.length();suffix++){
            //前缀不匹配情况
            while (prefix>0 && s.charAt(prefix)!=s.charAt(suffix)){
                prefix = res[prefix-1];
            }
            //前缀匹配
            if(s.charAt(prefix)==s.charAt(suffix)){
                prefix++;
            }
            res[suffix] = prefix;
        }
        return res;
    }

//移动匹配思想：s+s去头去尾是否包含s
    public boolean repeatedSubstringPattern1(String s) {
        StringBuffer test = new StringBuffer();
        for(int i=1;i<s.length();i++){
            test.append(s.charAt(i));
        }
        for(int i=0;i<s.length()-1;i++){
            test.append(s.charAt(i));
        }
        if(test.toString().contains(s)){
            return true;
        }else return false;
    }


    //使用kmp算法：如果由重复子串构成=>子串=最长相等前后缀所不包含的子串
    //如果原串能够整除len-next[-1]=>true
    public boolean repeatedSubstringPattern2(String s) {
        if(s.length()<=1) return false;
        //获取next数组
        int []next = new int[s.length()];
        int prefix = 0; next[0] = 0;
        for(int suffix=1;suffix<s.length();suffix++){
            //处理前后缀不同情况
            while (prefix>0 && s.charAt(prefix)!=s.charAt(suffix)){
                prefix = next[prefix-1];
            }
            //处理前后缀相等情况
            if(s.charAt(prefix)==s.charAt(suffix)){
                prefix++;
            }
            next[suffix] = prefix;
        }
        if(next[next.length-1]!=0&&s.length()%(s.length()-next[next.length-1])==0){
            return true;
        }else return false;

    }
    public static void main(String[] args) {
        String str = "aabaaf";
        System.out.println(getNext(str));
    }
}


