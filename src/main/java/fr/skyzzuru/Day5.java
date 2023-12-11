package fr.skyzzuru;

import java.util.*;

public class Day5 {

    public record RowTransformation(Long destination, Long start, Long range){}

    public Long partOne(String input) {
        String[] lines = input.split("\n");
        String firstRow = lines[0];
        String[] seedsRow = firstRow.split(":");
        String seedsValue = seedsRow[1];
        String[] stringValues = seedsValue.trim().split(" ");
        List<Long> values = Arrays.stream(stringValues).map(Long::parseLong).toList();

        List<List<RowTransformation>> transformationList = new ArrayList<>();
        List<RowTransformation> rowTransformations = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            if (line.trim().isBlank()) {
                continue;
            }
            if (line.contains("map")) {
                if (rowTransformations.size() > 0) {
                    transformationList.add(rowTransformations);
                }
                rowTransformations = new ArrayList<>();
                continue;
            }
            String[] row = line.split(" ");
            rowTransformations.add(new RowTransformation(Long.parseLong(row[0]),Long.parseLong(row[1]),Long.parseLong(row[2])));


        }
        if (rowTransformations.size() > 0) {
            transformationList.add(rowTransformations);
        }
        Long lowestSeed = values.get(0);
        List<Long> finalSeeds = new ArrayList<>();

        for (Long seed : values) {
            Long finalSeed = seed;
            for (List<RowTransformation> transformation : transformationList) {
                for (RowTransformation rowTransformation : transformation) {
                    if (finalSeed >= rowTransformation.start && finalSeed <= rowTransformation.start + rowTransformation.range) {
                        finalSeed = rowTransformation.destination + (finalSeed - rowTransformation.start);
                        break;
                    }
                }
            }

            finalSeeds.add(finalSeed);
            if (finalSeed < lowestSeed) {
                lowestSeed = finalSeed;
            }
        }
        return lowestSeed;
    }

    public long partTwo(String input) {
        String[] lines = input.split("\n");
        String firstRow = lines[0];
        String[] seedsRow = firstRow.split(":");
        String seedsValue = seedsRow[1];
        String[] stringValues = seedsValue.trim().split(" ");
        List<Long> values = Arrays.stream(stringValues).map(Long::parseLong).toList();

        List<List<RowTransformation>> transformationList = new ArrayList<>();
        List<RowTransformation> rowTransformations = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            if (line.trim().isBlank()) {
                continue;
            }
            if (line.contains("map")) {
                if (rowTransformations.size() > 0) {
                    transformationList.add(rowTransformations);
                }
                rowTransformations = new ArrayList<>();
                continue;
            }
            String[] row = line.split(" ");
            rowTransformations.add(new RowTransformation(Long.parseLong(row[0]),Long.parseLong(row[1]),Long.parseLong(row[2])));


        }
        if (rowTransformations.size() > 0) {
            transformationList.add(rowTransformations);
        }
        Long lowestSeed = values.get(0);
        System.out.println(lowestSeed);

        for (int i = 0; i < values.size(); i+=2) {
            long startRange = values.get(i);
            long rangeLength = values.get(i+1);
            for (long j = startRange; j < startRange + rangeLength; j++) {
                long finalSeed = j;
                for (List<RowTransformation> transformation : transformationList) {
                    for (RowTransformation rowTransformation : transformation) {
                        if (finalSeed >= rowTransformation.start && finalSeed <= rowTransformation.start + rowTransformation.range) {
                            finalSeed = rowTransformation.destination + (finalSeed - rowTransformation.start);
                            break;
                        }
                    }
                }

                if (finalSeed < lowestSeed) {
                    lowestSeed = finalSeed;
                }


            }
        }
        return lowestSeed;
    }
}
