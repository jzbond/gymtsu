package com.gymtsu.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

/**
 * Workout
 */
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, unique = true)
    private LocalDateTime startTime;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "workout")
    private Collection<WorkoutSet> sets;

    @OneToOne
    @JoinColumn(nullable = false)
    private Sportsman sportsman;

    @ManyToOne
    private Template template;

    @ManyToOne
    private Gym gym;

    //clarify: we can also add something like workoutType
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Collection<WorkoutSet> getSets() {
        return sets;
    }

    public void setSets(Collection<WorkoutSet> sets) {
        this.sets = sets;
    }

    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Workout)) {
            return false;
        }

        Workout workout = (Workout) o;
        return Objects.equals(startTime, workout.startTime);
    }

    @Override
    public int hashCode() {
        return startTime != null ? startTime.hashCode() : 0;
    }
}
