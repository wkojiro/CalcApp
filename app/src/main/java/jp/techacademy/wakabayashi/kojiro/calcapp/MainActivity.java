package jp.techacademy.wakabayashi.kojiro.calcapp;

/*
プロジェクトを新規作成し、 CalcApp というプロジェクト名をつけてください
画面を2つ作成してください
1つ目の画面では、数値入力用の2つのEditTextと、四則計算それぞれのボタンを4つ作成してください
4つの四則計算ボタンのどれかをタップすると、2つ目の画面へ移動させてTextViewで対応する計算結果を表示してください
数値は小数点に対応してください

EditTextを２つ配置
Button holizontalに４つ配置
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;
//    int number1;
//    int number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);

        mEditText2 = (EditText) findViewById(R.id.editText2);

     //   number1 = Float.valueOf(mEditText1.getText().toString());
     //   number2 = Float.valueOf(mEditText2.getText().toString());


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SecondActivity.class);
        if (v.getId() == R.id.button1) {
            intent.putExtra("VALUE1", 1);
        } else if (v.getId() == R.id.button2) {
            intent.putExtra("VALUE1", 2);
        } else if (v.getId() == R.id.button3) {
            intent.putExtra("VALUE1", 3);
        } else if (v.getId() == R.id.button4) {
            intent.putExtra("VALUE1", 4);
        }
        String text1 = mEditText1.getText().toString();
        String text2 = mEditText2.getText().toString();

        float number1 = Float.parseFloat(text1);
        float number2 = Float.parseFloat(text2);
        //number1 = mEditText1.getText().toString());
//        number1 = (float) 11.3;
//        number2 = (float) 1.2;
        intent.putExtra("VALUE2", number1);
        intent.putExtra("VALUE3", number2);
        startActivity(intent);
    }
}
