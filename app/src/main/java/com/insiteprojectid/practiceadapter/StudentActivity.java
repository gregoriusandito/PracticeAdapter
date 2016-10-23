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
    ArrayList<Student> studentList = new ArrayList<>();
    StaticStudent staticStudent = new StaticStudent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        lv = (ListView)findViewById(R.id.listView);
        emptyTextView = (TextView)findViewById(R.id.emptyView);
        lv.setEmptyView(emptyTextView);
        final StaticStudent staticStudent = new StaticStudent();

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
                Student student = staticStudent.studentList.get(position);
                intent.putExtra("StudentList", student);
                startActivity(intent);
            }
        });
    }

    private void populateStudentDummies() {
        int i = staticStudent.studentList.size();
        studentList.add(new Student(i, "3135136188", "TRI FEBRIANA SIAMI", "tri.febriana@unj.ac.id", "021577888"));
        studentList.add(new Student(i+1, "3135136192", "UMMU KULTSUM", "ummu.kultsum@unj.ac.id", "021577888"));
        studentList.add(new Student(i + 2, "3135136215", "ANDREAN OKTAVIANUS H.S.", "andrean.ohs@unj.ac.id", "021577888"));
        staticStudent.studentList.addAll(studentList);
        resetIncrementId(0);
        customUsersAdapter = new CustomUsersAdapter(this,staticStudent.getStudentList());
        lv.setAdapter(customUsersAdapter);
    }

    public void resetIncrementId(int i){
        for (int a = i; a < staticStudent.studentList.size(); a++) {
            staticStudent.studentList.get(a).setId(a);
        }
    }

    @Override
    protected void onResume() {
        //overriding method to handle list
        super.onResume();
        if(staticStudent.studentList.size()==0) {
            customUsersAdapter = new CustomUsersAdapter(this, new ArrayList<Student>());
            emptyTextView.setText("No Student Found");
        } else{
            customUsersAdapter = new CustomUsersAdapter(this, staticStudent.getStudentList());
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
                staticStudent.studentList.clear();
                customUsersAdapter = new CustomUsersAdapter(this, new ArrayList<Student>());
                lv.setAdapter(customUsersAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
