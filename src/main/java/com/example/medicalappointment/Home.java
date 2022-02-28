package com.example.medicalappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;


public class Home extends AppCompatActivity {
   Button back;
    ImageButton a1,a2,a3;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        back =(Button)findViewById(R.id.btnback);

        a2 =(ImageButton)findViewById(R.id.btnlist);
        a3 =(ImageButton)findViewById(R.id.btnadd);

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), AppointmentList.class);
                startActivity(intent);
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), AddAppointment.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),Menu.class);
                startActivity(intent);
            }
        });
    }
}