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

    private int otherSports;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.radio_0) {
                    otherSports = 1;
                } else {
                    otherSports = 0;
                }
            }
        });
    }

    public void submit(View view) {
        EditText Name = (EditText) findViewById(R.id.name);
        String enteredName = Name.getText().toString();

        CheckBox answer011 = (CheckBox) findViewById(R.id.check011);
        boolean aAnswer011 = answer011.isChecked();
        CheckBox answer012 = (CheckBox) findViewById(R.id.check012);
        boolean aAnswer012 = answer012.isChecked();
        CheckBox answer013 = (CheckBox) findViewById(R.id.check013);
        boolean aAnswer013 = answer013.isChecked();

        CheckBox answer021 = (CheckBox) findViewById(R.id.check021);
        boolean aAnswer021 = answer021.isChecked();
        CheckBox answer022 = (CheckBox) findViewById(R.id.check022);
        boolean aAnswer022 = answer022.isChecked();
        CheckBox answer023 = (CheckBox) findViewById(R.id.check023);
        boolean aAnswer023 = answer023.isChecked();

        CheckBox answer031 = (CheckBox) findViewById(R.id.check031);
        boolean aAnswer031 = answer031.isChecked();
        CheckBox answer032 = (CheckBox) findViewById(R.id.check032);
        boolean aAnswer032 = answer032.isChecked();
        CheckBox answer033 = (CheckBox) findViewById(R.id.check033);
        boolean aAnswer033 = answer033.isChecked();

        CheckBox answer041 = (CheckBox) findViewById(R.id.check041);
        boolean aAnswer041 = answer041.isChecked();
        CheckBox answer042 = (CheckBox) findViewById(R.id.check042);
        boolean aAnswer042 = answer042.isChecked();
        CheckBox answer043 = (CheckBox) findViewById(R.id.check043);
        boolean aAnswer043 = answer043.isChecked();

        EditText famousSwimmer = (EditText) findViewById(R.id.edit_answer);
        String answer = famousSwimmer.getText().toString();
        answer = answer.replace(" ", "");
        String correctAnswer = getString(R.string.answer06);
        correctAnswer = correctAnswer.replace(" ", "");
        int correct = 0;
        if (answer.equalsIgnoreCase(correctAnswer)) {
            correct = 1;
        } else {
            correct = 0;
        }


        int sports = checkedNumber(aAnswer011, aAnswer012, aAnswer013, aAnswer021, aAnswer022, aAnswer023,
                aAnswer031, aAnswer032, aAnswer033, aAnswer041, aAnswer042, aAnswer043);
        int AllSports = sports + otherSports + correct;

        String thankYou = getString(R.string.thankYou);
        String yourResultis = getString(R.string.yourResultis);
        String subject = (thankYou + " " + enteredName + "\n" + " " + yourResultis + " " + AllSports + " out of 10");
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

    private int checkedNumber(boolean answer011, boolean answer012, boolean answer013, boolean answer021,
                              boolean answer022, boolean answer023, boolean answer031, boolean answer032, boolean answer033, boolean answer041,
                              boolean answer042, boolean answer043) {
        int numberOfCheckedSports = 0;
        if (answer011) {
            numberOfCheckedSports += 1;
        }
        if (answer012) {
            numberOfCheckedSports -= 1;
        }
        if (answer013) {
            numberOfCheckedSports += 1;
        }
        if (answer021) {
            numberOfCheckedSports += 1;
        }
        if (answer022) {
            numberOfCheckedSports += 1;
        }
        if (answer023) {
            numberOfCheckedSports -= 1;
        }
        if (answer031) {
            numberOfCheckedSports -= 1;
        }
        if (answer032) {
            numberOfCheckedSports += 1;
        }
        if (answer033) {
            numberOfCheckedSports += 1;
        }
        if (answer041) {
            numberOfCheckedSports += 1;
        }
        if (answer042) {
            numberOfCheckedSports += 1;
        }
        if (answer043) {
            numberOfCheckedSports -= 1;
        }
        return numberOfCheckedSports;
    }
}