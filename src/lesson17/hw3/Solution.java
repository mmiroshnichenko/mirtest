package lesson17.hw3;

public class Solution {
    public String mostCountedWord(String input) {
        String[] words = getArrayOfWords(input);
        if (words.length == 0) {
            return null;
        }

        if (words.length == 1) {
            return words[0];
        }

        String mostCountedWord = words[0];
        int maxCount = 0;

        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = i + 1; j < words.length; j++) {
                if (!words[i].isEmpty() && words[i].equals(words[j])) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostCountedWord = words[i];
            }
        }

        return maxCount > 0 ? mostCountedWord : null;
    }

    private String[] getArrayOfWords(String input) {
        String[] strings = input.split(" ");
        int count = 0;

        for (String string : strings) {
            if (!string.isEmpty()) {
                count++;
            }
        }

        String[] words = new String[count];
        int index = 0;
        for (String string : strings) {
            if (!string.isEmpty()) {
                words[index] = string;
                index++;
            }
        }

        return words;
    }
}
