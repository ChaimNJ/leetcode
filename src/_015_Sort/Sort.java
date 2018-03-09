package _015_Sort;

import com.sun.scenario.effect.Merge;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,1,3,6,2};
//        BubbleSort(nums);
//        SelectionSort(nums);
//        InsertionSort(nums);
//        ShellSort(nums);
//        MergeSort(nums,new int[nums.length],0,nums.length-1);
       QuickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+ " ");
        }
    }
    public static  void BubbleSort(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length && flag == true; i++) {
            flag = false;
            for (int j = 0; j < nums.length - i - 1 ; j++) {
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = true;
                }
            }
        }
    }

    public static void SelectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length ; j++) {
                if(nums[min] > nums[j]){
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    public static void InsertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int pre = i-1;
            int current = nums[i];
            while(pre>=0&&nums[pre]>current){
                nums[pre+1] = nums[pre];
                pre--;
            }
            nums[pre+1] = current;
        }
    }

    public static void ShellSort(int[] nums){
        for (int gap = nums.length/2; gap >=1 ; gap=gap/2) {
            for (int i = gap; i < nums.length; i+=gap) {
                int pre = i-gap;
                int current = nums[i];
                while(pre>=0&&nums[pre]>current){
                    nums[pre+gap] = nums[pre];
                    pre-=gap;
                }
                nums[pre+gap] = current;
            }
        }
    }

    public static void MergeSort(int[] nums,int[] tmp,int start,int end){
        if((end-start)<2){
            return;
        }
        int mid =(end+start)/2;
        MergeSort(nums,tmp,start,mid);
        MergeSort(nums,tmp,mid+1,end);
        Merge(nums,tmp,start,mid,end);
    }
    public static  void Merge(int[] nums,int[] tmp,int start,int mid,int end){
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=end){
            if(nums[i]<nums[j]){
                tmp[k++]=nums[i++];
            }else{
                tmp[k++]=nums[j++];
            }
        }
        while(i<=mid){
            tmp[k++]=nums[i++];
        }
        while(j<=end){
            tmp[k++]=nums[j++];
        }
        for (int l = 0,p = start; p <= end; l++,p++) {
            nums[p]=tmp[l];
        }
    }

    public static void QuickSort(int[] nums,int start,int end){
        if(start<end){
            int pivot = partition(nums,start,end);
            QuickSort(nums,start,pivot-1);
            QuickSort(nums,pivot+1,end);
        }
    }
    public static int partition(int[] nums,int start,int end){
        int pivot = nums[start];
        while (start<end){
            while(start<end && nums[end]>=pivot) end--;
            nums[start]=nums[end];
            while (start < end && nums[start]<=pivot) start++;
            nums[end]=nums[start];
            }
            nums[start] = pivot;
        return start;
        }




    

}
