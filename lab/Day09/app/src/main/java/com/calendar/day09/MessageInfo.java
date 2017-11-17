package com.calendar.day09;

/**
 * สร้างแบบออโต้ จากหน้าMessageDB /boom
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity()
class MessageInfo {
    //Room จะบังคับให้มี Primaru key 1 อัน
    @PrimaryKey(autoGenerate = true)//ให้มันออโต้เจ็น
    private int id;
    //ใส่@ColumnInfo ลงไปสองอันก่อน
    @ColumnInfo(name = "Text")
    private String text;
    @ColumnInfo(name = "Time")
    private String time;

    @Override
    public String toString(){
        return String.format("%s :: %s", text, time);
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
