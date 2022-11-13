package com.revauniversity.revaite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

public class Administrator extends AppCompatActivity {

    Button add_rmv_student, createAttendence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);


        Button add_rmv_student = (Button) findViewById(R.id.add_rmv_std);
        Button createAttendence = (Button) findViewById(R.id.create_attendence);

        add_rmv_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),add_rmv_student.class));
                finish();
            }
        });

        createAttendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),dateSubject.class));
                finish();
            }
        });
    }
}