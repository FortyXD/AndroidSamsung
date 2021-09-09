package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Test extends AppCompatActivity {

    public ArrayList<QuestionClass> a = new ArrayList<>();
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button next;
    private TextView CalkCor;
    private TextView TextView;
    public String TextQuestion;
    public String TextVariant1;
    public String TextVariant2;
    public String TextVariant3;
    public String TextVariant4;
    public String Answer;
    public int Correct=0;
    public int All = 0;


    public Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView =(TextView) findViewById(R.id.TextQuestion);
        button1 =(Button) findViewById(R.id.buttonVariant);
        CalkCor = (TextView) findViewById(R.id.Corrected);
        button2 =(Button) findViewById(R.id.buttonVariant2);
        button3 =(Button) findViewById(R.id.buttonVariant3);
        button4 =(Button) findViewById(R.id.buttonVariant4);
        next =(Button) findViewById(R.id.next);

        a.add(new QuestionClass("dad","dasdd","ddasd","dasasd","dasdasd","dasdasd"));
        a.add(new QuestionClass("dsd","hfgh","hfgh","hfghfgh","dasdasd","dasdasd"));
        ChangeQuestion(a);
        CalkCor.setText("0/0");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonChecker(button1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonChecker(button2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonChecker(button3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonChecker(button4);
            }
        });
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            next.setVisibility(View.GONE);
            if (a.size() == 0){
                openCourses();
            }
            else {
                ChangeQuestion(a);
            }


        }
    });
    }
    public void openCourses(){
        Intent intent = new Intent(this,Courses.class);
        startActivity(intent);

    }
    public void Corrected(){
        TextQuestion = "Corect";
//Убираем кнопки покаываем далее
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        TextView.setText(TextQuestion);
        Correct++;
        All++;
        CalkCor.setText(Correct +"/"+All);
        next.setVisibility(View.VISIBLE);
    }
    public void Uncorrected(){
        TextQuestion = "Uncorrected. Right answer is - "+Answer;
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        TextView.setText(TextQuestion);
        All++;
        next.setVisibility(View.VISIBLE);

        CalkCor.setText(Correct +"/"+All);
    }
    public void ButtonChecker(Button a){
        if(a.getText() == Answer){Corrected();
        }
        else {
            Uncorrected();}
    }
    public void ChangeQuestion(ArrayList <QuestionClass> a){
        int Number = rand.nextInt(a.size());
        TextQuestion = a.get(Number).Question;
        TextVariant1 = a.get(Number).Variant1;
        TextVariant2 = a.get(Number).Variant2;
        TextVariant3 = a.get(Number).Variant3;
        TextVariant4 = a.get(Number).Variant4;
        Answer = a.get(Number).Answer;
        a.remove(Number);

        button1.setText(TextVariant1);
        button2.setText(TextVariant2);
        button3.setText(TextVariant3);
        button4.setText(TextVariant4);
        TextView.setText(TextQuestion);

    }



}

class QuestionClass{
    String Question;
    String Variant1;
    String Variant2;
    String Variant3;
    String Variant4;
    String Answer;
    public  QuestionClass(String Question,
            String Variant1,
            String Variant2,
            String Variant3,
            String Variant4,
            String Answer){
        this.Question = Question;
        this.Variant1 = Variant1;
        this.Variant2 = Variant2;
        this.Variant3 = Variant3;
        this.Variant4 = Variant4;
        this.Answer = Answer;

    }
}