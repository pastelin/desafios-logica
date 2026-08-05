package com.codewars.six;

public class BuyCar {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        // your code

        if (startPriceOld >= startPriceNew) {
            return new int[]{0, startPriceOld - startPriceNew};
        }

        int savings = 0;
        int months = 0;
        double currentPriceOld = startPriceOld;
        double currentPriceNew = startPriceNew;
        double currentPercentLoss = percentLossByMonth;
        double totalBudget = currentPriceOld + savings;
        int monthsSinceIncrease = 0;

        while(totalBudget < currentPriceNew) {
            months++;

            monthsSinceIncrease++;
            if (monthsSinceIncrease == 2) {
                currentPercentLoss += 0.5;
                monthsSinceIncrease = 0;
            }

            currentPriceOld -= currentPriceOld * (currentPercentLoss / 100);
            currentPriceNew -= currentPriceNew * (currentPercentLoss / 100);

            savings += savingperMonth;
            totalBudget = currentPriceOld + savings;
        }

        return new int[]{months, (int) Math.round(currentPriceOld + savings - currentPriceNew)};
    }

    public static void main(String[] args) {
        int[] result = nbMonths(2000, 8000, 1000, 1.5);
        System.out.println("Months: " + result[0] + ", Remaining money: " + result[1]);
    }

}
