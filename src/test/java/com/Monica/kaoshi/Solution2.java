package com.Monica.kaoshi;

public class Solution2 {

    public int getCount (int m) {
        // write code here
        int a = 1;
        int b = 1;
        int c = 1;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            //偶数台阶 1或者3
            if (i % 2 == 0){
                sum = a + b + c;
            }else {
                //1或2
                sum = a + b;
            }
        }
        return a;
    }
}
