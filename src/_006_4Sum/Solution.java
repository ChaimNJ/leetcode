package _006_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length-3; i++) {
                if(i==0||nums[i]!=nums[i-1]){
                    for (int j = i+1; j < nums.length-2; j++) {
                        if(j==i+1||nums[j]!=nums[j-1]){
                            int start = j + 1;
                            int end = nums.length - 1;
                            while (start < end) {
                                if (nums[start] + nums[end] + nums[i] + nums[j] == target) {
                                    list.add(Arrays.asList(nums[i],nums[j],nums[start], nums[end]));
                                    while (start < end && nums[start] == nums[start + 1]) {
                                        start++;
                                    }
                                    while (start < end && nums[end] == nums[end - 1]) {
                                        end--;
                                    }
                                    start++;
                                    end--;
                                } else if (nums[start] + nums[end] + nums[i] +nums[j] < target) {
                                    start++;
                                } else {
                                    end--;
                                }
                            }
                        }
                    }
                }
            }
            return  list;
        }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4},-1));
    }
}
