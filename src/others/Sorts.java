package others;

import java.util.Arrays;

/**
 * @author 小宇
 * @date {2023}-{08}-{05}:{10:51}
 * @preference: 类：大驼峰 方法：蛇形 变量：全小写
 * @description: 手撕十大排序
 */
public class Sorts {
    //冒泡排序
    public static void bubble(int []nums){
        for(int i= nums.length-1;i>=1;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    //选择排序
    public static void select(int []nums){
        for(int i=0;i<nums.length-1;i++){
            int minindex = i;
            for(int j=i+1;j< nums.length;j++){
                if(nums[minindex]>nums[j]){
                    minindex = j;
                }
            }
            int tmp = nums[minindex];
            nums[minindex] = nums[i];
            nums[i] = tmp;
        }
    }

    //插入排序: 冒泡+选择
    public static void inject(int[]nums){
        for (int i=1;i< nums.length;i++){
            int val = nums[i];
            int j = i-1;
            while (j>=0&&nums[j]>val){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = val;
        }
    }

    //shell排序:升级版插入排序
    public static void shell(int []nums){
        int len = nums.length;
        for(int gap=len/2;gap>0;gap/=2){
            for (int i=gap;i<len;i++){
                int val = nums[i];
                int j = i-gap;
                while (j>=0&&nums[j]>val){
                    nums[j+gap] = nums[j];
                    j-=gap;
                }
                nums[j+gap] = val;
            }
        }
    }

    //归并排序
    public static int[] mergesort(int []left, int []right){
        int len_l = left.length, len_r = right.length;
        int index_l = 0, index_r = 0;
        int index = 0;
        int[] res = new int[len_l+len_r];
        while (index_l<len_l&&index_r<len_r){
            if(left[index_l]<=right[index_r]){
                res[index++] = left[index_l++];
            }else {
                res[index++] = right[index_r++];
            }
        }
        while (index_l<len_l) res[index++] = left[index_l++];
        while (index_r<len_r) res[index++] = right[index_r++];
        return res;
    }
    public static int[] merge(int []nums){
        int len = nums.length;
        if(len<=1) return nums;
        int mid = len/2;
        return mergesort(merge(Arrays.copyOfRange(nums, 0, mid)), merge(Arrays.copyOfRange(nums, mid, len)));
    }


    //快速排序
    public static void quick(int []nums, int left, int right){
        int pivot = nums[left];
        int index_l = left, index_r = right;
        if(index_l>=index_r) return;
        while (index_l<index_r){
            while (index_l<index_r&&nums[index_r]>=pivot)index_r--;
            nums[index_l] = nums[index_r];
            while (index_l<index_r&&nums[index_l]<=pivot)index_l++;
            nums[index_r] = nums[index_l];
        }
        nums[index_l] = pivot;
        quick(nums, left, index_l-1);
        quick(nums, index_l+1, right);
    }

    //堆排序：完全二叉树 升序使用大顶堆
    public static void heapify(int []nums, int index, int n){
        int child_l = index*2+1;
        int child_r = index*2+2;
        int largest = index;
        if(child_r<n && nums[child_r]>nums[largest]) largest = child_r;
        if(child_l<n && nums[child_l]>nums[largest]) largest = child_l;
        if(largest!=index){
            int tmp = nums[index];
            nums[index] = nums[largest];
            nums[largest] = tmp;
            heapify(nums, largest, n);
        }
    }
    public static void heap(int []nums){
        //create heap
        for(int i=nums.length/2-1;i>=0;i--){
            heapify(nums, i, nums.length);
        }
//        //sort
        int lastIndex = nums.length-1;
        for(int i=lastIndex;i>0;i--){
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapify(nums, 0, i);
        }
    }

// 计数排序：count
    public static int[] count(int []nums){
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max = nums[i];
        }
        int []list = new int[max+1];
        for(int i=0;i<nums.length;i++){
            list[nums[i]]++;
        }
        int []res = new int[nums.length];int index = 0;
        for(int i=0;i< list.length;i++){
            while (list[i]>0){
                res[index++] = i;
                list[i]--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int []nums = {8,6,3,2,5,7,6,1,10};
//        shell(nums);
//        quick(nums, 0, nums.length-1);
        for (int i:count(nums)) System.out.print(i+" ");
    }
}
