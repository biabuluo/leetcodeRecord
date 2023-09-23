package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小宇
 * @date 2023-09-23:9:54
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 树上的操作
 */
public class t1993 {
    private int[] parent;
    private List<List<Integer>> children;
    private int[][] status;
    private int len;

    public t1993(int[] parent) {
        this.len = parent.length;
        this.parent = parent;
        this.children = new ArrayList<>();
        status = new int[len][2];
        //初始化
        for(int i=0;i<len;i++) children.add(new ArrayList<>());
        for(int i=0;i<len;i++) {
            status[i][0] = 0;   //是否上锁
            status[i][1] = 0;  //上锁用户id
            if(parent[i]!=-1) children.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if(status[num][0]!=0) return false;
        status[num][0] = 1;
        status[num][1] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if(status[num][0]==1 && status[num][1]==user){
            status[num][0] = 0;
            status[num][1] = 0;
            return true;
        }else return false;
    }

    public boolean upgrade(int num, int user) {
        if(status[num][0]==0 && childIsLock(num) && !parentIsLock(num)){
            status[num][0] = 1;
            status[num][1] = user;
            //子结点解锁
            unlockUpgrade(num);
            return true;
        }else return false;
    }

    public boolean parentIsLock(int num){
        if(parent[num]==-1 && status[num][0]!=1) return false;
        //找到父节点
        int parentIdx = parent[num];
        if(status[parentIdx][0]==1) return true;
        else return parentIsLock(parentIdx);
    }

    public boolean childIsLock(int num){
        List<Integer> childrenList = children.get(num);
        for(var i:childrenList){
            if(status[i][0]==1) return true;
            else if( childIsLock(i) ){
                return true;
            }
        }
        return false;
    }

    public void unlockUpgrade(int num){
        List<Integer> childrenList = children.get(num);
        for(var i:childrenList){
            if(status[i][0]==1){
                status[i][0] = 0;
                status[i][1] = 0;
            }
            unlockUpgrade(i);
        }
    }
}
