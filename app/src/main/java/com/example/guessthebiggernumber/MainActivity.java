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
    static int totalmarks=0;
    static int number1=0;
    static int number2=0;
    static int lives=5;
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
                showwrong();
            }
            generatenewnumber();
    }
    public void button2(View view) {
        if((button1==false)&&(button2==true)){
            showcongratulations();
        }
        else if((button1==true)&&(button2==false)){
            showwrong();
        }
        generatenewnumber();
    }

    private void showwrong() {
        lives=lives-1;
        if(lives!=0) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("sorry");
            alertDialog.setMessage("you are wrong.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
    private void showcongratulations() {
        totalmarks=totalmarks+1;
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
        TextView tried = this.findViewById(R.id.lives);
        TextView marks = this.findViewById(R.id.marks);

        tried.setText("your lives"+lives);
        marks.setText("your marks: "+totalmarks);

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

        if(lives==0){
            displaygameover();
            restart();
        }
    }

    private void restart() {
        totalmarks=0;
        number1=0;
        number2=0;
        lives=5;
        button1=false;
        button2=false;
        TextView firstnumber = this.findViewById(R.id.firstnumber);
        TextView secondnumber = this.findViewById(R.id.secondnumber);
        TextView tried = this.findViewById(R.id.lives);
        TextView marks = this.findViewById(R.id.marks);
        firstnumber.setText("FIRST NUMBER");
        secondnumber.setText("SECOND NUMBER");
        tried.setText("your lives: 5");
        marks.setText("your marks:");
    }

    private void displaygameover() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("game over");
        alertDialog.setMessage("your marks :"+totalmarks);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "play again",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


}
