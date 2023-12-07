package fr.skyzzuru;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;

public class Day4 {

    public Integer partOne(String input) {
        Integer sum = 0;
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
        return null;
    }
}
