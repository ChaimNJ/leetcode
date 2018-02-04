package _009_nextPermutation;

import java.util.Arrays;

/**
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.
 */
public class Solution {
    public static void nextPermutation(int[] nums) {
        int j = nums.length - 1;
        int i = j - 1;
        while(i>=0&&nums[i]>=nums[j]){
            j--;
            i--;
        }
        for(int a=nums.length - 1; a>=j&&i>=0;a--){
            if(nums[a]>nums[i]){
                int tmp = nums[a];
                nums[a] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        Arrays.sort(nums,j,nums.length);
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
       nextPermutation(new int[]{5,1,1});

    }
}

