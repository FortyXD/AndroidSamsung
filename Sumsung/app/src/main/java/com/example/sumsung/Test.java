package com.example.sumsung;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;


public class Test extends AppCompatActivity {

    public static final String SHARED = "dasd";
    public static final String Text = "text";


    public ArrayList<QuestionClass> a = new ArrayList<>();
    private Button button1;
    private Button button2;
    private Button button3;
    private Button Restart;
    private Button Go_To_Courses;

    public  int AllTemp;
    private Button next;
    private TextView CalkCor;
    private TextView TextView;
    public String TextQuestion;
    public String TextVariant1;
    public String TextVariant2;
    public String TextVariant3;
    public double Proces  = 0;
    public String Answer;
    public int Correct=0;
    public int All = 0;


    public Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView =(TextView) findViewById(R.id.TextQuestion);
        button1 =(Button) findViewById(R.id.buttonVariant);
        CalkCor = (TextView) findViewById(R.id.Corrected);
        button2 =(Button) findViewById(R.id.buttonVariant2);
        button3 =(Button) findViewById(R.id.buttonVariant3);
        Restart =(Button) findViewById(R.id.button6);
        Go_To_Courses =(Button) findViewById(R.id.button5);


        next =(Button) findViewById(R.id.next);

        listmarks();




        ChangeQuestion(a);
        CalkCor.setText("0/"+(a.size()+1));
        AllTemp = a.size();
        All= a.size();



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


    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);

            next.setVisibility(View.GONE);
            if (a.size() == 0){
              Proces = Correct/All;

                openCourses();
            }
            else {
                ChangeQuestion(a);
            }
        Proces = Correct/All*100;


        }
    });
    Restart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           SetRestart();
        }
    });
    Go_To_Courses.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SetCourses();
        }
    });
    }

    private void listmarks() {
        a.add(new QuestionClass("I usually get up at 6 a.m. but not___" , "never" , "always", "often","always"));
        a.add(new QuestionClass("I don’t___have money with me." , "some" , "any", "a","any"));
        a.add(new QuestionClass("My school is___than my sister’s." , "big " , "bigger", "more big","bigger "));
        a.add(new QuestionClass("Ten-year-old students___to university." , "go" , "don’t go", "doesn’t go","don’t go"));
        a.add(new QuestionClass("Where___to school?" , "your brother goes" , "does your brother go", "goes your brother","does your brother go"));
        a.add(new QuestionClass("Alejandro can___English very well." , "speak" , "to speak", "speaking","speak"));
        a.add(new QuestionClass("Sarah sings beautifully - I think she___a famous singer when she’s older." , "will be" , "will being ", "will","will be"));
        a.add(new QuestionClass("Katy___her mum in the kitchen now." , "‘s help" , "is helping", "helps","is helping"));
        a.add(new QuestionClass("Tom___late for school every day last week." , "is" , "were", "was","was"));
        All= a.size();


    }

    public void openCourses(){
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);

        if((double)Correct*100/(double) All >50){
            String ab = "Good job. You have "+Double.toString(Correct*100/(All+1))+"%. Well Done";
            TextView.setText(ab);
            Restart.setVisibility(View.VISIBLE);
            Go_To_Courses.setVisibility(View.VISIBLE);
        }
        else {
            String ab = "Sorry. You have "+Double.toString(Correct*100/(All+1))+"%. Maybe Restart?";
            TextView.setText(ab);
            Restart.setVisibility(View.VISIBLE);
            Go_To_Courses.setVisibility(View.VISIBLE);
        }


    }
    public void SetRestart(){
        Intent intent1 = new Intent(this, Test.class);
        startActivity(intent1);
    }
    public void SetCourses(){
        Intent intent1 = new Intent(this, com.example.sumsung.Courses.class);
        startActivity(intent1);
    }

    public void Corrected(){
        TextQuestion = "Corect";
//Убираем кнопки покаываем далее
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);

        TextView.setText(TextQuestion);
        Correct++;

        CalkCor.setText(Correct +"/"+(All+1));
        next.setVisibility(View.VISIBLE);
    }
    public void Uncorrected(){
        TextQuestion = "Uncorrected. Right answer is - "+Answer;
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);

        TextView.setText(TextQuestion);

        next.setVisibility(View.VISIBLE);

        CalkCor.setText(Correct +"/"+(All+1));
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

        Answer = a.get(Number).Answer;
        a.remove(Number);

        button1.setText(TextVariant1);
        button2.setText(TextVariant2);
        button3.setText(TextVariant3);

        TextView.setText(TextQuestion);

    }



}

class QuestionClass{
    String Question;
    String Variant1;
    String Variant2;
    String Variant3;

    String Answer;
    public  QuestionClass(String Question,
            String Variant1,
            String Variant2,
            String Variant3,

            String Answer){
        this.Question = Question;
        this.Variant1 = Variant1;
        this.Variant2 = Variant2;
        this.Variant3 = Variant3;

        this.Answer = Answer;


    }

}