/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sparsick.test.tool.parametrizedtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PositionJUnit5Test {

    @ParameterizedTest
    @MethodSource("createMoveBackwardParameter")
    void moveBackward(Direction direction, Position expectedPosition) {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveBackward(direction);

        assertThat(newPosition).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> createMoveBackwardParameter() {
        return Stream.of(
                Arguments.of(Direction.NORTH, new Position(10, 9)),
                Arguments.of(Direction.EAST, new Position(9, 10)),
                Arguments.of(Direction.SOUTH, new Position(10, 11)),
                Arguments.of(Direction.WEST, new Position(11, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("createMoveForwardParameter")
    void moveForward(Direction direction, Position expectedPosition) {
        Position positionUnderTest = new Position(10, 10);

        Position newPosition = positionUnderTest.moveForward(direction);

        assertThat(newPosition).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> createMoveForwardParameter() {
        return Stream.of(
                Arguments.of(Direction.NORTH, new Position(10, 11)),
                Arguments.of(Direction.EAST, new Position(11, 10)),
                Arguments.of(Direction.SOUTH, new Position(10, 9)),
                Arguments.of(Direction.WEST, new Position(9, 10))
        );
    }

    @Test
    void xCoordinateIsSmallerOrEqualsThan_IsSmaller() {
        Position positionUnderTest = new Position(10, 10);

        boolean result = positionUnderTest.xCoordinateIsSmallerOrEqualThan(11);

        assertThat(result).isTrue();
    }

    @Test
    void xCoordinateIsSmallerOrEqualsThan_IsEqual() {
        Position positionUnderTest = new Position(10, 10);

        boolean result = positionUnderTest.xCoordinateIsSmallerOrEqualThan(10);

        assertThat(result).isTrue();
    }

    @Test
    void xCoordinateIsSmallerOrEqualsThan_IsGreater() {
        Position positionUnderTest = new Position(10, 10);

        boolean result = positionUnderTest.xCoordinateIsSmallerOrEqualThan(9);

        assertThat(result).isFalse();
    }
    
    
    @Test
    void yCoordinateIsSmallerOrEqualsThan_IsSmaller() {
        Position positionUnderTest = new Position(10, 10);

        boolean result = positionUnderTest.yCoordinateIsSmallerOrEqualThan(11);

        assertThat(result).isTrue();
    }

    @Test
    void yCoordinateIsSmallerOrEqualsThan_IsEqual() {
        Position positionUnderTest = new Position(10, 10);

        boolean result = positionUnderTest.yCoordinateIsSmallerOrEqualThan(10);

        assertThat(result).isTrue();
    }

    @Test
    void yCoordinateIsSmallerOrEqualsThan_IsGreater() {
        Position positionUnderTest = new Position(10, 10);

        boolean result = positionUnderTest.yCoordinateIsSmallerOrEqualThan(9);

        assertThat(result).isFalse();
    }
}
