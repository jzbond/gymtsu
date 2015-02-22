package com.gymtsu.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * TemplateSet
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"TEMPLATE_ID", "EXERCISE_ID"}))
public class TemplateSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Template template;
    @ManyToOne
    private Exercise exercise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
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

        TemplateSet that = (TemplateSet) o;

        if (exercise != null ? !exercise.equals(that.exercise) : that.exercise != null) {
            return false;
        }
        if (template != null ? !template.equals(that.template) : that.template != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = template != null ? template.hashCode() : 0;
        result = 31 * result + (exercise != null ? exercise.hashCode() : 0);
        return result;
    }
}
