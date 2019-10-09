package com.github.sparsick.test.tool.parametrizedtests;

enum Direction {
    NORTH, SOUTH, WEST, EAST;

    public Direction turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            default:
                return null;
        }
    }

    Direction turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case WEST:
                return NORTH;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            default:
                return null;
        }
    }

}
