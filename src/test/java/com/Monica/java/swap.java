package com.Monica.java;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class swap {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.swap(list,1,2);
        System.out.println(JSON.toJSONString(list));
    }
}
