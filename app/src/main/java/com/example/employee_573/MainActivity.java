package com.example.employee_573;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText editText,edtname,edtemail,edtphn ; //For Displaying Date
    RadioGroup radioGroup1,radioGroup2;
    RadioButton rdbtn1,rdbtn2,rdbtn3,rdbtn4,rdbtn5;
    String[] items = {"Employee","Clerk","Assistant","Manager","Designer","Developer","Marketer","Executive"};
    Spinner spinner;
    CheckBox checkBox;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdbtn1 = findViewById(R.id.BCA);
        rdbtn2 = findViewById(R.id.BBA);
        rdbtn3 = findViewById(R.id.BCOM);

        rdbtn4=findViewById(R.id.MALE);
        rdbtn5=findViewById(R.id.FEMALE);

        spinner = findViewById(R.id.spinner1);
        edtname = findViewById(R.id.editTextTextPersonName);
        edtemail = findViewById(R.id.editTextTextEmailAddress);
        edtphn = findViewById(R.id.editTextPhone);
        editText = findViewById(R.id.editTextDate);
        btn=findViewById(R.id.button);
        radioGroup1 = findViewById(R.id.rdgrpQUALIFICATION);
        radioGroup2 = findViewById(R.id.rdgrpGENDER);
        checkBox = findViewById(R.id.checkBox);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validationdata()){

                    String name = edtname.getText().toString();
                    String email = edtemail.getText().toString();
                    String date = editText.getText().toString();
                    String phno = edtphn.getText().toString();

                    RadioGroup rdgrp1 = (RadioGroup) findViewById(R.id.rdgrpQUALIFICATION);
                    String selectedvalue1 = ((RadioButton)findViewById(rdgrp1.getCheckedRadioButtonId())).getText().toString();
                    RadioGroup rdgrp2 = (RadioGroup) findViewById(R.id.rdgrpGENDER);
                    String selectedvalue2 = ((RadioButton)findViewById(rdgrp2.getCheckedRadioButtonId())).getText().toString();


                    Intent intent1 = new Intent(getApplicationContext(), MainActivity2.class);

                    intent1.putExtra("Name :", name);
                    intent1.putExtra("Email :",email);
                    intent1.putExtra("Date : ",date);
                    intent1.putExtra("Phone : ",phno);
                    intent1.putExtra("Qualification : ",selectedvalue1);
                    intent1.putExtra("Gender : ",selectedvalue2);

                    startActivity(intent1);

            }
            }
        });
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,items);
        spin.setAdapter(arrayAdapter);

        editText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year=Calendar.YEAR;
                int month=Calendar.MONTH;
                int day=Calendar.DAY_OF_MONTH;

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        editText.setText(day+"/"+(month+1)+"/"+year);
                    }
                },
                        year,month,day);
                datePickerDialog.show();
                return true ;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this, "Selected Designation : "+items[i], Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void mytoast(String mess){
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
    }
    private boolean validationdata(){
        if(edtname.getText().toString().isEmpty()){
            mytoast("Please Enter Name !");
            return false;
        }
        else if (edtemail.getText().toString().isEmpty()){
            mytoast("Please Enter Email !");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(edtemail.getText().toString()).matches()){
            mytoast("Please Enter Valid Format Of Email !");
            return false;
        }
        else if (editText.getText().toString().isEmpty()){
            mytoast("Please Enter Date !");
            return false;
        }
        else  if(edtphn.getText().toString().isEmpty()){
            mytoast("Please Enter Phone No. !");
            return false;
        }
        else if(!Patterns.PHONE.matcher(edtphn.getText().toString()).matches()) {
            mytoast("Please Enter Valid Phone Number !");
            return false;
        }
        else if (!checkBox.isChecked()) {
            Toast.makeText(MainActivity.this, "Accepted", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!checkBox.isChecked()){
            Toast.makeText(MainActivity.this, "Please Accept Terms & Conditions !", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
