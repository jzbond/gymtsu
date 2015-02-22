package com.gymtsu.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"WORKOUT_ID", "EXERCISE_ID"}))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "set_type", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class WorkoutSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Workout workout;
    @ManyToOne
    private Exercise exercise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WorkoutSet that = (WorkoutSet) o;

        if (exercise != null ? !exercise.equals(that.exercise) : that.exercise != null) {
            return false;
        }
        if (workout != null ? !workout.equals(that.workout) : that.workout != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = workout != null ? workout.hashCode() : 0;
        result = 31 * result + (exercise != null ? exercise.hashCode() : 0);
        return result;
    }
}
