package com.hr;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        return compare(arr, 0) > compare(arr, arr.size()-1)? compare(arr, 0) - compare(arr, arr.size()-1):
                (compare(arr, 0) < compare(arr, arr.size()-1)? compare(arr, arr.size()-1) - compare(arr, 0): 0);
    }


    static int compare (List<List<Integer>> arr, int j) {
        int a = 0;
        if (j==0) {
            for (int i = 0; i < arr.size(); i++) {
                a += arr.get(i).get(i);
            }
            return a;
        } else {
            for (int i = 0; i < arr.size(); i++) {
                a += arr.get(j).get(i);
                j--;
            }
            return a;
        }
    }
//    public static int diagonalDifference(List<List<Integer>> arr) {
//        // Write your code here
//        int a = compare(arr, 0);
//        Collections.reverse(arr);
//        return a - compare(arr, 0);
//    }
//
//    static int compare(List<List<Integer>>  arr, int i) {
//        int a = 0;
//        if (i<arr.size()-1) {
//            a = compare(arr, i++);
//        }
//        return a + arr.get(i).get(i);
//    } TODO StackOverflow
}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
