package com.Monica.kaoshi;

public class StringTime {
    public static String noticeTime(String deadline,String time,String[] starts){
        //思路 二分查找
        int d = timeToInt(deadline);
        int t = timeToInt(time);
        return null;
    }

    public static int timeToInt(String time){
        String[] times = time.split("\\:");
        //小时
        String time1 = times[0];
        //分钟
        String time2 = times[1];
        return Integer.parseInt(time1) * 60 + Integer.parseInt(time2);
    }
}
