package com.avci.javamobilsayauygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class AyarlarActivity extends AppCompatActivity {
    public static int upLimit, downLimit;
    public static boolean soundChecked, vibrationChecked;

    Button plusUpLimit, minusUplimit, plusDownLimit, minusDownLimit;
    TextView upperLimit, lowerLimit;

    CheckBox sound_Checkbox, vibrate_Checkbox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);

        plusUpLimit=(Button) findViewById(R.id.plusUpLimitbtn);
        plusDownLimit=(Button) findViewById(R.id.plusDownLimitbtn);
        minusUplimit=(Button) findViewById(R.id.minusUpLimitbtn);
        minusDownLimit=(Button) findViewById(R.id.minusDownLimitbtn);
        upperLimit=(TextView) findViewById(R.id.upLimitText);
        lowerLimit=(TextView) findViewById(R.id.downLimitText);
        sound_Checkbox=(CheckBox) findViewById(R.id.sesBox);
        sound_Checkbox.setChecked(soundChecked);
        vibrate_Checkbox=(CheckBox) findViewById(R.id.titresimBox);
        vibrate_Checkbox.setChecked(vibrationChecked);

        sound_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                soundChecked=isChecked;
                SingletonSharedPreferences.soundSet(soundChecked);
            }
        });

        vibrate_Checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                vibrationChecked=isChecked;
                SingletonSharedPreferences.vibrateSet(vibrationChecked);
            }
        });

        plusUpLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upLimit++;
                upperLimit.setText(String.valueOf(upLimit));
                SingletonSharedPreferences.upLimitSet(upLimit);
            }

        });

        plusDownLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLimit++;
                lowerLimit.setText(String.valueOf(downLimit));
                SingletonSharedPreferences.downLimitSet(downLimit);
            }
        });

        minusUplimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upLimit--;
                upperLimit.setText(String.valueOf(upLimit));
                SingletonSharedPreferences.upLimitSet(upLimit);
            }
        });

        minusDownLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLimit--;
                lowerLimit.setText(String.valueOf(downLimit));
                SingletonSharedPreferences.downLimitSet(downLimit);
            }
        });


    }

}
