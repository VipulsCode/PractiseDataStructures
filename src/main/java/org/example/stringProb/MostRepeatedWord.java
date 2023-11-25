package org.example.stringProb;

import java.util.HashMap;
import java.util.Map;

public class MostRepeatedWord {

    public static void main(String[] args) {
        String s = "dev,qa,qe,productManager,dev,devops,dev,qa,productManager,qe";

        String[] str = s.split(",");

        Map<String, Integer> splitWordsMap = new HashMap<>();

        for (String singleWord : str) {
            splitWordsMap.put(singleWord, splitWordsMap.getOrDefault(singleWord, 0) + 1);
        }

        // till now the data is already present in hashmap
        String mostRepeatedWord = null;
        int countWord = 0;

        for (Map.Entry<String, Integer> mappedWord : splitWordsMap.entrySet()) {
            if (mappedWord.getValue() > countWord) {
                countWord = mappedWord.getValue();
                mostRepeatedWord = mappedWord.getKey();
            }
        }
        System.out.println("The most repeated word is " + mostRepeatedWord);

    }
}
