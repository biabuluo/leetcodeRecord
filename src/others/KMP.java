package others;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{08}-{05}:{15:49}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: KMP算法
 */
public class KMP {
    //冒泡
    public static void buble(int []nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=1;j<= nums.length-1-i;j++){
                if(nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
            }
        }
    }
    //选择
    public static void select(int []nums){
        for(int i=0;i<nums.length-1;i++){
            int minindex = i;
            for(int j=i+1;j<nums.length;j++)
                if(nums[minindex]>nums[j]) minindex = j;
            int tmp = nums[minindex];
            nums[minindex] = nums[i];
            nums[i] = tmp;
        }
    }
    //插入
    public static void inject(int[]nums){
        for(int i=1;i<nums.length;i++){
            int val = nums[i];int j = i-1;
            while (j>=0&&nums[j]>val){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = val;
        }
    }
    //希尔
    public static void shell(int[]nums){
        int len = nums.length;
        for(int gap=len/2;gap>0;gap/=2){
            for(int i=gap;i<nums.length;i++){
                int val = nums[i];int j = i-gap;
                while (j>=0&&nums[j]>val){
                    nums[j+gap] = nums[j];
                    j-=gap;
                }
                nums[j+gap] = val;
            }
        }
    }
    //块排
    public static void quick(int []nums, int left, int right){
        if(left>=right) return;
        int pivot = nums[left];
        int index_l = left, index_r = right;
        while(index_l<index_r){
            while (index_l<index_r&&nums[index_r]>=pivot) index_r--;
            nums[index_l] = nums[index_r];
            while (index_l<index_r&&nums[index_l]<=pivot) index_l++;
            nums[index_r] = nums[index_l];
        }
        nums[index_l] = pivot;
        quick(nums, left, index_l-1);
        quick(nums, index_l+1, right);
    }
    //计数
    //堆排
    public static void heapify(int[]nums, int size, int idx){
        int child_l = idx*2+1, child_r = idx*2+2;
        int largest = idx;
        if(child_l<size&&nums[largest]<nums[child_l]) largest = child_l;
        if(child_r<size&&nums[largest]<nums[child_r]) largest = child_r;
        if(idx!=largest){
            int tmp = nums[idx];
            nums[idx] = nums[largest];
            nums[largest] = tmp;
            heapify(nums, size, largest);
        }

    }
    public static void heap(int []nums){
        //create
        for(int i=nums.length-1;i>=0;i--){
            heapify(nums, nums.length, i);
        }
        //sort
        for(int i=nums.length-1;i>0;i--){
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapify(nums, i, 0);
        }
    }

    //归并
    public static int[] merge(int []left, int []right){
        int len_l = left.length, len_r = right.length;
        int []res = new int[len_l+len_r];
        int index_l=0, index_r=0, index=0;
        while (index_l<len_l&&index_r<len_r){
            if(left[index_l]<=right[index_r]) res[index++] = left[index_l++];
            else res[index++] = right[index_r++];
        }
        while (index_l<len_l) res[index++] = left[index_l++];
        while (index_r<len_r) res[index++] = right[index_r++];
        return res;
    }
    public static int[] split(int []nums){
        if(nums.length<=1) return nums;
        int mid = nums.length/2;
        return merge(split(Arrays.copyOfRange(nums, 0, mid)), split(Arrays.copyOfRange(nums, mid, nums.length)));
    }



    public static int[] getNext(String s){
        int []next = new int[s.length()];
        int i=0;
        next[i] = 0;
        for(int j=1;j<next.length;j++){
            while (i>0&&s.charAt(j)!=s.charAt(i)) i = next[i-1];
            if(s.charAt(j)==s.charAt(i)) i++;
            next[j] = i;
        }
        return next;
    }


    public static void main(String[] args) {
//        String example = "aabaaf";
//        for(int i:getNext(example)) System.out.print(i+" ");
        int []nums = {10,2,5,7,4,3,2,1};
//        quick(nums, 0, nums.length-1);
        heap(nums);
        for(int i:nums) System.out.print(i+" ");
    }
}
