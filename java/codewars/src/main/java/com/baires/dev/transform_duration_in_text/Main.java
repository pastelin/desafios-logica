package com.baires.dev.transform_duration_in_text;

public class Main {

    public static void main(String[] args) {
        // Generate a random number of seconds between 0 and 1,000,000
        int seconds = (int) (Math.random() * 1000000);

        // Transform the duration into a readable text format
        String durationText = transformDuration(seconds);

        // Print the result
        System.out.println(durationText);
    }

    /**
     * Transforms a duration in seconds into a human-readable text format.
     *
     * @param seconds The duration in seconds.
     * @return A string representing the duration in days, hours, minutes, and seconds.
     */
    public static String transformDuration(int seconds) {
        // If the duration is zero, return "now"
        if (seconds == 0) {
            return "now";
        }

        // Calculate days, hours, minutes, and remaining seconds
        int days = seconds / 86400; // 86400 seconds in a day
        int hours = (seconds % 86400) / 3600; // 3600 seconds in an hour
        int minutes = (seconds % 3600) / 60; // 60 seconds in a minute
        int remainingSeconds = seconds % 60;

        // Build the result string
        StringBuilder result = new StringBuilder();

        // Append days if present
        if (days > 0) {
            result.append(days).append(" day").append(days > 1 ? "s" : "");
            appendSeparator(result, hours, minutes, remainingSeconds);
        }

        // Append hours if present
        if (hours > 0) {
            result.append(hours).append(" hour").append(hours > 1 ? "s" : "");
            appendSeparator(result, minutes, remainingSeconds, 0);
        }

        // Append minutes if present
        if (minutes > 0) {
            result.append(minutes).append(" minute").append(minutes > 1 ? "s" : "");
            appendSeparator(result, remainingSeconds, 0, 0);
        }

        // Append seconds if present
        if (remainingSeconds > 0) {
            result.append(remainingSeconds).append(" second").append(remainingSeconds > 1 ? "s" : "");
        }

        return result.toString();
    }

    /**
     * Appends a separator (", " or " and ") to the result string based on remaining values.
     *
     * @param result The StringBuilder to append to.
     * @param nextValue The next value to check.
     * @param secondNextValue The second next value to check.
     * @param thirdNextValue The third next value to check.
     */
    private static void appendSeparator(StringBuilder result, int nextValue, int secondNextValue, int thirdNextValue) {
        if (nextValue > 0 || secondNextValue > 0 || thirdNextValue > 0) {
            result.append(nextValue > 0 && secondNextValue == 0 && thirdNextValue == 0 ? " and " : ", ");
        }
    }
}
