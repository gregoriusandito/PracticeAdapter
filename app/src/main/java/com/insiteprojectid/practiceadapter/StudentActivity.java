package com.insiteprojectid.practiceadapter;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.insiteprojectid.practiceadapter.adapter.CustomUsersAdapter;
import com.insiteprojectid.practiceadapter.user.StaticStudent;
import com.insiteprojectid.practiceadapter.user.Student;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    private ListView lv;
    private CustomUsersAdapter customUsersAdapter;
    private TextView emptyTextView;
    private StaticStudent staticStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        lv = (ListView)findViewById(R.id.listView);
        emptyTextView = (TextView)findViewById(R.id.emptyView);
        lv.setEmptyView(emptyTextView);
        staticStudent = StaticStudent.getInstance();

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fabButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddStudentActivity.class);
                startActivity(intent);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditStudentActivity.class);
                Student student = staticStudent.get(position);
                intent.putExtra("StudentList", student);
                startActivity(intent);
            }
        });
    }

    private void populateStudentDummies() {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "3135136188", "TRI FEBRIANA SIAMI", "tri.febriana@unj.ac.id", "021577888"));
        studentList.add(new Student(2, "3135136192", "UMMU KULTSUM", "ummu.kultsum@unj.ac.id", "021577888"));
        studentList.add(new Student(3, "3135136215", "ANDREAN OKTAVIANUS H.S.", "andrean.ohs@unj.ac.id", "021577888"));
        staticStudent.AddStudents(studentList);
        customUsersAdapter = new CustomUsersAdapter(this,staticStudent.getList());
        lv.setAdapter(customUsersAdapter);
    }

    @Override
    protected void onResume() {
        //overriding method to handle list
        super.onResume();
        if(staticStudent.count()==0) {
            customUsersAdapter = new CustomUsersAdapter(this, new ArrayList<Student>());
            emptyTextView.setText("No Student Found");
        } else{
            customUsersAdapter = new CustomUsersAdapter(this, staticStudent.getList());
        }
        lv.setAdapter(customUsersAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.createDummy:
                populateStudentDummies();
                return true;
            case R.id.clearList:
                StaticStudent.getInstance().clearList();
                customUsersAdapter = new CustomUsersAdapter(this, new ArrayList<Student>());
                lv.setAdapter(customUsersAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
