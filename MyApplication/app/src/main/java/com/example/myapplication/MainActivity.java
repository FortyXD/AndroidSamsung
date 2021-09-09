package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    button1 =(Button) findViewById(R.id.button);
    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openActivity2();
        }
    });
}
public void openActivity2(){
        Intent intent = new Intent(this,Courses.class);
        startActivity(intent);

}

}