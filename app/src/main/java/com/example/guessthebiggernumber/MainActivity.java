package com.example.guessthebiggernumber;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static int count=0;
    static int number1=0;
    static int number2=0;
    static boolean button1=false;
    static boolean button2=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void button1(View view) {
            if((button1==true)&&(button2==false)){
                showcongratulations();
            }
            else if((button1==false)&&(button2==true)){
                //wrong
            }
            generatenewnumber();
            count=count+1;
    }
    public void button2(View view) {
        if((button1==false)&&(button2==true)){
            showcongratulations();
        }
        else if((button1==true)&&(button2==false)){
            //wrong
        }
        generatenewnumber();
        count=count+1;
    }

    private void showcongratulations() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Congratulations");
        alertDialog.setMessage("you are right.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void generatenewnumber() {
        TextView firstnumber = this.findViewById(R.id.firstnumber);
        TextView secondnumber = this.findViewById(R.id.secondnumber);
        Random r = new Random();
        number1 = r.nextInt(99);
        number2 = r.nextInt(99);
        firstnumber.setText(Integer.toString(number1));
        secondnumber.setText(Integer.toString(number2));
        if(number1>number2)
        {
            button1=true;
            button2=false;
        }else
        {
            button1=false;
            button2=true;
        }
    }



}
