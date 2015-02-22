package com.gymtsu.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Duration;

/**
 * WeightSet
 */
@Entity
@DiscriminatorValue(value = "W")
public class WeightSet extends WorkoutSet {
    private Integer weight;
    private Integer repeats;

    @Override
    public void setExercise(Exercise exercise) {
        if (exercise.getType() != ExerciseType.WEIGHT) {
            throw new IllegalArgumentException("wrong type of exercise: " + exercise.getType());
        }
        super.setExercise(exercise);
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getRepeats() {
        return repeats;
    }

    public void setRepeats(Integer repeats) {
        this.repeats = repeats;
    }
}
