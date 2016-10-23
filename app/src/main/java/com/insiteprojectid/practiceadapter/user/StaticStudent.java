package com.insiteprojectid.practiceadapter.user;

import java.util.ArrayList;

/**
 * Created by Gregorius Andito on 10/20/2016.
 */
public class StaticStudent {
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(ArrayList<Student> studentList) {
        StaticStudent.studentList = studentList;
    }



}
