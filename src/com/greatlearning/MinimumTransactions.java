package com.greatlearning;

import java.util.*;

public class MinimumTransactions {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the size of currency denominations");

        int numOfDenominations = sc.nextInt();
        ArrayList<Integer> denominations = new ArrayList<>();
        System.out.println("Enter the currency denominations value");

        for (int i = 0; i < numOfDenominations; i++) {
            denominations.add(sc.nextInt());
        }

        denominations.sort(Collections.reverseOrder());
        System.out.println("Enter the amount you want to pay:-");
        int target = sc.nextInt();

        System.out.println(findDenominations(
                denominations,
                target
        ));
    }

    private static Map findDenominations(List<Integer> denominations,
                                         int target) {

        int index = 0;
        int remainingTarget = target;
        int size = denominations.size();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        while (remainingTarget > 0 && index < size) {
            int count = remainingTarget / denominations.get(index);
            remainingTarget = remainingTarget % denominations.get(index);
            if (count == 0) {
                if(remainingTarget == 0){
                    int updatedCount = map.getOrDefault(denominations.get(index), 0) + 1;
                    map.put(denominations.get(index), updatedCount);
                }
                index++;
                continue;
            }

            int updatedCount = map.getOrDefault(denominations.get(index), 0) + count;
            map.put(denominations.get(index), updatedCount);

        }
        return  remainingTarget == 0 ? map : null;
    }
}
