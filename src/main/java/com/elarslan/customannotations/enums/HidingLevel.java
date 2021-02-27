package com.elarslan.customannotations.enums;

/**
 * LEVEL_ONE: Can be accessed by anyone
 * LEVEL_TWO: Can be accessed by tech lead of any project
 * LEVEL_THREE: Can be accessed by chief engineer of any project
 * LEVEL_FOUR: Can be accessed by only head of NASA
 */
public enum HidingLevel {
    LEVEL_ONE(1), LEVEL_TWO(2), LEVEL_THREE(3), LEVEL_FOUR(4);

    private final int level;

    HidingLevel(int level) {
        this.level = level;
    }

    public int level() {
        return level;
    }
}
