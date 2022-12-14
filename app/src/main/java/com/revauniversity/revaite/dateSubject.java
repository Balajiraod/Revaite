package com.revauniversity.revaite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class dateSubject extends AppCompatActivity {

    Button dateButton,next_button;
    DatePickerDialog datePickerDialog;
    Spinner period_selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_subject);
        initDataPicker();
        dateButton = (Button) findViewById(R.id.datePickerButton);
        period_selection = (Spinner)findViewById(R.id.period_selection);
        dateButton.setText(getTodaysDate());
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.period, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        period_selection.setAdapter(adapter);
        next_button = (Button) findViewById(R.id.date_subject_next);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Real_Attendence.class));
                finish();
            }
        });

    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDataPicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return  "JAN";
        if(month == 2)
            return  "FEB";
        if(month == 3)
            return  "MAR";
        if(month == 4)
            return  "APR";
        if(month == 5)
            return  "MAY";
        if(month == 6)
            return  "JUN";
        if(month == 7)
            return  "JUL";
        if(month == 8)
            return  "AUG";
        if(month == 9)
            return  "SEP";
        if(month == 10)
            return  "OCT";
        if(month == 11)
            return  "NOV";
        if(month == 12)
            return  "DEC";
        //default value
        return "JAN";

    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}