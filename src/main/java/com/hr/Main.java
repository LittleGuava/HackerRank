package com.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int a = compare(arr, 0);
        Collections.reverse(arr);
        return a - compare(arr, 0);
    }

    static int compare(List<List<Integer>>  arr, int i) {
        int a = 0;
        if (i<arr.size()-1) {
            a = compare(arr, i++);
        }
        return a + arr.get(i).get(i);
    }
}
