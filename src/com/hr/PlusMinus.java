package com.hr;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        AtomicInteger countP= new AtomicInteger();
        AtomicInteger countN= new AtomicInteger();
        AtomicInteger countZ= new AtomicInteger();
        list.forEach(n -> {
            if (n == 0) {
                countZ.getAndIncrement();
            } else if (n > 0) {
                countP.getAndIncrement();
            } else {
                countN.getAndIncrement();
            }

        });
        System.out.printf("%.6f\n", countP.floatValue()/arr.length);
        System.out.printf("%.6f\n", countN.floatValue()/arr.length);
        System.out.printf("%.6f", countZ.floatValue()/arr.length);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}