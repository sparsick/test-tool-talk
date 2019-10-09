package com.github.sparsick.test.tool.parametrizedtests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionNaiveTest {

    @Test
    void moveBackward_toNorth() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.NORTH);

        assertThat(newPosition).isEqualTo(new Position(10, 9));
    }

    @Test
    void moveBackward_toEast() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.EAST);

        assertThat(newPosition).isEqualTo(new Position(9, 10));
    }

    @Test
    void moveBackward_toSouth() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.SOUTH);

        assertThat(newPosition).isEqualTo(new Position(10, 11));
    }

    @Test
    void moveBackward_toWest() {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(Direction.WEST);

        assertThat(newPosition).isEqualTo(new Position(11, 10));
    }
}
