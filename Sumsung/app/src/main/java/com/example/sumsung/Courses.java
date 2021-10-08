package com.example.sumsung;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Courses extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        button1 =(Button) findViewById(R.id.button);
        button2 =(Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Assotiation();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test3();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test4();
            }
        });
    }
    public void TestActivity(){
        Intent intent = new Intent(this,Test.class);
        startActivity(intent);

    }
    public void Assotiation(){

        Intent intent1 = new Intent(this,Test2Associations.class);
        startActivity(intent1);

    }
    public void Test3(){

        Intent intent1 = new Intent(this,TextQuestion3.class);
        startActivity(intent1);

    }
    public void Test4(){

        Intent intent1 = new Intent(this,AssociationsTest4.class);
        startActivity(intent1);

    }

}
