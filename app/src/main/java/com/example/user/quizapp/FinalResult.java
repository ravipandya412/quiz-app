package com.example.user.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalResult extends Activity {
    final Context context = this;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        result = (TextView)findViewById(R.id.result_label);
       // finalresult = (TextView)findViewById(R.id.final_result);
        result.setText("Your Score is :"+String.valueOf(Cnst.rightanswer));

        if(Cnst.rightanswer == 0 || Cnst.rightanswer == 1 || Cnst.rightanswer == 2){
            //finalresult.setText("Your Score is too Low");
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);;
            alertDialogBuilder.setTitle("QuizApp");
            alertDialogBuilder
                    .setMessage("PLAY AGAIN!! Your Score is too low.")
                    .setCancelable(false)
                    .setIcon(R.drawable.quiz)
                    .setPositiveButton("PLAY AGAIN",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            Cnst.rightanswer=0;
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                             startActivity(i);
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

         if(Cnst.rightanswer == 3 ){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("QuizApp");
            alertDialogBuilder
                    .setMessage("GOOD JOB! Do you want to try again?")
                    .setCancelable(false)
                    .setIcon(R.drawable.quiz)
                    .setPositiveButton("PLAY AGAIN",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            Cnst.rightanswer=0;
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);


                        }
                    })
                    .setNegativeButton("QUIT",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            finishAffinity();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

          if( Cnst.rightanswer == 4 ){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("QuizApp");
            alertDialogBuilder
                    .setMessage("EXCELLENT WORK! Do you want to try again?")
                    .setCancelable(false)
                    .setIcon(R.drawable.quiz)
                    .setPositiveButton("PLAY AGAIN",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            Cnst.rightanswer=0;
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);

                        }
                    })
                    .setNegativeButton("QUIT",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            finishAffinity();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

         if(Cnst.rightanswer == 5){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("QuizApp");
            alertDialogBuilder
                    .setMessage("YOU ARE GENIUS! Do you want to  try again?")
                    .setCancelable(false)
                    .setIcon(R.drawable.quiz)
                    .setPositiveButton("PLAY AGAIN",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            Cnst.rightanswer=0;
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);

                        }
                    })
                    .setNegativeButton("QUIT",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            finishAffinity();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }


    }

}


