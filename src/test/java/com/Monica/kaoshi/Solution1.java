package com.Monica.kaoshi;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 根据所有可能的分数集合，返回符合题中条件的所有考试得分的组合。若无任何符合题中要求的得分组合，则返空集合。
     * @param allScoreArray int整型一维数组 可能得分的集合
     * @param examCount int整型 考试总次数
     * @param lastScore int整型 最后一次考试分数
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> process (int[] allScoreArray, int examCount, int lastScore) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (examCount == 0){
            return result;
        }
        Set<Integer> set = new HashSet<>();
        set.add(lastScore);
        process(0,0,allScoreArray,examCount,lastScore,result,list);
        return result;
    }

    public void process(int sum,int count,int[] allScoreArray, int examCount, int lastScore,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list){
        if (count == examCount - 1){
            if (list.size() == examCount){
                for (Integer integer : list) {
                    sum += integer;
                }
                if (isInt(sum,examCount) && list.get(examCount - 1) == lastScore){
                    result.add(new ArrayList<>(list));
                }
            }

            return;
        }
        list.add(allScoreArray[count]);
        process(sum,count + 1,allScoreArray,examCount,lastScore,result,list);
        list.remove(list.size() - 1);
        process(sum,count + 1,allScoreArray,examCount,lastScore,result,list);
    }

    //判断平均数是否为整数
    public boolean isInt(int sum,int examCount){
        if (sum % examCount != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{3,4,5,6,7,8,9,10};
        ArrayList<ArrayList<Integer>> process = solution.process(nums, 6, 6);
        System.out.println(JSON.toJSONString(process));
    }
}
