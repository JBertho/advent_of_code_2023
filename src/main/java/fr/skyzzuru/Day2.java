package fr.skyzzuru;

import java.util.HashMap;
import java.util.Map;

public class Day2 {

    final static private Map<String, Integer> colorsMap = Map.of("red", 12, "blue", 14, "green", 13);

    public Integer partOne(String input) {
        String[] games = input.split("\n");
        int sum = 0;

        for (String game : games) {
            String[] split = game.split(":");
            String content = split[1];
            String[] sets = content.split(";");
            boolean isValid = true;
            for (String set : sets) {
                String[] values = set.split(",");
                for (String value : values) {
                    String[] keyValue = value.trim().split(" ");

                    Integer maxValue = colorsMap.get(keyValue[1].trim());
                    int intValue = Integer.parseInt(keyValue[0].trim());
                    if (intValue > maxValue) {
                        isValid = false;
                    }
                }
            }

            if (isValid) {
                String gameValue = split[0].trim().split(" ")[1];
                int number = Integer.parseInt(gameValue);
                sum += number;
            }

        }
        return sum;
    }


    public Integer partTwo(String input) {
        String[] games = input.split("\n");
        int sum = 0;

        for (String game : games) {
            Map<String, Integer> minColorValues = new HashMap<>();
            minColorValues.put("red",0);
            minColorValues.put("blue",0);
            minColorValues.put("green",0);

            String[] split = game.split(":");
            String content = split[1];
            String[] sets = content.split(";");

            for (String set : sets) {
                String[] values = set.split(",");
                for (String value : values) {
                    String[] keyValue = value.trim().split(" ");
                    Integer minValue = minColorValues.get(keyValue[1].trim());
                    int intValue = Integer.parseInt(keyValue[0].trim());
                    if (intValue > minValue) {
                        minColorValues.replace(keyValue[1].trim(), intValue);
                    }
                }
            }

            int multiply = minColorValues.values().stream().mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
            sum += multiply;

        }
        return sum;
    }
}
