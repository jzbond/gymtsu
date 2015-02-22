package com.gymtsu.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Exercise
 */
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ExerciseGroup group;

    @Transient
    private ExerciseType type;

    @Column(nullable = false)
    private int typeCode;

    @OneToMany(mappedBy = "exercise")
    private Collection<WorkoutSet> sets;

    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExerciseGroup getGroup() {
        return group;
    }

    public void setGroup(ExerciseGroup group) {
        this.group = group;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

    public Collection<WorkoutSet> getSets() {
        return sets;
    }

    public void setSets(Collection<WorkoutSet> sets) {
        this.sets = sets;
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
        if (!(o instanceof Exercise)) {
            return false;
        }

        Exercise exercise = (Exercise) o;
        return Objects.equals(name, exercise.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @PrePersist
    void populateDBFields() {
        typeCode = type.getCode();
    }

    @PostLoad
    void populateTransientFields() {
        type = ExerciseType.valueOfByCode(typeCode);
    }
}
