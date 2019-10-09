package com.github.sparsick.test.tool.parametrizedtests

import spock.lang.Specification

class PositionSpockTest extends Specification{

    def "move backward" (Direction direction, Position expectedPosition){
        Position positionUnderTest = new Position(10, 10)
        Position newPosition = positionUnderTest.moveBackward(direction)

        expect:
        assert newPosition == expectedPosition

        where:
        direction | expectedPosition
        Direction.NORTH | new Position(10, 9)
        Direction.EAST | new Position(9, 10)
        Direction.SOUTH | new Position(10, 11)
        Direction.WEST |new Position(11, 10)
    }

    def "move forward" (Direction direction, Position expectedPosition){
        Position positionUnderTest = new Position(10, 10)
        Position newPosition = positionUnderTest.moveForward(direction)

        expect:
        assert newPosition == expectedPosition

        where:
        direction | expectedPosition
        Direction.NORTH | new Position(10, 11)
        Direction.EAST | new Position(11, 10)
        Direction.SOUTH | new Position(10, 9)
        Direction.WEST |new Position(9, 10)
    }
}
