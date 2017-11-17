package com.calendar.day09;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import java.util.List;

/**
 * uto gen from MessageDB.java /boom
 */
@Dao
public interface MessageInfoDAO {
    @Insert
    void insert(MessageInfo message);
    @Query("SELECT * FROM MessageInfo")
    List<MessageInfo> getAll();
    @Query("SELECT Text FROM MessageInfo")
    public List<MessageInfo> getallText();


}
