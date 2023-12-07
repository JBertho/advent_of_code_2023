package fr.skyzzuru;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    private record Number(int value, int row, int startColumn, int endColumn){}
    private record Symbol(int row, int column){}

    public Integer partOne(String input) {
        String[] split = input.split("\n");
        List<Number> numbersList = new ArrayList<>();
        List<Symbol> symbols = new ArrayList<>();
        int index = 0;
        for (String row : split) {
            String[] column = row.split("");
            int nbStart = -1;
            int nbEnd = -1;
            for (int i = 0; i < column.length; i++)  {
                if (column[i].equals(".") && nbStart != -1) {
                    String numberString = row.substring(nbStart, nbEnd + 1);
                    numbersList.add(new Number(Integer.parseInt(numberString), index, nbStart, nbEnd));
                    nbStart = -1;
                    nbEnd = -1;
                }
                if (column[i].equals(".")) continue;
                if (!column[i].equals(".") && !Character.isDigit(column[i].charAt(0))) {
                    symbols.add(new Symbol(index,i));
                    if (nbStart != -1) {
                        String numberString = row.substring(nbStart, nbEnd + 1);
                        numbersList.add(new Number(Integer.parseInt(numberString), index, nbStart, nbEnd));
                        nbStart = -1;
                        nbEnd = -1;
                    }
                }
                if (Character.isDigit(column[i].charAt(0))) {
                    if (nbStart == -1) {
                        nbStart = i;
                    }
                    if (i > nbEnd) {
                        nbEnd = i;
                    }
                }
            }
            if (nbStart != -1) {
                String numberString = row.substring(nbStart, nbEnd + 1);
                numbersList.add(new Number(Integer.parseInt(numberString), index, nbStart, nbEnd));
            }
            index++;

        }

        int sum = 0;
        for (Symbol symbol : symbols) {
            for (Number number : numbersList) {
                if (number.row == symbol.row &&
                        (number.startColumn + 1 == symbol.column
                                || number.startColumn - 1 == symbol.column
                                || number.endColumn + 1 == symbol.column
                                || number.endColumn - 1 == symbol.column)) {
                    sum += number.value;
                }

                if ((number.row + 1 == symbol.row || number.row - 1 == symbol.row)
                        && (symbol.column >= number.startColumn - 1 && symbol.column <= number.endColumn + 1)
                ) {
                    sum += number.value;

                }

            }

        }
        return sum;
    }
}
