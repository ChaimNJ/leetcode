package _011_searchForRange;

import java.util.Arrays;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int [] r =new int[]{-1,-1};
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid]==target&&mid==0 || nums[mid]==target&&nums[mid-1]<target){
                r[0]=mid;
                break;
            } else if (nums[mid]<target){
                low = mid+1;
            }else {
               high = mid -1;
            }
        }
        low = 0;
        high =nums.length -1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[mid]==target&&mid==nums.length-1 || nums[mid]==target&&nums[mid+1]>target){
                r[1]=mid;
                break;
             }else if (nums[mid]>target){
                high = mid -1;
            }else {
                low = mid+1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1},1)));
    }
}
