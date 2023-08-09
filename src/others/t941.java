package others;

/**
 * @author 小宇
 * @date {2023}-{08}-{09}:{22:24}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 有效的山脉数组
 */
public class t941 {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;
        try{
            int left_p = 1;
            while (arr[left_p]>arr[left_p-1]) left_p++;
            int right_p = arr.length-1;
            while (arr[right_p]<arr[right_p-1]) right_p--;
            if(right_p+1==left_p) return true;
            else return false;
        }catch (Exception e){
            return false;
        }
    }
}
