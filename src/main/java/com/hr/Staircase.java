package com.hr;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import org.apache.commons.lang3.StringUtils;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {

        for (int i = n-1; i>=0; i--) {
            String a = StringUtils.repeat(" ", i);
            if (a.length()<n) {
                a += StringUtils.repeat("#", n-i);
            }
            System.out.println(a);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}