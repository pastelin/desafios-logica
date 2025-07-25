package com.codewars.six;

import org.junit.jupiter.api.Test; // Imports the JUnit 5 Test annotation

import java.util.Arrays; // Utility for array manipulation
import java.util.List;   // Interface for collections
import java.util.regex.Matcher; // For finding patterns in text
import java.util.regex.Pattern; // For compiling regular expressions

import static org.junit.jupiter.api.Assertions.assertEquals; // Imports the static assertEquals method for assertions

public class Catalog {

    /**
     * Searches for products in a given text catalog that contain a specific article and formats their information.
     *
     * @param s The text string representing the complete catalog.
     * Each product entry is expected to be separated by two newlines ("\n\n").
     * Example: "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>\n\n<prod>..."
     * @param article       The name of the article (or part of it) to search for within the product names.
     * @return A string with the formatted information of the found products,
     * separated by newlines. Returns an empty string if no products are found or if inputs are invalid.
     * Output format for each product: "Product Name > prx: $Price qty: Quantity"
     */
    public static String catalog(String s, String article) {
        // 1. Split the entire catalog string into individual product entries.
        //    Products are separated by two newline characters.
        String[] individualProducts = s.split("\n\n");

        // 2. Process the array of products using Java Streams for a more functional and concise approach.
        List<String> foundProductsFormatted = Arrays.stream(individualProducts)
                // 3. Filter the products: only include those whose full XML string contains the 'article' keyword.
                //    This ensures only relevant products are processed further.
                .filter(productXml -> productXml.contains(article))
                // 4. Map each filtered product's XML string to its desired output format.
                //    Here, we extract the name, price, and quantity for each product.
                .map(productXml -> {
                    // Use a helper method to safely and clearly extract values using pre-compiled regex patterns.
                    // This makes the code more robust against missing tags by returning empty strings.
                    String name = extractValue(productXml, Pattern.compile("<name>(.*?)</name>"));
                    String price = extractValue(productXml, Pattern.compile("<prx>(.*?)</prx>"));
                    String quantity = extractValue(productXml, Pattern.compile("<qty>(.*?)</qty>"));

                    // Format the output string using String.format for better readability and structure.
                    return String.format("%s > prx: $%s qty: %s", name, price, quantity);
                })
                // 5. Collect the results into a List.
                //    '.toList()' is available from Java 16+. For older versions, use '.collect(Collectors.toList())'.
                .toList();

        // 6. Join the formatted product strings with newline characters.
        //    If the list is empty (no products found), return an empty string.
        return foundProductsFormatted.isEmpty() ? "Nothing" : String.join("\n", foundProductsFormatted);
    }

    /**
     * Helper method to extract a specific value from a given text using a regular expression pattern.
     *
     * @param text    The input string (e.g., a product's XML snippet).
     * @param pattern The pre-compiled regular expression pattern to use for finding the value.
     * The pattern should typically have a capturing group to extract the desired content.
     * @return The captured value from the first match, or an empty string if the pattern is not found.
     */
    private static String extractValue(String text, Pattern pattern) {
        // Create a Matcher object to find occurrences of the pattern in the given text.
        Matcher matcher = pattern.matcher(text);
        // If the pattern is found, return the content of the first capturing group.
        // The capturing group (defined by parentheses in the regex, e.g., (.*?) ) holds the actual value.
        if (matcher.find()) {
            return matcher.group(1);
        }
        // If the pattern is not found in the text, return an empty string to indicate absence
        // and prevent NullPointerExceptions in subsequent operations.
        return "";
    }


    // --- Test Code (Minor improvements for clarity and robustness in testing) ---

    // The 's' string holds the complete product catalog for testing purposes.
    // It's good practice to keep test data separate from core logic.
    String s =
            """
                    <prod><name>drill</name><prx>99</prx><qty>5</qty></prod>
                    
                    <prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>
                    
                    <prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>
                    
                    <prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>
                    
                    <prod><name>saw</name><prx>9</prx><qty>10</qty></prod>
                    
                    <prod><name>chair</name><prx>100</prx><qty>20</qty></prod>
                    
                    <prod><name>fan</name><prx>50</prx><qty>8</qty></prod>
                    
                    <prod><name>wire</name><prx>10.8</prx><qty>15</qty></prod>
                    
                    <prod><name>battery</name><prx>150</prx><qty>12</qty></prod>
                    
                    <prod><name>pallet</name><prx>10</prx><qty>50</qty></prod>
                    
                    <prod><name>wheel</name><prx>8.80</prx><qty>32</qty></prod>
                    
                    <prod><name>extractor</name><prx>105</prx><qty>17</qty></prod>
                    
                    <prod><name>bumper</name><prx>150</prx><qty>3</qty></prod>
                    
                    <prod><name>ladder</name><prx>112</prx><qty>12</qty></prod>
                    
                    <prod><name>hoist</name><prx>13.80</prx><qty>32</qty></prod>
                    
                    <prod><name>platform</name><prx>65</prx><qty>21</qty></prod>
                    
                    <prod><name>car wheel</name><prx>505</prx><qty>7</qty></prod>
                    
                    <prod><name>bicycle wheel</name><prx>150</prx><qty>11</qty></prod>
                    
                    <prod><name>big hammer</name><prx>18</prx><qty>12</qty></prod>
                    
                    <prod><name>saw for metal</name><prx>13.80</prx><qty>32</qty></prod>
                    
                    <prod><name>wood pallet</name><prx>65</prx><qty>21</qty></prod>
                    
                    <prod><name>circular fan</name><prx>80</prx><qty>8</qty></prod>
                    
                    <prod><name>exhaust fan</name><prx>62</prx><qty>8</qty></prod>
                    
                    <prod><name>cattle prod</name><prx>990</prx><qty>2</qty></prod>
                    
                    <prod><name>window fan</name><prx>62</prx><qty>8</qty></prod>""";

    /**
     * Helper method to run a single test case and print the results to the console.
     * @param catalogStr The complete catalog string.
     * @param article The article to search for.
     * @param expected The expected output string.
     */
    private static void testing(String catalogStr, String article, String expected) {
        System.out.println("------------------------------------");
        System.out.println("Testing with article: \"" + article + "\"");
        String actual = Catalog.catalog(catalogStr, article);
        System.out.println("Actual Result:\n\"" + actual + "\"");
        System.out.println("Expected Result:\n\"" + expected + "\"");
        // JUnit assertion to verify if the actual result matches the expected one.
        // A custom message is provided for clearer test failure reports.
        assertEquals(expected, actual, "Result mismatch for article: " + article);
        System.out.println("Test PASSED.");
    }

    /**
     * JUnit 5 test method to verify the functionality of the catalog method.
     * Contains various test cases for different scenarios.
     */
    @Test
    public void testCatalogFunctionality() {
        // Test Case 1: Search for a single, exact article match.
        testing(s, "ladder", "ladder > prx: $112 qty: 12");

        // Test Case 2: Search for an article that appears in multiple products, including compound names.
        testing(s, "saw", "table saw > prx: $1099.99 qty: 5\nsaw > prx: $9 qty: 10\nsaw for metal > prx: $13.80 qty: 32");

        // Test Case 3: Search for a compound article name.
        testing(s, "wood pallet", "wood pallet > prx: $65 qty: 21");

    }

    /**
     * Main method to manually run the test cases.
     * This allows execution from the command line or IDE without needing a JUnit runner.
     */
    public static void main(String[] args) {
        Catalog catalogTester = new Catalog(); // Instantiate the Catalog class to call its test methods.
        catalogTester.testCatalogFunctionality(); // Call the method containing the JUnit tests.
    }
}