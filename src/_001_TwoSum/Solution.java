package _001_TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 二重循环 T(n)=0(n^2)
 *          S(n)=O(1)
 */
public class Solution {
    public static int[] TwoSum(int[] nums, int target){
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return  new int[]{i,j};
                }
            }
        }
        throw  new IllegalArgumentException("No Solution");
    }

    /**
     *空间换时间，走两遍数组 O(n) O(n)
     */
    public static int[] TwoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a) && map.get(a) != i) {
                return new int[]{i, map.get(a)};
            }
        }
        throw new IllegalArgumentException("No Solution");
    }

    /**
     * 遍历一遍数组，边填数，边找。通过前一个数找后一个数，没找到则放入map，到后一个数时便找到
     * O(n) O(n)
     */
    public static int[] TwoSumV3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if(map.containsKey(a)){
                return new int[]{map.get(a), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Solution");
    }
    public static void main(String[] args) {
        System.out.println(TwoSumV3(new int[]{2,7,11,15}, 9)[0]);
        System.out.println(TwoSumV3(new int[]{2,7,11,15}, 9)[1]);
    }

}



