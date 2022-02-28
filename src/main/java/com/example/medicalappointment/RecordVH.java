package com.example.medicalappointment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordVH extends RecyclerView.ViewHolder
{
    public TextView txt_condition,txt_name,txt_gender,txt_birthday,txt_appoint,txt_option;
    public RecordVH(@NonNull View itemView)
    {


        super(itemView);
        txt_condition = itemView.findViewById(R.id.txt_condition);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_gender = itemView.findViewById(R.id.txt_gender);
        txt_birthday = itemView.findViewById(R.id.txt_birthday);
        txt_appoint = itemView.findViewById(R.id.txt_appoint);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}