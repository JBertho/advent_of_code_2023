package fr.skyzzuru;

import java.util.*;

public class Day5 {

    public record RowTransformation(Long destination, Long start, Long range){}

    private Map<Long, Long> mapTransformation(List<RowTransformation> rowTransformations) {
        HashMap<Long, Long> transformation = new HashMap<>();

        rowTransformations.forEach(rowTransformation -> {
            for (int i = 0; i < rowTransformation.range; i++) {
                transformation.put(rowTransformation.start + i,rowTransformation.destination + i);
            }
        });

        return transformation;
    }


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
        System.out.println(finalSeeds);
        return lowestSeed;
    }

    public Integer partTwo(String input) {
        return null;
    }
}
