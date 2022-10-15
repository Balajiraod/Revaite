package com.revauniversity.revaite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class add_rmv_student extends AppCompatActivity {

    EditText srn, student_name, std_branch, std_semester, std_section, std_mail, std_password;
    Button add_student;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rmv_student);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        EditText srn = (EditText) findViewById(R.id.srn_no);
        EditText student_name = (EditText) findViewById(R.id.std_name);
        EditText std_branch = (EditText) findViewById(R.id.branch);
        EditText std_semester = (EditText) findViewById(R.id.semester);
        EditText std_section = (EditText) findViewById(R.id.section);
        EditText std_mail = (EditText) findViewById(R.id.std_mail_id);
        EditText std_password = (EditText) findViewById(R.id.std_pwd);
        Button add_student = (Button) findViewById(R.id.btn_add_std);

        add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fAuth.createUserWithEmailAndPassword(std_mail.getText().toString(), std_password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseUser user = fAuth.getCurrentUser();
                        Toast.makeText(add_rmv_student.this, "Account created sucessfully", Toast.LENGTH_SHORT).show();
                        DocumentReference df = fStore.collection("Users").document(user.getUid());
                        Map<String, Object> userInfo = new HashMap<>();
                        userInfo.put("SRN", srn.getText().toString());
                        userInfo.put("Student Name", student_name.getText().toString());
                        userInfo.put("Branch", std_branch.getText().toString());
                        userInfo.put("Semester", std_semester.getText().toString());
                        userInfo.put("Section", std_section.getText().toString());
                        userInfo.put("isUser", "1");
                        df.set(userInfo);
                        startActivity(new Intent(getApplicationContext(), Login.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(add_rmv_student.this, "Cannot able to create account", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), add_rmv_student.class));
                        finish();
                    }
                });
            }
        });
    }
}