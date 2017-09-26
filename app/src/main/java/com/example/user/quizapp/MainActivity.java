package com.example.user.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    TextView ques,quenum,score;
    Button b1,b2,b3,b4;
    ArrayList<Question> questionlist = new ArrayList<>();
    ArrayList<Question> final_question_list = new ArrayList<>();
    Set<Integer> generated = new LinkedHashSet<Integer>();
    Question q;
    int count = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setLogo(R.drawable.quiz);
        actionbar.setDisplayUseLogoEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);
        quenum = (TextView)findViewById(R.id.quenum_label);
        ques = (TextView)findViewById(R.id.que_label);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/efg.ttf");
        ques.setTypeface(custom_font);
        score = (TextView)findViewById(R.id.score_label);
        b1 = (Button)findViewById(R.id.option_1);
        b2 = (Button)findViewById(R.id.option_2);
        b3 = (Button)findViewById(R.id.option_3);
        b4 = (Button)findViewById(R.id.option_4);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.xyz);
        Cnst.rightanswer = 0;
        questionlist.add(new Question("Question:1","Who is PrimeMinister Of India?","Narendra Modi","Barack Obama","Navaj Sharif","Donald Trump","Narendra Modi"));
        questionlist.add(new Question("Question:2"," Who is Founder Of Facebook?","Mark Zukenberg", "Tim Cook", "Steve Jobs", "Narayan Murti","Mark Zukenberg"));
        questionlist.add(new Question("Question:3"," Who was founder of Google ? ","Mark Zukenberg ", "Larry Page", "Steve Jobs ", "Sunder Pichai","Larry Page"));
        questionlist.add(new Question("Question:4"," Which is Capital Of Russia??","Moscow", "Peris", "London", "Colombo","Moscow"));
        questionlist.add(new Question("Question:5","In Which City,Taj Mahel is Located?","Agra", "Kanpur", "Bombay", "Chennai","Agra"));
        questionlist.add(new Question("Question:6","The great Victoria Desert is located in","Canada","India","Australia","USA","Australia"));
        questionlist.add(new Question("Question:7","B. C. Roy Award is given in the field of","Medical","Environment","Maths","Physics","Medical"));
        questionlist.add(new Question("Question:8","Who is the first Asian Winner of Nobel Prize?","Mahatma Gandhi","Nelson Mandela","Rabindranath Tagore","Sardar Patel","Rabindranath Tagore"));
        questionlist.add(new Question("Question:9","Who is the author of the book 'Nineteen Eighty Four'?","Thomas Hardy","Emile Zola","George Orwel","Walter Scott","George Orwel"));
        questionlist.add(new Question("Question:10","In which year was Pulitzer Prize established?","1917","1919","1934","1950","1917"));
        setFinalQuetionList();
        setQuiz(count);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = b1.getText().toString();
                matchAns(count,ans);
                b1.setEnabled(false);
                mp.start();
                next();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = b2.getText().toString();
                matchAns(count,ans);
                b2.setEnabled(false);
                mp.start();
                next();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = b3.getText().toString();
                matchAns(count,ans);
                b3.setEnabled(false);
                mp.start();
                next();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = b4.getText().toString();
                matchAns(count,ans);
                b4.setEnabled(false);
                mp.start();
                next();
            }
        });
           }

    private void setFinalQuetionList() {
        for (int i = 0; i <10 ; i++) {
            int n = ThreadLocalRandom.current().nextInt(0, 10);
            generated.add(n);
        }

        for (int i = 0; i < 5; i++) {
            final_question_list.add(questionlist.get((Integer) generated.toArray()[i]));
        }
    }

    public void next(){
        reset();
        if (count < 4) {
            count++;
            setQuiz(count);
        }else {
            Intent i = new Intent(MainActivity.this, FinalResult.class);
            startActivity(i);
        }
        score.setText("Score :"+String.valueOf(Cnst.rightanswer));
    }

    public void reset(){
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
    }
    public void setQuiz(int position){
        Question que =final_question_list.get(position);
        quenum.setText("Question: "+String.valueOf(count+1));
        ques.setText(que.getQue());
        b1.setText(que.getOption1());
        b2.setText(que.getOption2());
        b3.setText(que.getOption3());
        b4.setText(que.getOption4());
    }

    public void matchAns(int position, String ans){
        Question que = final_question_list.get(position);
        if (ans.equalsIgnoreCase(que.getRightanswer())){
            Cnst.rightanswer++;
        }
    }
}
