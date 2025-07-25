package com.baires.dev.food_ratings;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(solution(5, new int[][]{
                {987654423, 4},
                {987654220, 5},
                {987654202, 4},
                {987654250, 1},
                {987654419, 5}
        }));
    }

    static int solutionMe(int N, int[][] ratings) {
        // Write your code here
        int result = 0;
        int id = 0;

        // Get the average rating and return de highest rating with de ID smaller
        for (int i = 0; i < ratings.length; i++) {
            id = ratings[i][0];
            int rating = ratings[i][1];

            for (int j = i + 1; j < ratings.length; j++) {
                if (ratings[j][0] == id) {
                    int average = (rating + ratings[j][1]) / 2;
                    ratings[i][1] = average;
                    ratings[j][1] = 0;
                    ratings[j][0] = 0;
                }
            }
        }

        id = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i][1] > result) {
                result = ratings[i][1];
                id = ratings[i][0];
            } else if (ratings[i][1] == result && ratings[i][0] < id) {
                result = ratings[i][1];
                id = ratings[i][0];
            }
        }


        return id;

    }

    /**
     * Finds the ID with the highest average rating. If there are ties, the smallest ID is returned.
     *
     * @param N       Number of ratings.
     * @param ratings Array of ratings where each entry contains an ID and a rating.
     * @return The ID with the highest average rating.
     */
    static int solution(int N, int[][] ratings) {
        // Map to store the sum of ratings and count for each ID
        Map<Integer, int[]> ratingMap = new HashMap<>();

        // Group ratings by ID and calculate the sum and count
        for (int[] rating : ratings) {
            int id = rating[0];
            int score = rating[1];
            ratingMap.putIfAbsent(id, new int[]{0, 0}); // Initialize if ID is not present
            ratingMap.get(id)[0] += score; // Add score to the sum
            ratingMap.get(id)[1]++;       // Increment count
        }

        // Variables to track the ID with the highest average rating
        int bestId = 0;
        double highestAverage = 0;

        // Calculate the average rating for each ID and find the best ID
        for (Map.Entry<Integer, int[]> entry : ratingMap.entrySet()) {
            int id = entry.getKey();
            int sum = entry.getValue()[0];
            int count = entry.getValue()[1];
            double average = (double) sum / count;

            // Update the best ID based on the highest average and smallest ID in case of ties
            if (average > highestAverage || (average == highestAverage && id < bestId)) {
                highestAverage = average;
                bestId = id;
            }
        }

        return bestId;
    }


}
