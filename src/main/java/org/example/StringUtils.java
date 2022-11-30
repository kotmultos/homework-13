package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StringUtils {
    public static String getShortestWord(@NotNull List<String> words ) {
        int shortestIndex = -1;
        if(!words.isEmpty()) {
            shortestIndex = 0;
            for (int i = 1; i < words.size(); i++) {
                if (words.get(i).length() < words.get(shortestIndex).length()) {
                    shortestIndex = i;
                }
            }
        }

        return shortestIndex == -1 ? null : words.get(shortestIndex);
    }
}