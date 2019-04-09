package com.cc.introduction;

import java.util.ArrayList;

public class Prime {

    public static ArrayList<Integer> sieve(int n) {
        int[] numbers = new int[n-1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            numbers[i-2] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (numbers[i-2] != 0) {
                int j = i * i;
                while (j <= n) {
                    numbers[j-2] = 0;
                    j += i;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                primes.add(numbers[i]);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        System.out.println(Prime.sieve(25));
    }

}
