package be.tbrx.day3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest {

    @Test
    void toTheRight() {
        Coordinate a = new Coordinate(1, 1);
        Coordinate b = new Coordinate(1, 2);

        assertThat(a.isNextTo(b)).isTrue();
    }

    @Test
    void toTheLeft() {
        Coordinate a = new Coordinate(1, 1);
        Coordinate b = new Coordinate(1, 0);

        assertThat(a.isNextTo(b)).isTrue();
    }

    @Test
    void down() {
        Coordinate a = new Coordinate(1, 1);
        Coordinate b = new Coordinate(2, 1);

        assertThat(a.isNextTo(b)).isTrue();
    }

    @Test
    void up() {
        Coordinate a = new Coordinate(1, 1);
        Coordinate b = new Coordinate(0, 1);

        assertThat(a.isNextTo(b)).isTrue();
    }

    @Test
    void diagonal() {
        Coordinate upLeft = new Coordinate(0, 0);
        Coordinate upRight = new Coordinate(0, 2);
        Coordinate a = new Coordinate(1, 1);
        Coordinate downLeft = new Coordinate(2, 0);
        Coordinate downRight = new Coordinate(2, 2);

        assertThat(a.isNextTo(upLeft)).isTrue();
        assertThat(a.isNextTo(upRight)).isTrue();
        assertThat(a.isNextTo(downLeft)).isTrue();
        assertThat(a.isNextTo(downRight)).isTrue();
    }

    @Test
    void notNextToEachOther() {
        Coordinate a = new Coordinate(1, 1);
        Coordinate b = new Coordinate(3, 3);

        assertThat(a.isNextTo(b)).isFalse();
    }
}
