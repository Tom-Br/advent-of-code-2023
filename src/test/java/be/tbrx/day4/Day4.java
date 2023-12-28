package be.tbrx.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day4 {
    public static int sumOfAllCardValues(String input) {

        //split and map input
        List<Card> cards = getCards(input);

        int sumOfCardValues = 0;
        for (Card card : cards) {
            sumOfCardValues += card.calculatePoints();
        }

        return sumOfCardValues;
    }

    public static int calculateTotalScratchCards(String input) {
        List<Card> originalCards = getCards(input);

        List<Card> scratchCards = new ArrayList<>();
        for (Card card : originalCards) {
            // add original to pile of scratchcards
            scratchCards.add(card);

            // get all copies based on total WinningNumbers
            Integer totalWinningNumbers = card.totalWinningNumbers();

            List<Card> copiesOfCards = bla(card, originalCards);
            scratchCards.addAll(copiesOfCards);
        }


        return scratchCards.size();
    }

    private static List<Card> bla(Card card, List<Card> originalCards) {
        if(card.totalWinningNumbers() == 0) {
            return new ArrayList<>();
        } else {
            List<Card> copiesOfCards = new ArrayList<>();
            for (int i = card.getId(); i < card.getId() + card.totalWinningNumbers(); i++) {
                copiesOfCards.add(originalCards.get(i));
                copiesOfCards.addAll(bla(originalCards.get(i), originalCards));
            }
            return copiesOfCards;
        }
    }


    private static List<Card> getCards(String input) {
        String[] inputLines = input.split("\n");
        return Stream.of(inputLines).map(Card::new).toList();
    }
}
