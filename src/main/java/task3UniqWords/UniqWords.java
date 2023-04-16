package task3UniqWords;

import task2FileToFile.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UniqWords {
    public void parseFile(String fileName) {
        HashMap<String, Integer> uniqWords = new HashMap<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        Integer value = uniqWords.get(word);
                        if (value != null) {
                            value ++;
                        } else {
                            value = 1;
                        }

                        uniqWords.put(word, value);
                    }
                }
            } while (line != null);
        } catch (Exception e) {
            System.out.println(e);
        }

//        System.out.println(uniqWords);

        List<String> sortedWords = new ArrayList<>(uniqWords.keySet());
        sortedWords.sort((String o1, String o2) -> {
            return uniqWords.get(o2).compareTo(uniqWords.get(o1));
        });

        sortedWords.forEach(word -> {
            System.out.println(word + ":" + uniqWords.get(word));
        });
    }
}
