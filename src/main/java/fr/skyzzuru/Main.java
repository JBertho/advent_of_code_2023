package fr.skyzzuru;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Day1 day1 = new Day1();
        FileLoader fileLoader = new FileLoader();
        day1.exec( fileLoader.readFile("day1_input.txt"));
    }

}