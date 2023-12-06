package fr.skyzzuru;

public class Day1 {
    public void exec(String value) {
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

            if (start != null) {
                int valueToAdd = Integer.parseInt(start) * 10;
                valueToAdd += Integer.parseInt(end);
                sum += valueToAdd;
            }

        }
        System.out.println("FINAL VALUE = " + sum);
    }
}
