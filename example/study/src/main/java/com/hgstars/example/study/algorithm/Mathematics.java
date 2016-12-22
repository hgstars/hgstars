package com.hgstars.example.study.algorithm;

/**
 * Created by yujindong on 16/12/13.
 */
public class Mathematics {

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        int c = a % b;
        return gcd(b, c);
    }

    public static void main(String[] args) {
        System.out.println(gcd(20, 30));
    }
}
