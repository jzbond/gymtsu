package com.gymtsu.domain;

import javax.persistence.*;

/**
 * Template
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "program_id"}))
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    //todo: we can fix template on specific day of week, but i'm not sure it's good idea.

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Template)) {
            return false;
        }

        Template template = (Template) o;

        if (name != null ? !name.equals(template.name) : template.name != null) {
            return false;
        }
        if (program != null ? !program.equals(template.program) : template.program != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (program != null ? program.hashCode() : 0);
        return result;
    }
}
