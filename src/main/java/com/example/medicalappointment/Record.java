package com.example.medicalappointment;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Record implements Serializable
{


    @Exclude
    private String key;
    private String condition;
    private String name;
    private String gender;
    private String birthday;
    private String appoint;
    public Record(){}
    public Record(String condition, String name, String gender, String birthday, String appoint)
    {
        this.condition = condition;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.appoint = appoint;
    }

    public String getCondition()
    {
        return condition;
    }

    public void setCondition(String condition)
    {
        this.condition = condition;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;

    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getAppoint()
    {
        return appoint;
    }

    public void setAppoint(String appoint) {
        this.appoint = appoint;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
