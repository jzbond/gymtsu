package com.gymtsu.domain;


public enum Level {
    BEGINNER(0), MIDDLE(1), ADVANCED(2), GURU(3);

    private int code;

    Level(int code) {
        this.code = code;
    }

    public static Level valueOfByCode(int code) {
        for (Level level : Level.values()) {
            if (level.code == code) {
                return level;
            }
        }
        return BEGINNER;
    }

    public int getCode() {
        return code;
    }
}
