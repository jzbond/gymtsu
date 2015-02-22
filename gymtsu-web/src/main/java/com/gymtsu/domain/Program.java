package com.gymtsu.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Program
 */
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String notes;

    @OneToMany(mappedBy = "program")
    private Collection<Template> templates;

    public Collection<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(Collection<Template> templates) {
        this.templates = templates;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Program)) {
            return false;
        }

        Program program = (Program) o;
        return Objects.equals(name, program.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
