package be.tbrx.day4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @Test
    void createNewCard() {
        Card card = new Card("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");

        assertThat(card.getId()).isEqualTo(1);
        assertThat(card.getWinningNumbers()).containsExactly(41, 48, 83, 86, 17);
        assertThat(card.getNumbers()).containsExactly(83, 86, 6, 31, 17, 9, 48, 53);

        assertThat(card.calculatePoints()).isEqualTo(8);
    }
}
