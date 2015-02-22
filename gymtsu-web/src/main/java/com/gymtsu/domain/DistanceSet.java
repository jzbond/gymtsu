package com.gymtsu.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Duration;

/**
 * DistanceSet
 */
@Entity
@DiscriminatorValue(value = "D")
public class DistanceSet extends WorkoutSet {
    private Duration duration;
    private Integer distance;

    @Override
    public void setExercise(Exercise exercise) {
        if (exercise.getType() != ExerciseType.DISTANCE) {
            throw new IllegalArgumentException("wrong type of exercise: " + exercise.getType());
        }
        super.setExercise(exercise);
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
