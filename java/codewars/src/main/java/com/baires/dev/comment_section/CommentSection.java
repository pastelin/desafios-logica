package com.baires.dev.comment_section;

import java.util.HashSet;
import java.util.Set;

public class CommentSection {

    public static int solution(int N, String S, String[] comments) {

        // Convert the target word to lowercase for case-insensitive comparison
        String target = S.toLowerCase();

        // Use a set to store unique comments that contain the target word
        Set<String> matchedComments = new HashSet<>();

        for (String comment : comments) {
            // Convert the comment to lowercase and check if it contains the target word
            if (comment.toLowerCase().contains(target)) {
                matchedComments.add(comment);
            }
        }

        // Return the count of unique comments containing the target word
        return matchedComments.size();
    }

    public static void main(String[] args) {

        String[] comments = {
                "The_video_is_BAD",
                "bad_bad_bad"
        };

        int count = solution(4, "bad", comments);
        System.out.println("Count of comments containing the word 'bad': " + count);
    }
}
