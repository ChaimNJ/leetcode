package _012_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.

 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:

 [
 [7],
 [2, 2, 3]
 ]

 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList(),candidates,target,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmp,int[] candidates, int remain, int start) {
        if(remain<0) return;
        else if(remain==0){
//            if(!list.contains(tmp))
                list.add(new ArrayList<>(tmp));
        }else{
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                backtrack(list,tmp,candidates,remain-candidates[i],i);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5},8));
    }

}
