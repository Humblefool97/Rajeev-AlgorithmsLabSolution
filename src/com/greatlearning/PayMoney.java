package com.greatlearning;

import java.util.Scanner;

public class PayMoney {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = scanner.nextInt();
        int[] transactions = new int[size];
        int[] runningSumArray = new int[size];
        int runningSum = 0;

        for (int i = 0; i < size; i++) {

            transactions[i] = scanner.nextInt();
            runningSum += transactions[i];
            runningSumArray[i] = runningSum;
        }

        int totalNumOfTargets = scanner.nextInt();
        for (int i = 1; i <= 2; i++) {
            int target = scanner.nextInt();
            if (totalNumOfTargets > size)
                throw new IllegalArgumentException("Total num of targets cannot be > size");

            int day = getTargetAchievedDay(runningSumArray,target);
            if(day == -1)
                System.out.println("Target not achieved");
            else
                System.out.println("Target achieved at "+(day+1)+" day");
        }
    }

    /**
     * Binary search to find target
     * @param runningSumArray
     * @param target
     * @return
     */
    private static int getTargetAchievedDay(
            int[] runningSumArray,
            int target) {
        int start = 0;
        int end = runningSumArray.length - 1;
        int day = -1;

        while (end >= start) {
            int mid = (start + end) / 2;

            if (runningSumArray[mid] >= target) {
                day = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return day;
    }
}
