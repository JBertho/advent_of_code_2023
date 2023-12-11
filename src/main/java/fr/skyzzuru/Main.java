package fr.skyzzuru;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileLoader fileLoader = new FileLoader();
        Day1 day1 = new Day1();
        System.out.println("-- DAY 1 --");

        day1.partOne( fileLoader.readFile("day1_input.txt"));
        day1.partTwo( fileLoader.readFile("day1_input.txt"));
        day1.partTwo( fileLoader.readFile("day1_input_exemple.txt"));

        Day2 day2 = new Day2();
        System.out.println("\n-- DAY 2 --");
        System.out.println(day2.partOne(fileLoader.readFile("day2_input.txt")));
        System.out.println(day2.partTwo(fileLoader.readFile("day2_input.txt")));

        Day3 day3 = new Day3();
        System.out.println("\n-- DAY 3 --");
        System.out.println(day3.partOne(fileLoader.readFile("day3_input_exemple.txt")));
        System.out.println(day3.partOne(fileLoader.readFile("day3_input.txt")));
        System.out.println(day3.partTwo(fileLoader.readFile("day3_input_exemple.txt")));
        System.out.println(day3.partTwo(fileLoader.readFile("day3_input.txt")));

        Day4 day4 = new Day4();
        System.out.println("\n-- DAY 4 --");
        System.out.println(day4.partOne(fileLoader.readFile("day4_input.txt")));
        System.out.println(day4.partOne(fileLoader.readFile("day4_input_exemple.txt")));
        System.out.println(day4.partTwo(fileLoader.readFile("day4_input.txt")));
        System.out.println(day4.partTwo(fileLoader.readFile("day4_input_exemple.txt")));

        Day5 day5 = new Day5();
        System.out.println("\n-- DAY 5 --");
        System.out.println(day5.partOne(fileLoader.readFile("day5_input_exemple.txt")));
        System.out.println(day5.partOne(fileLoader.readFile("day5_input.txt")));
        System.out.println(day5.partTwo(fileLoader.readFile("day5_input_exemple.txt")));
        System.out.println(day5.partTwo(fileLoader.readFile("day5_input.txt")));


    }

}