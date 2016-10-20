package com.insiteprojectid.practiceadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.insiteprojectid.practiceadapter.user.Student;

public class AddStudentActivity extends AppCompatActivity {

    private EditText idText;
    private EditText nameText;
    private EditText noregText;
    private EditText phoneText;
    private EditText mailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        idText = (EditText) findViewById(R.id.edit_id);
        nameText = (EditText) findViewById(R.id.edit_nama);
        noregText = (EditText) findViewById(R.id.edit_nim);
        phoneText = (EditText) findViewById(R.id.edit_phone);
        mailText = (EditText) findViewById(R.id.edit_email);

        Student object = getIntent().getParcelableExtra("StudentList");

        idText.setText("" + object.getId());
        nameText.setText(object.getName());
        noregText.setText(object.getNoreg());
        phoneText.setText(object.getPhone());
        mailText.setText(object.getMail());
    }
}
