package com.example;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) throws IOException {

        String file = "words.txt";
        List<String> words = new ArrayList<>();

        // scriem cuvintele intr-un fisier
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            List<String> wordsInFile = List.of("Masina", "Caine", "Suc", "Patura", "Patura", "Ciocolata", "Frig", "Frig", "Ou", "Geanta", "Caleidoscopic");
            for (String word : wordsInFile) {
                bufferedWriter.write(word);
                bufferedWriter.newLine();
               //puteam direct de aici sa le bag in lista dar le-am pus in fisier si am luat de acolo
            }
        }

        //citim cuvintele
        words = Files.lines(Paths.get(file))
                .flatMap(line -> Stream.of(line.split("\\s+")))    //separam dupa whitespace
                .collect(Collectors.toList());
        System.out.println("all the words: " + words);

        //caut cel mai lung cuvant
        String longestWord = words.stream()
                .max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("longest word: " + longestWord);

        //filtrare dupa lungimea numelui (4)
        words = words.stream()
                .filter(word -> word.length() <= 4)
                .collect(Collectors.toList());
        System.out.println("filtered words: " + words);

        //lowercase restul de cuvinte
        words = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("lowercased words: " + words);

        //stergem duplicatele
        words = words.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct words: " + words);

        //sortam alfabetic ce a ramas
        words = words.stream()
                .sorted(Comparator.naturalOrder())    //natural order stie alfabetic pt string
                .collect(Collectors.toList());
        System.out.println("sorted words: " + words);
    }
}
