package week9.work.moneyflow;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MoneyDBTable moneyDBTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showtransection();


    }

    public void showtransection(){
        moneyDBTable = Room.databaseBuilder(getApplicationContext(),
                MoneyDBTable.class, "MoneyInfo")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        List<MoneyInfo> result = moneyDBTable.getMoneyDAO().getAll();
        ArrayAdapter<MoneyInfo> adaptor = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, result);

        ListView messageInfoList = findViewById(R.id.messageList);
        messageInfoList.setAdapter(adaptor);

    }

    public void delBtn(View view){

    }
    public void addInfo(View view) {
        Intent intent = new Intent(MainActivity.this, AddTransection.class);
        startActivity(intent);
        showtransection();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showtransection();
    }
}