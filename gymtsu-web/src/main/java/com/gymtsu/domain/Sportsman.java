package com.gymtsu.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sportsman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
//    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
    private int height;
    private int weight;
    @Transient
    private Level level;
    private int levelCode;
    @ManyToOne
    private Program currentProgram;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Program getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(Program currentProgram) {
        this.currentProgram = currentProgram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sportsman sportsman = (Sportsman) o;

        if (!dateOfBirth.equals(sportsman.dateOfBirth)) {
            return false;
        }
        if (!firstName.equals(sportsman.firstName)) {
            return false;
        }
        if (!lastName.equals(sportsman.lastName)) {
            return false;
        }
        if (!middleName.equals(sportsman.middleName)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        return result;
    }

    @PrePersist
    void populateDBFields() {
        levelCode = level.getCode();
    }

    @PostLoad
    void populateTransientFields() {
        level = Level.valueOfByCode(levelCode);
    }


}
