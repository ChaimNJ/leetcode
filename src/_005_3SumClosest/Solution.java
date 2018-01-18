package _005_3SumClosest;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 999999999;int closet = 999999;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;
                int tmp;
                int cnt = 1;
                int sum;
                while (start < end) {
                    sum = nums[i] + nums[start] + nums[end];
                    tmp = Math.abs(target - sum);
                    if(tmp<min){
                        min = tmp;
                        closet = sum;
                    }
                    if(target-sum>0){
                        start++;
                    }else{
                        end--;
                    }
                    cnt++;
                }
            }
        }
        return closet;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,2,1,-3,1}, 1));
    }
}
