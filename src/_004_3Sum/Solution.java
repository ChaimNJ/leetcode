package _004_3Sum;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class Solution {
    /**
     * Time Limit Exceeded
     * @param nums 0(n^3)
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0;i< nums.length;i++){
            for(int j = i+1;j< nums.length;j++){
                for(int k = j+1;k< nums.length;k++){
                    if((nums[i]+nums[j]+nums[k])==0){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.sort((o1, o2) -> o1-o2);
                        if(!list.contains(tmp)) {
                            list.add(tmp);
                        }
                    }
                }
            }
        }
        return list;

    }


    /**
     * TimeLimitExceed
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
        if(nums.length<3){
            return  list;
        }
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if(map.containsKey(nums[i])){
            map.replace(nums[i],map.get(nums[i])+1);
        }else{
            map.put(nums[i],1);
        }
    }
    for (int i = 0; i < nums.length;i++) {
        for (int j = i + 1; j < nums.length; j++) {
            int tmp = 0 - nums[i] - nums[j];
            if (map.containsKey(tmp)) {
                if ((tmp != nums[i] && tmp != nums[j])||map.get(tmp)>1) {
                    List<Integer> tmplist = new ArrayList<>();
                    tmplist.add(nums[i]);
                    tmplist.add(nums[j]);
                    tmplist.add(tmp);
                    if (!list.contains(tmplist)) {
                        list.add(tmplist);
                    }
                } else {
                    continue;
                }
            }
        }
    }
    return list;
}

    /**
     * 先对数组排序
     * 对每个元素进行剩下的元素中，每两个元素的求和
     * 若元素重复则跳过
     * 在两个元素求和过程中，若小于所要的值，则前面指针后移；反之，后面指针前移。
     * 相等，判断下一个值和当前值是否相等，相等则跳过；不相等，则前后指针同时移动一位，
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;
                int sum = 0 - nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        list.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < sum) {
                        start++;
                    } else {
                        end--;
                    }
                }
        }
    }
    return list;
}

    public static void main(String[] args) {
        System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4,0,0}));
    }
}
