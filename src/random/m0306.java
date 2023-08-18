package random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小宇
 * @date {2023}-{08}-{17}:{14:03}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 动物收容所
 */
public class m0306 {
    //定义数据结构
    Queue<Integer[]> catShelf;
    Queue<Integer[]> dogShelf;

    public m0306(){
        catShelf = new LinkedList<>();
        dogShelf = new LinkedList<>();
    }
    public void enqueue(int[] animal) {
        if(animal[1]==1)
            dogShelf.add(new Integer[]{animal[0], animal[1]});
        else
            catShelf.add(new Integer[]{animal[0], animal[1]});
    }

    public int[] dequeueAny() {
        int []res = {-1, -1};
        if(dogShelf.isEmpty() && !catShelf.isEmpty()){
            Integer[] tmp = catShelf.poll();
            res[0] = tmp[0];
            res[1] = tmp[1];
            return res;
        }else if(!dogShelf.isEmpty() && catShelf.isEmpty()){
            Integer[] tmp = dogShelf.poll();
            res[0] = tmp[0];
            res[1] = tmp[1];
            return res;
        }else if(!dogShelf.isEmpty() && !catShelf.isEmpty()){
            if(dogShelf.peek()[0]<=catShelf.peek()[0]){
                Integer[] tmp = dogShelf.poll();
                res[0] = tmp[0];
                res[1] = tmp[1];
                return res;
            }else {
                Integer[] tmp = catShelf.poll();
                res[0] = tmp[0];
                res[1] = tmp[1];
                return res;
            }
        }else {
            return res;
        }
    }

    public int[] dequeueDog() {
        int []res = {-1, -1};
        if(!dogShelf.isEmpty()){
            Integer[] tmp = dogShelf.poll();
            res[0] = tmp[0];
            res[1] = tmp[1];
        }
        return res;
    }

    public int[] dequeueCat() {
        int []res = {-1, -1};
        if(!catShelf.isEmpty()){
            Integer[] tmp = catShelf.poll();
            res[0] = tmp[0];
            res[1] = tmp[1];
        }
        return res;
    }
}
