package jp.techacademy.wakabayashi.kojiro.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(intent != null) {
            int value1 = intent.getIntExtra("VALUE1", 0);
            float value2 = intent.getFloatExtra("VALUE2", (float) 0.0);
            float value3 = intent.getFloatExtra("VALUE3", (float) 0.0);

            TextView textView = (TextView) findViewById(R.id.textView);
           // textView.setText(String.valueOf(value2 + value3));


            switch (value1) {
                case 1:
                    textView.setText(String.valueOf(value2 + value3));
                    break;
                case 2:
                    textView.setText(String.valueOf(value2 - value3));
                    break;
                case 3:
                    textView.setText(String.valueOf(value2 * value3));
                    break;
                case 4:
                    textView.setText(String.valueOf(value2 / value3));
                    break;
            }

        }

    }
}
