package com.calendar.day09;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.sip.SipSession;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MessageDB messageDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //สร้างใว้บอกว่าจะใช้DATABASEแล้ว MessageDB ก้มาจาก
        // file MessageDB.java
        /*ใส่finalให้เป็นตัวสุดท้าย*/

        messageDB = Room.databaseBuilder(getApplicationContext(),
                MessageDB.class, "Message"/*ชื่อดาต้าเบส*/)
                .fallbackToDestructiveMigration().build();//
        //สร้างobject เพิ่ม แล้วย้ายcode เข้ามาข้างในนี้แทน
//        new AsyncTask<Void, Void, MessageInfo>(){
//            @Override
//            protected MessageInfo doInBackground(Void... voids) {
//                //ตอนแรกมันอยู่ข้างนอก ย้ายมาข้างในแทน
//                MessageInfo messageInfo = new MessageInfo();
//                messageInfo.setText("Hello");
//                messageInfo.setTime(new Date().toString());
//
//                messageDB.getMessageInfoDAO().insert(messageInfo);
//                //ไอข้างล่างมันมีอยู่แล้วอ่ะ
//                return null;
//            }
//        }.execute();

        Button showMessageButton = findViewById(R.id.showMessage);
        showMessageButton.setOnClickListener(this);
        Button addMessageButtton = findViewById(R.id.addMessage);
        addMessageButtton.setOnClickListener(this);

        new AsyncTask<Void, Void, MessageInfo>(){
            @Override
            protected MessageInfo doInBackground(Void... voids) {
                MessageInfo messageInfo = new MessageInfo();
                messageInfo.setText("Hello");
                messageInfo.setTime(new Date().toString());
                messageDB.getMessageInfoDAO().insert(messageInfo);
                return null;
            }
        }.execute();
    }
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.showMessage) {

            List<MessageInfo> ms = MessageInfo.getText;
            new AsyncTask<Void, Void, List<MessageInfo>>(){
                @Override
                protected List<MessageInfo> doInBackground(Void... voids) {
                    List<MessageInfo> result = messageDB.getMessageInfoDAO().getallText();
                    return result;
                }
                @Override
                protected void onPostExecute(List<MessageInfo> messageInfos){
                    ArrayAdapter<MessageInfo> adapter = new ArrayAdapter<MessageInfo>(MainActivity.this
                            ,android.R.layout.simple_list_item_1, messageInfos);

                    ListView messageInfoList = findViewById(R.id.massgetlist);
                    messageInfoList.setAdapter(adapter);
                }
            }.execute();
        } else if (view.getId() == R.id.addMessage) {
            new AsyncTask<Void, Void, MessageInfo>(){
                @Override
                protected MessageInfo doInBackground(Void... voids) {
                    //ตอนแรกมันอยู่ข้างนอก ย้ายมาข้างในแทน
                    MessageInfo messageInfo = new MessageInfo();
                    messageInfo.setText("hi");
                    messageInfo.setTime(new Date().toString());

                    messageDB.getMessageInfoDAO().insert(messageInfo);
                    //ไอข้างล่างมันมีอยู่แล้วอ่ะ
                    return null;
                }
            }.execute();
        }




    }
}

