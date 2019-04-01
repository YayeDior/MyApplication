package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
private ImageView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void toto(View view) {
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}
