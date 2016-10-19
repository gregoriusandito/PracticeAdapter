package com.insiteprojectid.practiceadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.insiteprojectid.practiceadapter.user.Student;

import java.util.ArrayList;

/**
 * Created by Gregorius Andito on 10/7/2016.
 */
public class CustomUsersAdapter extends ArrayAdapter<Student> {
    public CustomUsersAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);
        }

        TextView no = (TextView)convertView.findViewById(R.id.no);
        TextView noreg = (TextView)convertView.findViewById(R.id.noreg);
        TextView nama = (TextView)convertView.findViewById(R.id.nama);
        TextView email = (TextView)convertView.findViewById(R.id.email);
        TextView noHp = (TextView)convertView.findViewById(R.id.noHp);

        no.setText(student.getId()+"");
        noreg.setText(student.getNoreg());
        nama.setText(student.getName());
        email.setText(student.getMail());
        noHp.setText(student.getPhone());

        return convertView;
    }
}