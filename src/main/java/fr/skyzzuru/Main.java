package fr.skyzzuru;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Day1 day1 = new Day1();
        Day2 day2 = new Day2();
        FileLoader fileLoader = new FileLoader();
        //day1.partOne( fileLoader.readFile("day1_input.txt"));
        //day1.partTwo( fileLoader.readFile("day1_input.txt"));
        //day1.partTwo( fileLoader.readFile("day1_input_exemple.txt"));
        System.out.println(day2.partOne(fileLoader.readFile("day2_input.txt")));
    }

}