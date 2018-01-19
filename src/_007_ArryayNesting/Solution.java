package _007_ArryayNesting;

import java.util.*;

/**
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

 Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

 Example 1:

 Input: A = [5,4,0,3,1,6,2]
 Output: 6
 Explanation:
 A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

 One of the longest S[K]:
 S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

 Note:

 N is an integer within the range [1, 20,000].
 The elements of A are all distinct.
 Each element of A is an integer within the range [0, N-1]
 */
public class Solution {
    /**
     * Time Limit Exceeded
     * @param nums
     * @return
     */
    public static int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            int cnt = i;
            int length = 1;
            while (cnt < nums.length && nums[cnt]!=start){
                    length++;
                    cnt=nums[cnt];
            }
            if(length>max){
                max = length;
            }
        }
        return max;
    }

    /**
     * O(n)时间复杂度
     *思路:从头开始走，设置头标志start，，i=start,以nums[i]为索引找下一个元素，赋值给i，直到找到i和start相等。
     * 找的过程中，将此集合中的元素放入set。一组完毕后比较最大长度。
     * 长度归零，找下一个start位置，set中包含的都跳过，start++
     * @param nums
     * @return
     */
    public static int arrayNesting1(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        int cnt=0;
        int i=0;
        int start = 0;
        int length = 0;
        while(cnt<=nums.length){
            if(start!=i||length==0){
                set.add(i);
                i = nums[i];
                cnt++;
                length++;
            }else{
                max = Math.max(max,length);
                length=0;
                if(cnt==nums.length){
                    break;
                }
                while(set.contains(start)) {
                    start++;
                }
                i=start;
            }
        }
        return max;
    }

    /**
     * 去掉Set后
     * 改进版
     * @param nums
     * @return
     */
    public static int arrayNesting2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int start = i;
                int length = 0;
                while (nums[start] != -1) {
                    length++;
                    int k = nums[start];
                    nums[i] = -1;
                    start = k;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting2(new int[]{0,2,1}));
    }
}
