package week9.work.moneyflow;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
interface MoneyDAO {

    @Query("SELECT * FROM MoneyInfo")
    List<MoneyInfo> getAll();

    @Insert
    void insert(MoneyInfo moneyInfo);

    @Delete
    void delete(MoneyInfo moneyInfo);

    @Update
    void update(MoneyInfo moneyInfo);


}