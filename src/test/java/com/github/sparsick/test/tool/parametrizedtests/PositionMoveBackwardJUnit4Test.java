package com.github.sparsick.test.tool.parametrizedtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class PositionMoveBackwardJUnit4Test {

    private final Direction direction;
    private final Position expectedPosition;

    public PositionMoveBackwardJUnit4Test(Direction direction, Position expectedPosition) {
        this.direction = direction;
        this.expectedPosition = expectedPosition;
    }

    @Parameterized.Parameters
    public static Collection moveBackwardParameter() {
        return Arrays.asList(new Object[][]{
                {Direction.NORTH, new Position(10, 9)},
                {Direction.EAST, new Position(9, 10)},
                {Direction.SOUTH, new Position(10, 11)},
                {Direction.WEST, new Position(11, 10)}
        });
    }

    @Test
    public void moveBackward() {
        Position positionUnderTest = new Position(10, 10);
        Position newPosition = positionUnderTest.moveBackward(direction);
        assertThat(newPosition).isEqualTo(expectedPosition);
    }


}
