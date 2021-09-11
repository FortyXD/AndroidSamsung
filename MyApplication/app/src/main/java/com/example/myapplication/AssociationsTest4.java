package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class AssociationsTest4 extends AppCompatActivity {

    public ArrayList<AsClass> a = new ArrayList<>();
    private Button button1;
    private Button button2;

    private Button Restart;
    private Button Go_To_Courses;

    public  int AllTemp;
    private Button next;
    private TextView CalkCor;
    private TextView TextView;
    public String TextQuestion;
    public String TextAnswer;
    public double Proces  = 0;
    public boolean Answer;
    public int Correct=0;
    public int All = 0;


    public Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associations_test4);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView =(TextView) findViewById(R.id.TextQuestion);
        button1 =(Button) findViewById(R.id.buttonVariant3);
        CalkCor = (TextView) findViewById(R.id.Corrected);
        button2 =(Button) findViewById(R.id.buttonVariant2);

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
                YES();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                No();
            }
        });




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);


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
        a.add(new AsClass("Primary School - Начальная школа", true , "Primary School - Начальная школа"));
        a.add(new AsClass("Tire - Шина", true,"Tire - Шина"));
        a.add(new AsClass("Angular - Угол", false,"Angular - Угловой"));
        a.add(new AsClass("Stuff - Предмет", false,"Stuff - Вещи"));
        a.add(new AsClass("Canvas - холст", true,"Canvas - холст"));
        a.add(new AsClass("Conversation - Переговоры", true,"Conversation - Переговоры"));
        a.add(new AsClass("Elections - Выборы", true, "Elections - Выборы"));
        a.add(new AsClass("Искусство - Archive", false,"Искусство - Art"));
        a.add(new AsClass("Craft - Ремесло", true,"Craft - Ремеслохх"));
        All= a.size();


    }
    public void ChangeQuestion(ArrayList<AsClass> a){
        int Number = rand.nextInt(a.size());
        TextQuestion = a.get(Number).Question;

        TextAnswer = a.get(Number).resultText;
        Answer = a.get(Number).result;
        a.remove(Number);


        TextView.setText(TextQuestion);

    }
    public void YES(){
        if (true == Answer){Corrected();}
        else {Uncorrected();}
    }
    public void No(){
        if (false == Answer){Corrected();}
        else {Uncorrected();}
    }
    public void Corrected(){
        TextQuestion = "Corect";
//Убираем кнопки покаываем далее
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);


        TextView.setText(TextQuestion);
        Correct++;

        CalkCor.setText(Correct +"/"+(All+1));
        next.setVisibility(View.VISIBLE);
    }
    public void Uncorrected(){
        TextQuestion = "Uncorrected. Right answer is - "+TextAnswer;
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);


        TextView.setText(TextQuestion);

        next.setVisibility(View.VISIBLE);

        CalkCor.setText(Correct +"/"+(All+1));
    }
    public void openCourses(){
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);


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
        Intent intent1 = new Intent(this, Courses.class);
        startActivity(intent1);
    }
}




