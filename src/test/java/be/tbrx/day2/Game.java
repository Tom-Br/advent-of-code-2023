package be.tbrx.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    private final int gameId;
    private final List<Round> rounds;

    public Game(String inputString) {
        String[] gameLine = inputString.split(":");

        gameId = extractGameId(gameLine[0]);
        rounds = extractRounds(gameLine[1]);
    }

    private int extractGameId(String gameIdInputString) {
        Pattern pattern = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(gameIdInputString);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            throw new RuntimeException("ID could not be found.");
        }
    }

    private List<Round> extractRounds(String roundsInputString) {
        String[] roundsString = roundsInputString.split(";");
        List<Round> rounds = new ArrayList<>();

        for (String round : roundsString) {
            Pattern pattern = Pattern.compile("(\\d+(?= (green|blue|red)))");
            Matcher matcher = pattern.matcher(round);

            int redCubes = 0;
            int greenCubes = 0;
            int blueCubes = 0;

            while (matcher.find()) {
                if (matcher.group(2).equals("red")) {
                    redCubes = Integer.parseInt(matcher.group(1));
                } else if (matcher.group(2).equals("green")) {
                    greenCubes = Integer.parseInt(matcher.group(1));
                } else if (matcher.group(2).equals("blue")) {
                    blueCubes = Integer.parseInt(matcher.group(1));
                }
            }
            rounds.add(new Round(redCubes, greenCubes, blueCubes));
        }

        return rounds;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", rounds=" + rounds +
                '}';
    }

    public Integer getId() {
        return gameId;
    }

    public boolean isPossible(int maxRedCubes, int maxGreenCubes, int maxBlueCubes) {
        for (Round round : rounds) {
            if (round.getRedCubes() > maxRedCubes) {
                return false;
            } else if (round.getGreenCubes() > maxGreenCubes) {
                return false;
            } else if (round.getBlueCubes() > maxBlueCubes) {
                return false;
            }
        }
        return true;
    }

    public int getFewestCubes(String colorOfCube) {
        int minimumCube = 0;
        for (Round round : rounds) {
            Integer actualAmountOfCubes = round.getCube(colorOfCube);
            if(actualAmountOfCubes >=  minimumCube) {
                minimumCube = actualAmountOfCubes;
            }
        }

        return minimumCube;
    }

}
