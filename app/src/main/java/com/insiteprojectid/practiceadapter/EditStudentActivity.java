package com.insiteprojectid.practiceadapter;

import android.os.Bundle;
import android.os.Parcel;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.insiteprojectid.practiceadapter.user.StaticStudent;
import com.insiteprojectid.practiceadapter.user.Student;

import java.util.zip.Inflater;

public class EditStudentActivity extends AppCompatActivity {

    private EditText idText;
    private EditText nameText;
    private EditText noregText;
    private EditText phoneText;
    private EditText mailText;
    private Student student;

    private StaticStudent staticStudent = new StaticStudent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idText = (EditText) findViewById(R.id.edit_id);
        nameText = (EditText) findViewById(R.id.edit_nama);
        noregText = (EditText) findViewById(R.id.edit_nim);
        phoneText = (EditText) findViewById(R.id.edit_phone);
        mailText = (EditText) findViewById(R.id.edit_email);

        //get parcel
        Student object = getIntent().getParcelableExtra("StudentList");
        //implements parcel
        idText.setText("" + object.getId());
        nameText.setText(object.getName());
        noregText.setText(object.getNoreg());
        phoneText.setText(object.getPhone());
        mailText.setText(object.getMail());

        FloatingActionButton fabDone = (FloatingActionButton) findViewById(R.id.fabDone);
        FloatingActionButton fabCancel = (FloatingActionButton) findViewById(R.id.fabCancel);

        fabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //release the krakens
                saveEditedData();
            }
        });
        fabCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //close activity
                finish();
            }
        });

    }

    protected void saveEditedData(){
        int id = Integer.parseInt(idText.getText().toString());
        String noreg = noregText.getText().toString();
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        String mail = mailText.getText().toString();
        student = new Student(id, noreg, name, mail, phone);
        staticStudent.studentList.set(id, student);
        Toast success = Toast.makeText(getApplicationContext(), "Edit Success", Toast.LENGTH_SHORT);
        success.show();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.deleteItem:
//                int id = student.getId();
                Student object = getIntent().getParcelableExtra("StudentList");
                int id = object.getId();
                staticStudent.studentList.remove(id);
                //call resetIncrementID when deleting data
                resetIncrementId(id);
                finish();
                return true;
        }
        return false;
    }


    public void resetIncrementId(int i){
        for (int a = i; a < staticStudent.studentList.size(); a++) {
            staticStudent.studentList.get(a).setId(a);
        }
    }

}
