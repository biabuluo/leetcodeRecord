package others;

import java.util.List;

/**
 * @author 小宇
 * @date {2023}-{08}-{12}:{19:52}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 钥匙和房间
 */
public class t841 {
    boolean []visited;

    public boolean isValid(){
        for(int i=0;i<visited.length;i++)
            if (!visited[i]) return false;
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int node){
        //递归退出条件
        if(visited[node]) return;
        visited[node] = true;
        for(int i=0;i<rooms.get(node).size();i++){
            dfs(rooms, rooms.get(node).get(i));
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);
        return isValid();
    }
}
