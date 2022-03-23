package com.Monica.kaoshi;

import java.util.ArrayList;

public class ExpectOfNum {

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 计算用户逾期扣分数
     * @param dpdInfo string字符串  用户逾期记录，'N': 没有逾期，正常  'Y'：有逾期
     * @return int整型
     */
    public int calDPDScore(String dpdInfo) {
        // write code here
        int len = dpdInfo.length();
        if (len == 0){
            return 0;
        }
        ArrayList<Integer> store = bestOfExpect(dpdInfo);
        int result = 0;
        int max = 0;
        for (Integer i : store) {
            if (i > max){
                max = i;
            }
        }
        if (max > 0 && max <= 3){
            result -= 10;
        }
        if (max > 3 && max <= 7){
            result -= 15;
        }
        if (max > 7){
            result -= 25;
        }
        return result;
    }

    public ArrayList<Integer> bestOfExpect(String dpdInfo){
        ArrayList<Integer> store = new ArrayList<>();
        int len = dpdInfo.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (dpdInfo.charAt(i) == 'N'){
                store.add(count);
                count = 0;
            }else {
                count++;
            }
        }
        store.add(count);
        return store;
    }

    public static void main(String[] args) {
        ExpectOfNum num = new ExpectOfNum();
        int nnn = num.calDPDScore("NNYYYYYNNYY");
        System.out.println(nnn);
    }
}
