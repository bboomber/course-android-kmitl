package com.calendar.day09;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

/**
 * build after set component /boom
 * comeback to edit it
 */
@Database(entities = {MessageInfo.class}, version = 1)
//พิมอันนี้ต่อจากเใส่extends และออโต้โค้ดแล้ว MessageInfo คือชื่อตาราง
// มันจะแดงให้ไปสร้างclassใหม่ แบบกดออโต้ไปเลย
public abstract class MessageDB extends RoomDatabase{
    public abstract MessageInfoDAO getMessageInfoDAO();

/* ลบทิ้งไปเลบ    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

*/
}
