package com.example.advanceddome.utils;

import android.util.Log;

public class StringUtils {
    static String TAG = "StringUtils";

    public static boolean isInclude(String s1, String s2) {
        if (s1.contains("椅子")) {
            s1 = s1.replace("椅子", "座椅");
        }
        if (s1.contains("发动机")) {
            s1 = s1.replace("发动机", "引擎");
        }
        if (s1.contains("引擎盖")) {
            s1 = s1.replace("引擎盖", "前盖");
        }
        Log.d(TAG, s1 + "," + s2);
        for (int i = 0; i < s2.length(); i++) {
            if (!s1.contains(s2.charAt(i)+"")){
                return  false;
            }else if (i==s2.length()-1){
                return true;
            }
        }
        return false;
    }
}
