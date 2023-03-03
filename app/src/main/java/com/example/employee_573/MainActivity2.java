package com.example.employee_573;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt1 = findViewById(R.id.textViewName);
        txt2 = findViewById(R.id.textViewEmail);
        txt3 = findViewById(R.id.textViewDate);
        txt4 = findViewById(R.id.textViewPhone);
        txt5 = findViewById(R.id.textViewQualification);
        txt6 = findViewById(R.id.textViewGender);

        Intent intent =getIntent();

        String name = intent.getStringExtra("Name :");
        String email = intent.getStringExtra("Email :");
        String date = intent.getStringExtra("Date : ");
        String phno = intent.getStringExtra("Phone : ");
        String quali = intent.getStringExtra("Qualification : ");
        String gender = intent.getStringExtra("Gender : ");

        txt1.setText(name);
        txt2.setText(email);
        txt3.setText(date);
        txt4.setText(phno);
        txt5.setText(quali);
        txt6.setText(gender);

    }
}