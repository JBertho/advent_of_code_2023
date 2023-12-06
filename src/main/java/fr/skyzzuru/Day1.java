package fr.skyzzuru;

import java.util.List;
import java.util.Map;

public class Day1 {

    Map<String,String> DIGITS = Map.of("one","1","two","2","three","3","four","4",
            "five","5","six","6","seven","7","eight","8","nine","9");

    String[] checkValue = new String[]{"one","1","two","2","three","2","four","4",
            "five","5","six","6","seven","7","eight","8","nine","9"};

    public void partOne(String value) {
        int sum = 0;
        String[] split = value.split("\n");

        for (String s : split) {
            String start = null;
            String end = null;
            for (String s1 : s.split("")) {
                boolean isDigit = Character.isDigit(s1.charAt(0));
                if(isDigit && start == null) {
                    start = s1;
                    end = s1;
                } else if (isDigit) {
                    end = s1;
                }
            }

            System.out.println("LINE : " + s);
            if (start != null) {
                System.out.println(start);
                System.out.println(end);
                int valueToAdd = Integer.parseInt(start) * 10;
                valueToAdd += Integer.parseInt(end);
                System.out.println("ADD : " + valueToAdd);
                sum += valueToAdd;
            }

        }
        System.out.println("FINAL VALUE = " + sum);
    }

    public void partTwo(String value) {
        int sum = 0;
        String[] split = value.split("\n");

        for (String s : split) {
            String start = null;
            String end = null;
            int startIdx = -1;
            int endIdx = -1;

            for (String numericValue : checkValue) {
                int idx = s.indexOf(numericValue);
                System.out.println("value : " + numericValue + " -> idx :" + idx);
                if(startIdx == -1) {
                    System.out.println("step1");
                    startIdx = idx;
                    start = numericValue;
                } else if (idx < startIdx && idx != -1) {
                    System.out.println("step2");

                    startIdx = idx;
                    start = numericValue;
                }else if (idx > endIdx) {
                    System.out.println("step3");

                    endIdx = idx;
                    end = numericValue;
                }

            }

            System.out.println("LINE : " + s);
            if (start != null) {
                System.out.println(start);
                System.out.println(DIGITS.containsKey(start));
                if (DIGITS.containsKey(start)) {
                    start = DIGITS.get(start);
                    System.out.println(start);
                }
                System.out.println(end);
                System.out.println(DIGITS.containsKey(end));

                if (DIGITS.containsKey(end)) {
                    end = DIGITS.get(end);
                }
                int valueToAdd = Integer.parseInt(start) * 10;
                valueToAdd += Integer.parseInt(end);
                System.out.println("ADD : " + valueToAdd);
                sum += valueToAdd;
            }

        }
        System.out.println("FINAL VALUE = " + sum);
    }
}
