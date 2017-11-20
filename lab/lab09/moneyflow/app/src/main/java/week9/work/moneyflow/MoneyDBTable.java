package week9.work.moneyflow;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MoneyInfo.class}, version = 1)
public abstract class MoneyDBTable extends RoomDatabase {
    public abstract MoneyDAO getMoneyDAO();
}
