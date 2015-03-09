package com.gymtsu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;

import java.util.Arrays;
import java.util.List;

public class TrainingDayActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.training_list_view);

        TrainingListViewAdapter adapter = new TrainingListViewAdapter(this, prepareTrainingData());
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.gymtsu.R.menu.main, menu);
        return true;
    }

    private List<SetGroupRow> prepareTrainingData() {
        return Arrays.asList(
                new SetGroupRow("Жим", Arrays.asList(
                        new SetRow(true, "Жим", 40, 12),
                        new SetRow(true, "Жим", 50, 8),
                        new SetRow(true, "Жим", 60, 10),
                        new SetRow(false, "Жим", 60, 10),
                        new SetRow(false, "Жим", 60, 10)
                )),
                new SetGroupRow("Тріцуля", Arrays.asList(
                        new SetRow(false, "Тріцуля", 20, 15),
                        new SetRow(false, "Тріцуля", 20, 15)
                )),
                new SetGroupRow("Присяд", Arrays.asList(
                        new SetRow(false, "Присяд", 40, 10),
                        new SetRow(false, "Присяд", 40, 10),
                        new SetRow(false, "Присяд", 40, 10)
                )),
                new SetGroupRow("Прес", Arrays.asList(
                        new SetRow(false, "Прес", 0, 25),
                        new SetRow(false, "Прес", 0, 25),
                        new SetRow(false, "Прес", 0, 25)
                ))
        );
    }
}

