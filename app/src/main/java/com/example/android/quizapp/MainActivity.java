package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int otherSports = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.radio_0) {
                    otherSports = 0;
                } else if (checkedId == R.id.radio_1) {
                    otherSports = 1;
                } else if (checkedId == R.id.radio_2) {
                    otherSports = 2;
                } else {
                    otherSports = 3;
                }
            }
        });
    }

    public void submit(View view) {
        EditText Name = (EditText) findViewById(R.id.name);
        String enteredName = Name.getText().toString();

        CheckBox swimsSea = (CheckBox) findViewById(R.id.check011);
        boolean sea = swimsSea.isChecked();
        CheckBox swimsPool = (CheckBox) findViewById(R.id.check012);
        boolean pool = swimsPool.isChecked();
        CheckBox swimsRiver = (CheckBox) findViewById(R.id.check013);
        boolean river = swimsRiver.isChecked();

        CheckBox ridesBikeOutskirts2 = (CheckBox) findViewById(R.id.check021);
        boolean outskirts2 = ridesBikeOutskirts2.isChecked();
        CheckBox ridesBikeCity2 = (CheckBox) findViewById(R.id.check022);
        boolean city2 = ridesBikeCity2.isChecked();
        CheckBox ridesBikeVillage = (CheckBox) findViewById(R.id.check023);
        boolean village2 = ridesBikeVillage.isChecked();

        CheckBox JogsOutskirts3 = (CheckBox) findViewById(R.id.check031);
        boolean outskirts3 = JogsOutskirts3.isChecked();
        CheckBox JogsCity3 = (CheckBox) findViewById(R.id.check032);
        boolean city3 = JogsCity3.isChecked();
        CheckBox JogsVillage3 = (CheckBox) findViewById(R.id.check033);
        boolean village3 = JogsVillage3.isChecked();

        CheckBox worksOutOutskirts4 = (CheckBox) findViewById(R.id.check041);
        boolean outskirts4 = worksOutOutskirts4.isChecked();
        CheckBox worksOutCity4 = (CheckBox) findViewById(R.id.check042);
        boolean city4 = worksOutCity4.isChecked();
        CheckBox worksOutVilage4 = (CheckBox) findViewById(R.id.check043);
        boolean village4 = worksOutVilage4.isChecked();

        EditText famousSwimmer = (EditText) findViewById(R.id.edit_answer);
        String answer = famousSwimmer.getText().toString().toLowerCase();
        answer = answer.replace(" ", "");
        String correctAnswer = getString(R.string.answer06).toLowerCase();
        correctAnswer = correctAnswer.replace(" ", "");
        int correct = 0;
        if (answer.equals(correctAnswer)) {
            correct = 1;
        } else {
            correct = 0;
        }




        int sports = checkedNumber(sea, pool, river, outskirts2, city2, village2, outskirts3, city3, village3, outskirts4, city4, village4);
        int AllSports = sports + otherSports + correct;

        String thankYou = getString(R.string.thankYou);
        String yourResultis = getString(R.string.yourResultis);
        String subject = (thankYou + " " + enteredName + "\n" + " " + yourResultis + " " + AllSports + " out of 15");
        Toast.makeText(this, subject, Toast.LENGTH_LONG).show();

        String displayResults1 = getString(R.string.results1);
        String displayResults2 = getString(R.string.results2);
        String displayResults3 = getString(R.string.results3);
        String displayResults4 = getString(R.string.results4);

        if (AllSports <= 3) {
            results1(displayResults1);
        } else if (AllSports <= 5) {
            results1(displayResults2);
        } else if (AllSports <= 9) {
            results1(displayResults3);
        } else {
            results1(displayResults4);
        }
    }

    private void results1(String message) {
        TextView results1 = (TextView) findViewById(R.id.results);
        results1.setText(message);
        results1.setGravity(0x11);
    }

    private int checkedNumber(boolean sea, boolean pool, boolean river, boolean outskirts2,
                              boolean city2, boolean village2, boolean outskirts3,
                              boolean city3, boolean village3, boolean outskirts4,
                              boolean city4, boolean village4) {
        int numberOfCheckedSports = 0;
        if (sea) {
            numberOfCheckedSports += 1;
        }
        if (pool) {
            numberOfCheckedSports += 1;
        }
        if (river) {
            numberOfCheckedSports += 1;
        }
        if (outskirts2) {
            numberOfCheckedSports += 1;
        }
        if (city2) {
            numberOfCheckedSports += 1;
        }
        if (village2) {
            numberOfCheckedSports += 1;
        }
        if (outskirts3) {
            numberOfCheckedSports += 1;
        }
        if (city3) {
            numberOfCheckedSports += 1;
        }
        if (village3) {
            numberOfCheckedSports += 1;
        }
        if (outskirts4) {
            numberOfCheckedSports += 1;
        }
        if (city4) {
            numberOfCheckedSports += 1;
        }
        if (village4) {
            numberOfCheckedSports += 1;
        }
        return numberOfCheckedSports;
    }
}