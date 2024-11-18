package org.example.palavraembaralhada.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordDataBase {
    public WordDataBase() {}

    public String sortedWord() {
        Random random = new Random();
        return wordList().get(random.nextInt(wordList().size()));
    }


    private List<String> wordList()  {
        try {
            List<String> list = new ArrayList<>();
            Scanner scanner = new Scanner(new File("wordList"));
            scanner.useDelimiter("\n");

            while(scanner.hasNext()) {
                list.add(scanner.next());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Word list file not found: " + e.getMessage());
        }

    }
}
