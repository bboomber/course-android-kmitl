package week9.work.moneyflow;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class MoneyInfo {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "saving")
    public int saving;

    public String toString(){
        return String.format("%s   %s   %s",type, name, saving);
    }

    public int getSaving() {
        return saving;
    }
    public void setSaving(int saving) {
        this.saving = saving;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}