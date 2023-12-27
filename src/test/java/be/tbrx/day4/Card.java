package be.tbrx.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Card {

    private final Integer cardId;
    private final List<Integer> winningNumbers;
    private final List<Integer> numbers;

    public Card(String inputLine) {
        String[] inputLineParts = inputLine.split(":");

        this.cardId = extractCardId(inputLineParts[0]);
        this.winningNumbers = extractNumbers(inputLineParts[1].split("\\|")[0]);
        this.numbers = extractNumbers(inputLineParts[1].split("\\|")[1]);
    }

    private List<Integer> extractNumbers(String inputLinePart) {
        Pattern cardIdPattern = Pattern.compile("(\\d+)");
        Matcher matcher = cardIdPattern.matcher(inputLinePart);

        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers;
    }

    private Integer extractCardId(String inputLinePart) {
        Pattern cardIdPattern = Pattern.compile("(\\d+)");
        Matcher matcher = cardIdPattern.matcher(inputLinePart);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return null;
        }
    }

    public Integer getId() {
        return cardId;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer calculatePoints() {
        List<Integer> numbersMatchingWinningNumber = numbers.stream().filter(winningNumbers::contains).toList();
        if (numbersMatchingWinningNumber.size() == 1) {
            return 1;
        } else if (numbersMatchingWinningNumber.size() > 1) {
            return (int) (1 * Math.pow(2, numbersMatchingWinningNumber.size() - 1));
        } else {
            return 0;
        }


    }
}
