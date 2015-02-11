package com.example.amado.myfirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {


    private static final String TAG= "MainActivity";
    private static final String EXTRA= "EXTRA";
    private EditText mInputOne;
    private EditText mInputTwo;
    private int mNumberOne;
    private int mNumberTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button subsButton= (Button)findViewById(R.id.sub_button);
        Button sumButton = (Button)findViewById(R.id.sum_button);
        Button multiButton = (Button)findViewById(R.id.multiplication_button);
        Button divideButton = (Button)findViewById(R.id.divide_button);
        mInputOne= (EditText)findViewById(R.id.input_one);
        mInputTwo= (EditText)findViewById(R.id.input_two);
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getNumbers();
                int calculus= Add();
               ShowResult(calculus);
            }
        });
        subsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                int calculus= Substract();
                ShowResult(calculus);
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                int calculus= Divide();
                ShowResult(calculus);
            }
        });
        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
                int calculus= Multiplication();
                ShowResult(calculus);
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);




        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mInputOne.setText("");
            mInputTwo.setText("");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public int Add(){
        int calculus = mNumberOne + mNumberTwo;
        return calculus;
    }
    public int Substract(){
        int calculus = mNumberOne - mNumberTwo;
        return calculus;
    }
    public int Multiplication() {
        int calculus = mNumberOne*mNumberTwo;
        return calculus;
    }
    public int Divide(){
        int calculus = mNumberOne/mNumberTwo;
        return calculus;
    }
    public void ShowResult(int calculus){
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra(MainActivity2.EXTRA, calculus);
        startActivity(i);
    }
    public void getNumbers(){
        String firstInput = mInputOne.getText().toString();
        String secondInput = mInputTwo.getText().toString();
        mNumberOne = toInt(firstInput);
        mNumberTwo = toInt(secondInput);

    }

    public int toInt(String value){
        int number= Integer.parseInt(value);
        return number;
    }
}
