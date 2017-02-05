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

    int otherSports = 0;

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

        CheckBox swims = (CheckBox) findViewById(R.id.check01);
        boolean doSwim = swims.isChecked();

        CheckBox ridesBike = (CheckBox) findViewById(R.id.check02);
        boolean doBike = ridesBike.isChecked();

        CheckBox Jogs = (CheckBox) findViewById(R.id.check03);
        boolean doJog = Jogs.isChecked();

        CheckBox playsFootball = (CheckBox) findViewById(R.id.check04);
        boolean doFootball = playsFootball.isChecked();

        CheckBox skis = (CheckBox) findViewById(R.id.check05);
        boolean doSki = skis.isChecked();

        CheckBox ridesSnowboard = (CheckBox) findViewById(R.id.check06);
        boolean doSnowboard = ridesSnowboard.isChecked();

        CheckBox playsVolleyball = (CheckBox) findViewById(R.id.check07);
        boolean doVolleyball = playsVolleyball.isChecked();

        CheckBox playsTennis = (CheckBox) findViewById(R.id.check08);
        boolean doTennis = playsTennis.isChecked();

        CheckBox worksOut = (CheckBox) findViewById(R.id.check09);
        boolean doWorkOut = worksOut.isChecked();

        int sports = checkedNumber(doSwim, doBike, doJog, doFootball, doSki, doSnowboard, doVolleyball, doTennis, doWorkOut);
        int AllSports = sports + otherSports;

        String thankYou = getString(R.string.thankYou);
        String yourResultis = getString(R.string.yourResultis);
        String subject = (thankYou + enteredName + "\n" + yourResultis + AllSports + " out of 10");
        Toast.makeText(this, subject, Toast.LENGTH_LONG).show();
    }

    public void submit2(View view) {

        CheckBox swims = (CheckBox) findViewById(R.id.check01);
        boolean doSwim = swims.isChecked();

        CheckBox ridesBike = (CheckBox) findViewById(R.id.check02);
        boolean doBike = ridesBike.isChecked();

        CheckBox Jogs = (CheckBox) findViewById(R.id.check03);
        boolean doJog = Jogs.isChecked();

        CheckBox playsFootball = (CheckBox) findViewById(R.id.check04);
        boolean doFootball = playsFootball.isChecked();

        CheckBox skis = (CheckBox) findViewById(R.id.check05);
        boolean doSki = skis.isChecked();

        CheckBox ridesSnowboard = (CheckBox) findViewById(R.id.check06);
        boolean doSnowboard = ridesSnowboard.isChecked();

        CheckBox playsVolleyball = (CheckBox) findViewById(R.id.check07);
        boolean doVolleyball = playsVolleyball.isChecked();

        CheckBox playsTennis = (CheckBox) findViewById(R.id.check08);
        boolean doTennis = playsTennis.isChecked();

        CheckBox worksOut = (CheckBox) findViewById(R.id.check09);
        boolean doWorkOut = worksOut.isChecked();

        int sports = checkedNumber(doSwim, doBike, doJog, doFootball, doSki, doSnowboard, doVolleyball, doTennis, doWorkOut);
        int AllSports = sports + otherSports;

        String displayResults1 = getString(R.string.results1);
        String displayResults2 = getString(R.string.results2);
        String displayResults3 = getString(R.string.results3);
        String displayResults4 = getString(R.string.results4);

        if (AllSports <= 2) {
            results1(displayResults1);
        } else if (AllSports <= 4) {
            results1(displayResults2);
        } else if (AllSports <= 8) {
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


    private int checkedNumber(boolean doSwim, boolean doBike, boolean doJog, boolean doFootball,
                              boolean doSki, boolean doSnowboard, boolean doVolleyball,
                              boolean doTennis, boolean doWorkOut) {
        int numberOfCheckedSports = 0;
        if (doSwim) {
            numberOfCheckedSports += 1;
        }
        if (doBike) {
            numberOfCheckedSports += 1;
        }
        if (doJog) {
            numberOfCheckedSports += 1;
        }
        if (doFootball) {
            numberOfCheckedSports += 1;
        }
        if (doSki) {
            numberOfCheckedSports += 1;
        }
        if (doSnowboard) {
            numberOfCheckedSports += 1;
        }
        if (doVolleyball) {
            numberOfCheckedSports += 1;
        }
        if (doTennis) {
            numberOfCheckedSports += 1;
        }
        if (doWorkOut) {
            numberOfCheckedSports += 1;
        }
        return numberOfCheckedSports;
    }
}