package org.example.InterviewCodes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class InterViewSolving {


    public static void main(String[] args) {
        String[] files = null;
        Set<String> stpWords = new HashSet<>();
        boolean countCapitalWord = false;
        boolean charactersCount = false;

        //CMD parsing

        for (String arg : args) {
            if (arg.startsWith("-F=")) {
                files = arg.substring(3).split(",");
            } else if (arg.startsWith("-S=")) {
                String[] arrayOfStopWords = arg.substring(3).split(",");

                for (String stopWord : arrayOfStopWords) {
                    stpWords.add(stopWord.toLowerCase());
                }
            } else if (arg.equals("-L")) {
                countCapitalWord = true;
            } else if (arg.equals("-C")) {
                charactersCount = true;
            }
        }

        if (files == null || files.length == 0) {
            System.out.println("provide input files using -F parameter");
            return;
        }

        for (String filePath : files) {
            analyseTheFile(filePath, stpWords, countCapitalWord, charactersCount);

        }
    }

    public static void analyseTheFile(String filePath, Set<String> stpWords,  boolean countCapitalWord, boolean charactersCount) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int wordCount = 0;
            int charCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // trying to split through white space

                for (String word : words) {
                    if (checkingEligibilityOfWord(word, stpWords, countCapitalWord)) {
                        wordCount++;

                        if (charactersCount) {
                            charCount = charCount + word.length();
                        }
                    }

                }
            }
            System.out.print("File: " + filePath);
            System.out.print("--> " + wordCount + " words");

            if (charactersCount) {
                System.out.print(", " + charCount + " Symbols");
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkingEligibilityOfWord(String word, Set<String> stpWords, boolean countCapitalWord) {
        if (stpWords.contains(word.toLowerCase())) {
            return false;
        }

        if (countCapitalWord && Character.isLowerCase(word.charAt(0))) {
            return false;
        }
        return true;
    }

}
