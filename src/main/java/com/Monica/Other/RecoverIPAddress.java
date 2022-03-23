package com.Monica.Other;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class RecoverIPAddress {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> result = new ArrayList<>();
        Deque<String> store = new ArrayDeque<>();
        if (len < 4 || len > 12){
            return result;
        }
        helper(s,0,result,store);
        return result;
    }

    /**
     * 回溯
     */
    public void helper(String s,int start,List<String> result,Deque<String> store){
        //满足这个条件说明已经回溯完成，把满足条件的4个值已经存到store里面，现在只需要取出来放入返回值里面
        if (start == s.length() && store.size() == 4){
            result.add(String.join(".",store));
            return;
        }
        //不满足最终的长度为s的长度，回溯
        if (start < s.length() && store.size() == 4) return;
        //找end的位置
        for (int i = 1; i <= 3; i++) {
            //不能越界
            if (start + i - 1 >= s.length()) return;
            //首位不能为0
            if (i != 1 && s.charAt(start) == '0') return;
            //截取
            String substring = s.substring(start, start + i);
            //不满足大于了255
            if (i == 3 && Integer.parseInt(substring) > 255) return;
            //加入store
            store.addLast(substring);
            //递归
            helper(s,start + i,result,store);
            store.removeLast();
        }
    }

    public static void main(String[] args) {
        RecoverIPAddress address = new RecoverIPAddress();
        List<String> list = address.restoreIpAddresses("25525511135");
        System.out.println(JSON.toJSONString(list));
    }

}


class Solution {
    List<String> res = new LinkedList<>();
    LinkedList<String> segment = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s, 0);
        return res;
    }

    void helper(String s, int start){
        if(start == s.length() && segment.size() == 4){
            StringBuilder t = new StringBuilder();
            for (String se: segment) t.append(se).append(".");
            t.deleteCharAt(t.length() - 1);
            res.add(t.toString());
            return;
        }
        if(start < s.length() && segment.size() == 4)return;
        for(int i = 1;i <= 3; i++){
            if(start + i - 1 >= s.length())return;
            if(i != 1 && s.charAt(start) == '0')return;
            String str = s.substring(start, start + i);
            if(i == 3 && Integer.parseInt(str) > 255)return;
            segment.addLast(str);
            helper(s, start + i);
            segment.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.restoreIpAddresses("25525511135");
        System.out.println(JSON.toJSONString(list));
    }
}
