package com.cc.introduction;

import java.util.ArrayList;

public class GCD {

    public static int euclid(int m, int n) {
        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(GCD.euclid(31415, 14142));
    }
}
