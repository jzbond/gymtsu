package com.gymtsu.domain;


public enum ExerciseType {
    WEIGHT(1), DISTANCE(2);

    private int code;

    ExerciseType(int code) {
        this.code = code;
    }

    public static ExerciseType valueOfByCode(int code) {
        for (ExerciseType type : ExerciseType.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return WEIGHT;
    }

    public int getCode() {
        return code;
    }
}
