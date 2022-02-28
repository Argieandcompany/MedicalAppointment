package com.example.medicalappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class AddAppointment extends AppCompatActivity {

Button appoint,up,del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        final EditText edit_condition = findViewById(R.id.edit_condition);
        final EditText edit_name = findViewById(R.id.edit_name);
        final EditText edit_gender = findViewById(R.id.edit_gender);
        final EditText edit_birthday = findViewById(R.id.edit_birthday);
        final EditText edit_appoint = findViewById(R.id.edit_appoint);
        Button btn = findViewById(R.id.btn_submit);
        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(v->
        {
            Intent intent =new Intent(AddAppointment.this, AppointmentList.class);
            startActivity(intent);
        });



        DAOrecord dao =new DAOrecord();
        Record emp_edit = (Record)getIntent().getSerializableExtra("EDIT");
        if(emp_edit !=null)
        {
            btn.setText("UPDATE");
            edit_condition.setText(emp_edit.getCondition());
            edit_name.setText(emp_edit.getName());
            edit_gender.setText(emp_edit.getGender());
            edit_birthday.setText(emp_edit.getBirthday());
            edit_appoint.setText(emp_edit.getAppoint());
            btn_open.setVisibility(View.GONE);

        }
        else
        {
            btn.setText("SUBMIT");
            btn_open.setVisibility(View.VISIBLE);
        }
        btn.setOnClickListener(v->
        {
            Record emp = new Record(edit_condition.getText().toString(), edit_name.getText().toString(),edit_gender.getText().toString(), edit_birthday.getText().toString(),edit_appoint.getText().toString());
            if(emp_edit==null)
            {
                dao.add(emp).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
            else
            {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("condition", edit_condition.getText().toString());
                hashMap.put("name", edit_name.getText().toString());
                hashMap.put("gender", edit_gender.getText().toString());
                hashMap.put("birthday", edit_birthday.getText().toString());
                hashMap.put("appoint", edit_appoint.getText().toString());

                dao.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });


    }
}