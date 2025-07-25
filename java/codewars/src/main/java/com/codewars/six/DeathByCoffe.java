package com.codewars.six;

public class DeathByCoffe {

    /**
     * Calculates the coffee limits based on the given date.
     *
     * @param year  The year as an integer.
     * @param month The month as an integer.
     * @param day   The day as an integer.
     * @return An array with two limits: [coffeeLimit, decafLimit].
     */
    public static int[] coffeeLimits(final int year, final int month, final int day) {

        // Combine year, month, and day into a single integer
        int h = Integer.parseInt(String.format("%04d%02d%02d", year, month, day));
        System.out.println("h = " + h);

        // Convert hexadecimal values to decimal
        int coffeeIncrement = 0xCAFE;
        int decafIncrement = 0xDECAF;

        // Calculate the limits
        int coffeeLimit = findLimit(h, coffeeIncrement);
        int decafLimit = findLimit(h, decafIncrement);

        return new int[]{coffeeLimit, decafLimit};
    }

    /**
     * Finds the limit where the hexadecimal representation of the value contains the target string.
     *
     * @param startValue The initial value.
     * @param increment  The increment to add in each iteration.
     * @return The iteration count where the target is found.
     */
    private static int findLimit(int startValue, int increment) {
        int value = startValue;

        for (int i = 1; i <= 5000; i++) {
            value += increment;
            if (convertDecimalToHex(value).contains("DEAD")) {
                System.out.println(convertDecimalToHex(value));
                return i;
            }
        }

        // Return -1 if the target is not found within the limit
        return 0;
    }

    /**
     * Converts a decimal integer to a hexadecimal string.
     *
     * @param decimal The decimal integer.
     * @return The hexadecimal representation of the decimal value.
     */
    public static String convertDecimalToHex(int decimal) {
        return Long.toHexString(decimal).toUpperCase();
    }

    public static void main(String[] args) {
        // Example usage
        int[] limits = coffeeLimits(1880, 3, 1);
        System.out.println("Coffee limits: " + limits[0] + ", " + limits[1]);
    }


}
