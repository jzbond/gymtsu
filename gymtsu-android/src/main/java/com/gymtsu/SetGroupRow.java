package com.gymtsu;

import java.util.List;

public class SetGroupRow {
    boolean done;
    String exercise;
    List<SetRow> sets;

    public SetGroupRow(String exercise, List<SetRow> sets) {
        this(false, exercise, sets);
    }

    public SetGroupRow(boolean done, String exercise, List<SetRow> sets) {
        this.done = done;
        this.exercise = exercise;
        this.sets = sets;
    }
}
