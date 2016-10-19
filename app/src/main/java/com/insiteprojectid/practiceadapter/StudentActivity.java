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

import com.insiteprojectid.practiceadapter.user.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    private ListView lv;
    private CustomUsersAdapter customUsersAdapter;
    private TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        lv = (ListView)findViewById(R.id.listView);
//        ArrayList<Student> students = populateStudentDummies();
//        CustomUsersAdapter adapter = new CustomUsersAdapter(this, students);
        CustomUsersAdapter adapter = new CustomUsersAdapter(this, new ArrayList<Student>());
        lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(adapter);
        emptyTextView = (TextView)findViewById(R.id.emptyView);
        lv.setEmptyView(emptyTextView);
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
//                Student student =
            }
        });
    }

    private ArrayList<Student> populateStudentDummies() {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "3135136188", "TRI FEBRIANA SIAMI", "tri.febriana@unj.ac.id", "021577888"));
        studentList.add(new Student(2, "3135136192", "UMMU KULTSUM", "ummu.kultsum@unj.ac.id", "021577888"));
        studentList.add(new Student(3, "3135136215", "ANDREAN OKTAVIANUS H.S.", "andrean.ohs@unj.ac.id", "021577888"));
        return studentList;
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
                ArrayList<Student> students = populateStudentDummies();
                CustomUsersAdapter adapter = new CustomUsersAdapter(this, students);
                lv = (ListView)findViewById(R.id.listView);
                lv.setAdapter(adapter);
                return true;
            case R.id.clearList:
                CustomUsersAdapter clearAdapter = new CustomUsersAdapter(this, new ArrayList<Student>());
                lv = (ListView)findViewById(R.id.listView);
                lv.setAdapter(clearAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
