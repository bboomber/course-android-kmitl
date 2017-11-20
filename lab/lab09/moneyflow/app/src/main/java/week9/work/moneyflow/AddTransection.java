package week9.work.moneyflow;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddTransection extends AppCompatActivity {

    private int check = 0;
    public String type = "Income";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transection);
    }


    public void onIncome(View view) {
        type = "Income";

    }

    public void onExpense(View view) {
        type = "expenses";
    }

    public void onSubmit(View view) {
        final EditText desc = findViewById(R.id.description);
        EditText money = findViewById(R.id.amountMoney);

        final String trans = desc.getText().toString();
        final int amountMoney = Integer.parseInt(money.getText().toString());
        MoneyDBTable moneyDBTable = Room.databaseBuilder(getApplicationContext(),MoneyDBTable.class, "MoneyInfo")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        MoneyInfo moneyInfo = new MoneyInfo();
        moneyInfo.setType(type);
        moneyInfo.setName(trans);
        moneyInfo.setSaving(amountMoney);

        moneyDBTable.getMoneyDAO().insert(moneyInfo);

        finish();

    }
}