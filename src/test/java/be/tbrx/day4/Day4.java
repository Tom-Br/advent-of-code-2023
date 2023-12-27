package be.tbrx.day4;

import java.util.List;
import java.util.stream.Stream;

public class Day4 {
    public static int sumOfAllCardValues(String input) {

        //split and map input
        String[] inputLines = input.split("\n");
        List<Card> cards = Stream.of(inputLines).map(Card::new).toList();

        int sumOfCardValues = 0;
        for (Card card : cards) {
            sumOfCardValues += card.calculatePoints();
        }

        return sumOfCardValues;
    }
}
