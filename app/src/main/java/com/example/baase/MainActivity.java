package com.example.baase;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {
    private int teama =0;
    private int teamb =0;
    private TextView team1 , team2;
    int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team1 = (TextView) findViewById(R.id.teamA_score_id);
        team2 = (TextView) findViewById(R.id.teamA_score_id11);

    }

    public void threeA(View view) {
        teama = teama+3;
        result(teama);
        changeColor();

    }

    public void twoA(View view) {
        teama = teama+2;
        result(teama);
        changeColor();


    }

    public void oneA(View view) {
        teama = teama+1;
        result(teama);
        changeColor();

    }

    public void threeB(View view) {
        teamb = teamb+3;
        result2(teamb);
        changeColor();

    }

    public void twoB(View view) {
        teamb = teamb+2;
        result2(teamb);
        changeColor();


    }

    public void oneB(View view) {
        teamb = teamb+1;
        result2(teamb);
        changeColor();

    }
    public void seto(View view)
    {
        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Do you want to Reset Score")
                .setConfirmText("Reset")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        teamb =0;
                        teama=0;
                        result(teama);
                        result2(teamb);
                        changeColor();
                        sDialog.dismissWithAnimation();

                    }
                })
                .setCancelText("Close")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        sDialog.dismissWithAnimation();

                    }
                })
                .show();

    }
    public void adjustA(View view)
    {
        changeColor();
        if(teama <= 0)
        {
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("No negative Score!")
                    .show();
            teama = 0;
        }
        else
        {
            teama = teama-1;
            result(teama);
        }


    }

    public void AdjustB(View view) {
        changeColor();
        if (teamb <= 0)
        {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("No negative Score!")
                        .show();
                teamb = 0;

            }
        else
        {

            teamb = teamb - 1;
            result2(teamb);
        }
    }
    public void result(int teama)
    {
        team1.setText(String.valueOf(teama));
    }
    public void result2(int teamb)
    {
        team2.setText(String.valueOf(teamb));

    }
    public void changeColor()
    {
     int a =    Integer.parseInt(team1.getText().toString());
       int b =  Integer.parseInt(team2.getText().toString());
        if(a>b)
        {
            team1.setTextColor(Color.GREEN);
        }
        else
        {
            team1.setTextColor(Color.RED);
        }
        if(b>a)
        {
            team2.setTextColor(Color.GREEN);
        }
        else
        {
            team2.setTextColor(Color.RED);
        }
        if(a==b)
        {
            team1.setTextColor(Color.YELLOW);
            team2.setTextColor(Color.YELLOW);
        }

        }

    @Override
    public void onBackPressed()
    {
        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Do you want to Close")
                .setConfirmText("Reset")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        sDialog.dismissWithAnimation();
                        finish();

                    }
                })
                .setCancelText("Close")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {

                        sDialog.dismissWithAnimation();

                    }
                })
                .show();

    }
}


