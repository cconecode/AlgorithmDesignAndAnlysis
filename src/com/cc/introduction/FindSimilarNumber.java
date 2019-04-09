package com.cc.introduction;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FindSimilarNumber {

    public static ArrayList<Integer> findSimilarNumber(int[] m, int[] n) {

        ArrayList<Integer> numbers = new ArrayList<>();

        if (m.length < n.length) {
            List<Integer> largeNumbers = Arrays.stream(n).boxed().collect(Collectors.toList());
            numbers.addAll(compareAndFinadNumbers(m, largeNumbers));
        }else {
            List<Integer> largeNumbers = Arrays.stream(m).boxed().collect(Collectors.toList());
            numbers.addAll(compareAndFinadNumbers(n, largeNumbers));
        }
        return numbers;
    }

    private static ArrayList<Integer> compareAndFinadNumbers(int[] smallNumber, List<Integer> largeNumbers) {
        ArrayList<Integer> compareResults = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < smallNumber.length; i++) {
            int number = smallNumber[i];
            int index = binarySearch(number, largeNumbers, startIndex, largeNumbers.size());
            if (index != -1) {
                compareResults.add(largeNumbers.get(index));
                largeNumbers.remove(index);
            }
        }
        return compareResults;
    }

    private static int binarySearch(int target, List<Integer> numbers, int low, int high) {

        while (low <= high) {
            int medium = (low + high) / 2;
            if (target < numbers.get(medium)) {
                high = medium - 1;
            }else if (target > numbers.get(medium)) {
                low = medium + 1;
            }else  {
                return medium;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] m = new int[]{2, 5, 5, 5};
        int[] n = new int[]{2, 3, 5, 5, 7};
        System.out.println(findSimilarNumber(m, n));
    }
}
