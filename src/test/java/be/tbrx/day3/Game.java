package be.tbrx.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    private final String input;

    public Game(String input) {
        this.input = input;
    }

    public int calculateSumOfEngineParts() {
        String[] linesOfInput = input.split("\n");

        List<Digit> digits = new ArrayList<>();
        List<Symbol> symbols = new ArrayList<>();
        for (int y = 0; y < linesOfInput.length; y++) {
            String line = linesOfInput[y];

            Pattern digitPattern = Pattern.compile("(\\d+)");
            Pattern symbolPattern = Pattern.compile("([^\\d|.])");

            Matcher digitMatcher = digitPattern.matcher(line);
            for (MatchResult matchResult : digitMatcher.results().toList()) {
                int start = matchResult.start();
                int end = matchResult.end();
                String value = line.substring(start, end);

                Digit digit = new Digit(new Coordinate(y, start), new Coordinate(y, end - 1), value);
                digits.add(digit);
            }


            Matcher symbolMatcher = symbolPattern.matcher(line);
            for (MatchResult matchResult : symbolMatcher.results().toList()) {
                int start = matchResult.start();
                int end = matchResult.end();
                String value = line.substring(start, end);

                Symbol symbol = new Symbol(new Coordinate(y, start), value);
                symbols.add(symbol);
            }

        }


        int totalSum = 0;
        for (Digit digit : digits) {
            List<Coordinate> coordinates = digit.getCoordinates();
            boolean nextToSymbol = false;
            for (Coordinate coordinate : coordinates) {
                for (Symbol symbol : symbols) {
                    if(coordinate.isNextTo(symbol.symbolCoordinate())){
                        nextToSymbol = true;
                        break;
                    }
                }
                if(nextToSymbol){
                    break;
                }

            }
            if(nextToSymbol){
                totalSum += Integer.parseInt(digit.value());
            }
        }


        return totalSum;
    }

    public int calculateGearRatios() {
        String[] linesOfInput = input.split("\n");

        List<Digit> digits = new ArrayList<>();
        List<Symbol> symbols = new ArrayList<>();
        for (int y = 0; y < linesOfInput.length; y++) {
            String line = linesOfInput[y];

            Pattern digitPattern = Pattern.compile("(\\d+)");
            Pattern symbolPattern = Pattern.compile("([^\\d|.])");

            Matcher digitMatcher = digitPattern.matcher(line);
            for (MatchResult matchResult : digitMatcher.results().toList()) {
                int start = matchResult.start();
                int end = matchResult.end();
                String value = line.substring(start, end);

                Digit digit = new Digit(new Coordinate(y, start), new Coordinate(y, end - 1), value);
                digits.add(digit);
            }


            Matcher symbolMatcher = symbolPattern.matcher(line);
            for (MatchResult matchResult : symbolMatcher.results().toList()) {
                int start = matchResult.start();
                int end = matchResult.end();
                String value = line.substring(start, end);

                Symbol symbol = new Symbol(new Coordinate(y, start), value);
                symbols.add(symbol);
            }

        }

        int totalSumOfGears = 0;
        for (Symbol symbol : symbols) {
            if(symbol.value().equals("*")){
                List<Digit> digitsNextToGear = new ArrayList<>();

                for (Digit digit : digits) {
                    List<Coordinate> coordinates = digit.getCoordinates();
                    for (Coordinate coordinate : coordinates) {
                        if(coordinate.isNextTo(symbol.symbolCoordinate())){
                            digitsNextToGear.add(digit);
                            break;
                        }
                    }
                }
                if(digitsNextToGear.size() == 2) {
                    totalSumOfGears +=  Integer.parseInt(digitsNextToGear.get(0).value()) * Integer.parseInt(digitsNextToGear.get(1).value());
                }

            }
        }


        return totalSumOfGears;
    }

    private record Digit(Coordinate start, Coordinate end, String value) {
        public List<Coordinate> getCoordinates() {
            List<Coordinate> coordinates = new ArrayList<>();
            for (int x = start.x(); x <= end.x(); x++) {
                coordinates.add(new Coordinate(start.y(), x));
            }
            return coordinates;
        }
    }

    private record Symbol(Coordinate symbolCoordinate, String value) { }

}
