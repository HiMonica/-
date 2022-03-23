package com.Monica.kaoshi;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 子序列
 */
public class xulie {

    public static List<List<Integer>> answer(int n,int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> store = new ArrayDeque<>();
        if (n == 0){
            return result;
        }
        answer(n,0,nums,1,store,result);
        return result;
    }

    public static void answer(int len, int cur, int[] nums, int sum, Deque<Integer> store, List<List<Integer>> result){
        if (cur == len){
            if (store.size() == 0){
                return;
            }
            for (Integer integer : store) {
                sum = sum * integer;
            }
            if (sum == 1){
                result.add(new ArrayList<>(store));
            }
            return;
        }
        store.push(nums[cur]);
        answer(len,cur + 1,nums,sum,store,result);
        store.removeFirst();
        answer(len,cur + 1,nums,sum,store,result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        List<List<Integer>> answer = test(n, nums);
        System.out.println(JSON.toJSONString(answer));
        System.out.println(answer.size());
    }

    public static List<List<Integer>> test(int n,int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> store = new ArrayList<>();
        if (n == 0){
            return result;
        }
        int sum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                store.add(nums[j]);
                sum = sum * nums[j];
                if (sum == 1){
                    result.add(new ArrayList<>(store));
                }
            }
        }
        return result;
    }
}
