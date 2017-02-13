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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
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

        //http://qiita.com/HALU5071/items/640652de9e31d4bbdbeb
        if(mEditText1.length() != 0 && mEditText2.length() != 0) {

                /*こういう書き方も可能 */
            switch (v.getId()) {
                case R.id.button1:
                    // Button1を押した時
                    Log.d("Button_PARTS", "button01");
                    intent.putExtra("VALUE1", 1);
                    String text1 = mEditText1.getText().toString();
                    String text2 = mEditText2.getText().toString();

                    float number1 = Float.parseFloat(text1);
                    float number2 = Float.parseFloat(text2);
                    intent.putExtra("VALUE2", number1);
                    intent.putExtra("VALUE3", number2);
                    startActivity(intent);

                    break;
                case R.id.button2:
                    // Button2を押した時
                    intent.putExtra("VALUE1", 2);
                    text1 = mEditText1.getText().toString();
                    text2 = mEditText2.getText().toString();

                    number1 = Float.parseFloat(text1);
                    number2 = Float.parseFloat(text2);
                    intent.putExtra("VALUE2", number1);
                    intent.putExtra("VALUE3", number2);
                    startActivity(intent);

                    break;
                case R.id.button3:
                    // Button3を押した時
                    intent.putExtra("VALUE1", 3);
                    text1 = mEditText1.getText().toString();
                    text2 = mEditText2.getText().toString();

                    number1 = Float.parseFloat(text1);
                    number2 = Float.parseFloat(text2);
                    intent.putExtra("VALUE2", number1);
                    intent.putExtra("VALUE3", number2);
                    startActivity(intent);

                    break;
                case R.id.button4:
                    // Button4を押した時

                    if(mEditText2.getText().toString().equals("0") == true){
                        showAlertDialog();
                        break;
                    } else {
                        intent.putExtra("VALUE1", 4);
                        text1 = mEditText1.getText().toString();
                        text2 = mEditText2.getText().toString();

                        number1 = Float.parseFloat(text1);
                        number2 = Float.parseFloat(text2);
                        intent.putExtra("VALUE2", number1);
                        intent.putExtra("VALUE3", number2);
                        startActivity(intent);

                        break;
                    }
            }

/*
            String text1 = mEditText1.getText().toString();
            String text2 = mEditText2.getText().toString();

            float number1 = Float.parseFloat(text1);
            float number2 = Float.parseFloat(text2);
            intent.putExtra("VALUE2", number1);
            intent.putExtra("VALUE3", number2);
            startActivity(intent);
*/
        }


/*
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
            */

    }




    private void showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("エラーです。");
        alertDialogBuilder.setMessage("0除算エラーです。０以外の数字を入力してください。");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("戻る",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "戻るボタン");
                    }
                });
/*
        // 中立ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNeutralButton("中立",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "中立ボタン");
                    }
                });

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("否定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "否定ボタン");
                    }
                });
*/
        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
