package _013_FirstMissPostive;

import java.lang.reflect.Field;

/**
 *  Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i]<=nums.length && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i] ;
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return 1;
    }

    private static void swap(Integer a, Integer b){
        if(a==null || b==null){
            return ;
        }
        Class integetrClass = a.getClass();
        try {
            Field field = integetrClass.getDeclaredField("value");
            field.setAccessible(true);
            int tmp = a;
            field.setInt(a,b);
            field.setInt(b,tmp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
