package com.codewars.six;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortIinnerContent {

    public static String sortTheInnerContent(String words) {
        String[] splitWords = words.split(" ");

        return Arrays.stream(splitWords)
                .map(word -> {
                    if (word.length() <= 2) {
                        return word;
                    }

                    String sortedInner = word.substring(1, word.length() - 1)
                            .chars()
                            .boxed()
                            .sorted((a, b) -> b.compareTo(a))
                            .map(c -> String.valueOf((char) c.intValue()))
                            .collect(Collectors.joining());

                    return word.charAt(0) + sortedInner + word.charAt(word.length() - 1);
                })
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(sortTheInnerContent("sort the inner content in descending order"));
        System.out.println(sortTheInnerContent("wait for me"));
        System.out.println(sortTheInnerContent("this kata is easy"));
    }
}
