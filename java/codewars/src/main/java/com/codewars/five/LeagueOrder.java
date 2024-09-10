package com.codewars.five;

public class LeagueOrder {

    public static int[] computeRanks(int number, int[][] games) {
        int[][] points = new int[number][6];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = i;
        }

        for (int[] game : games) {
            int team1 = game[0], team2 = game[1], goals1 = game[2], goals2 = game[3];
            updatePoints(points, team1, goals1, goals2, goals1 > goals2 ? 2 : goals1 == goals2 ? 1 : 0);
            updatePoints(points, team2, goals2, goals1, goals2 > goals1 ? 2 : goals2 == goals1 ? 1 : 0);
        }

        java.util.Arrays.sort(points, (a, b) -> b[4] != a[4] ? b[4] - a[4] : b[3] != a[3] ? b[3] - a[3] : b[1] - a[1]);

        int rank = 1, prevRank = 1, prevSum = points[0][4] + points[0][3], prevGoals = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (i > 0 && prevSum == points[i][4] + points[i][3] && prevGoals == points[i][1]) {
                points[i][5] = prevRank;
            } else {
                prevRank = rank;
                points[i][5] = rank;
            }
            prevSum = points[i][4] + points[i][3];
            prevGoals = points[i][1];
            rank++;
        }

        int[] teams = new int[points.length];
        for (int[] point : points) {
            teams[point[0]] = point[5];
        }

        return teams;
    }

    private static void updatePoints(int[][] points, int team, int goalsFor, int goalsAgainst, int pointsForMatch) {
        points[team][0] = team;
        points[team][1] += goalsFor;
        points[team][2] += goalsAgainst;
        points[team][3] += goalsFor - goalsAgainst;
        points[team][4] += pointsForMatch;
    }

    public static void main(String[] args) {
        int [] result = computeRanks(8, new int[][]{{0, 7, 2, 0}});
        for (int i : result) {
            System.out.println(i);
        }
    }
}