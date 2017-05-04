package com.example.mkostiuk.android_vote_remote.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mkostiuk.android_vote_remote.R;

public class App extends AppCompatActivity {

    private Button one, two, three, four, five, six, seven, eight, nine, zero, inscription;

    public void activate(Button ... buttons) {
        for (Button b : buttons)
            b.setClickable(true);
    }

    public void deactivate(Button ... buttons) {
        for (Button b : buttons)
            b.setClickable(false);
    }

    public void init() {
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        inscription = (Button) findViewById(R.id.inscription);
        activate(one, two, three, four, five, six, seven, eight, nine, zero, inscription);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        init();
    }

    public void onClickOne(View view) {

    }

    public void onClickTwo(View view) {

    }

    public void onClickThree(View view) {

    }

    public void onClickFour(View view) {

    }

    public void onClickFive(View view) {

    }

    public void onClickSix(View view) {

    }

    public void onClickSeven(View view) {

    }

    public void onClickEight(View view) {

    }

    public void onClickNine(View view) {

    }

    public void onClickZero(View view) {

    }

    public void onClickInscription(View view) {

    }
}
