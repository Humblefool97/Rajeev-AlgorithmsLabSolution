package com.greatlearning;

import java.util.Scanner;

class MinimumTransactionsWithDP {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the size of currency denominations");

        int numOfDenominations = sc.nextInt();
        int [] denominations = new int[numOfDenominations];
        System.out.println("Enter the currency denominations value");

        for (int i = 0; i < numOfDenominations; i++) {
            denominations[i] = sc.nextInt();
        }

        System.out.println("Enter the amount you want to pay:-");
        int target = sc.nextInt();

        MinimumTransactionsWithDP m = new MinimumTransactionsWithDP();
        m.coinChangeModified(denominations, target);
    }

    public void coinChangeModified(int coins[],int targetSum){
        int totalArray[] = new int[targetSum + 1];
        int rowArray[] = new int[targetSum + 1];
        totalArray[0] = 0;
        for(int i=1; i <= targetSum; i++){
            totalArray[i] = Integer.MAX_VALUE-1;
            rowArray[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= targetSum; i++){
                if(i >= coins[j]){
                    if (totalArray[i - coins[j]] + 1 < totalArray[i]) {
                        totalArray[i] = 1 + totalArray[i - coins[j]];
                        rowArray[i] = j;
                    }
                }
            }
        }
        printCoinCombination(rowArray, coins,totalArray[targetSum]);
    }

    private void printCoinCombination(int rowArray[], int coins[],int totalNumberOfCoins) {
        if (rowArray[rowArray.length - 1] == -1) {
            System.out.print("Invalid input! No solution");
            return;
        }
        int index = rowArray.length - 1;
        System.out.println("Minimum number of coins :- "+totalNumberOfCoins);
        System.out.print("Coins used to form total ");
        while ( index != 0 ) {
            int j = rowArray[index];
            System.out.print(coins[j] + " ");
            index = index - coins[j];
        }
    }
}