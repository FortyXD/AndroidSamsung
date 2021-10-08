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

public class TextQuestion3 extends AppCompatActivity {

    public static final String SHARED = "dasd";
    public static final String Text = "text";


    public ArrayList<com.example.sumsung.QuestionClass> a = new ArrayList<>();
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
        setContentView(R.layout.activity_text_question3);
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

        a.add(new QuestionClass("Why___to England next month?" , "does John go" , "will John go", "is John going","is John going"));
        a.add(new QuestionClass("I___Star Wars." , "have never seen" , "didn’t ever see", "never seen","have never seen"));
        a.add(new QuestionClass("___your keys?" , "Have you found" , "Have you find", "You have find","Have you found"));
        a.add(new QuestionClass("The TV show___an hour ago." , "it ended" , "has ended", "ended","ended"));
        a.add(new QuestionClass("You___eat a lot of sweets - they’re not good for you." , "couldn’t" , "shouldn’t", "wouldn’t","shouldn’t"));
        a.add(new QuestionClass("Tom___his homework yet" , "has finished" , "are still finishing", "hasn’t finished","hasn’t finished"));
        a.add(new QuestionClass("You___use the lift when there is a fire alarm" , "don’t have to" , "mustn’t", "haven’t to","mustn’t"));
        a.add(new QuestionClass("Dan hasn’t spoken to me___he got home." , "for" , "yet", "since","since"));
        a.add(new QuestionClass("This is the most interesting book I___" , "‘ve ever read" , "ever have read", "‘ve never read","‘ve ever read"));
        a.add(new QuestionClass("My brother___hasn’t learnt to ride a bike." , "already" , "still", "yet","still"));
        a.add(new QuestionClass("If I knew the answer, I___you." , "would tell" , "will tell", "will to tell","would tell"));
        a.add(new QuestionClass("If you___me, what would you do in this situation?" , "were" , "would be", "will be","were"));
        a.add(new QuestionClass("This building___very well, I think." , "designed" , "designs", "is designed","is designed"));
        a.add(new QuestionClass("My sister’s___having problems with her computer" , "a few" , "much", "a little","a few"));
        a.add(new QuestionClass("Milly and Richard___probably be tired after their long journey." , "may" , "will", "might","will"));
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
        Intent intent1 = new Intent(this, com.example.sumsung.Test.class);
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
    public void ChangeQuestion(ArrayList<com.example.sumsung.QuestionClass> a){
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


