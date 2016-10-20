package com.insiteprojectid.practiceadapter.user;

import com.insiteprojectid.practiceadapter.CustomUsersAdapter;

import java.util.ArrayList;

/**
 * Created by Gregorius Andito on 10/20/2016.
 */
public class StaticStudent {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static StaticStudent instance = new StaticStudent();

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(ArrayList<Student> studentList) {
        StaticStudent.studentList = studentList;
    }

    public static StaticStudent getInstance() {
        return instance;
    }

    public static void setInstance(StaticStudent instance) {
        StaticStudent.instance = instance;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public Student get(int index){
        Student student = studentList.get(index);
        return student;
    }

    public void set(int index, Student student){
        studentList.set(index, student);
    }

    public Student remove(int index){
        Student student = studentList.remove(index);
        return student;
    }

    public void AddStudents(ArrayList<Student> students){
        studentList.addAll(students);
    }

    public ArrayList<Student> getList(){
        return studentList;
    }

    public int count(){
        return studentList.size();
    }

    public void clearList(){
        studentList.clear();
    }

}
