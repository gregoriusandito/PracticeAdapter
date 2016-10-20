package com.insiteprojectid.practiceadapter;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.insiteprojectid.practiceadapter.user.StaticStudent;
import com.insiteprojectid.practiceadapter.user.Student;

public class AddStudentActivity extends AppCompatActivity {

    private EditText idText;
    private EditText nameText;
    private EditText noregText;
    private EditText phoneText;
    private EditText mailText;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        idText = (EditText) findViewById(R.id.new_id);
        nameText = (EditText) findViewById(R.id.new_nama);
        noregText = (EditText) findViewById(R.id.new_noreg);
        phoneText = (EditText) findViewById(R.id.new_phone);
        mailText = (EditText) findViewById(R.id.new_email);

        FloatingActionButton fabDone = (FloatingActionButton) findViewById(R.id.fabDone);
        FloatingActionButton fabCancel = (FloatingActionButton) findViewById(R.id.fabCancel);


        fabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //release the krakens for saving new data
                saveNewData();
            }
        });
        fabCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //close activity
                finish();            }
        });

    }

    protected void saveNewData(){
        int id = Integer.parseInt(idText.getText().toString());
        String noreg = noregText.getText().toString();
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        String mail = mailText.getText().toString();
        student = new Student(id, noreg, name, mail, phone);
        StaticStudent staticStudent = StaticStudent.getInstance();
        staticStudent.addStudent(student);
        Toast success = Toast.makeText(getApplicationContext(), "New Student Data Added", Toast.LENGTH_SHORT);
        success.show();
        finish();
    }

}
