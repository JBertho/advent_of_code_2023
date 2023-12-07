package fr.skyzzuru;

import java.util.*;

import static java.lang.Math.pow;

public class Day4 {

    public Integer partOne(String input) {
        int sum = 0;
        String[] lines = input.split("\n");
        for (String line : lines) {
            String[] row = line.split(":");
            String values = row[1];
            String[] numbers = values.split("\\|");
            List<String> winningNumbers = Arrays.stream(numbers[0].trim().split(" "))
                    .filter(val -> !val.trim().equals(""))
                    .toList();
            List<String> numbersYouHave = Arrays.stream(numbers[1].trim().split(" "))
                    .filter(val -> !val.trim().equals(""))
                    .toList();
            long countNumberWinning = numbersYouHave.stream().filter(winningNumbers::contains).count();
            if (countNumberWinning > 0) {
                double pow = pow(2.0, countNumberWinning - 1.0);
                sum += (int) pow;
            }
        }
        return sum;
    }

    public Integer partTwo(String input) {
        int sum = 0;
        String[] lines = input.split("\n");
        List<Long> count = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            count.add(1L);
        }

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] row = line.split(":");
            String values = row[1];
            String[] numbers = values.split("\\|");
            List<String> winningNumbers = Arrays.stream(numbers[0].trim().split(" "))
                    .filter(val -> !val.trim().equals(""))
                    .toList();
            List<String> numbersYouHave = Arrays.stream(numbers[1].trim().split(" "))
                    .filter(val -> !val.trim().equals(""))
                    .toList();
            long countNumberWinning = numbersYouHave.stream().filter(winningNumbers::contains).count();
            System.out.println("CARD " + i + " matching : " + countNumberWinning );
            for (int j = 0; j < countNumberWinning; j++) {
                int matchingIndex = i + (j + 1);
                if ( matchingIndex < lines.length) {
                    count.set(matchingIndex, count.get(matchingIndex) + count.get(i));
                    System.out.println("CARD " + matchingIndex + " values :  " + count.get(matchingIndex));
                }
            }
        }

        for (int i = 0; i < count.size(); i++) {
            System.out.println("FINAL VALUE CARD " + (i + 1) + " value : " + count.get(i) );
            sum += count.get(i);
        }
        return sum;
    }
}
