package my.calendar.calender1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Note extends AppCompatActivity {

    private String felling = "happy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        //-------------set emo-----------------
        final ImageView imselect = findViewById(R.id.selectimage);

        ImageView imhappy = findViewById(R.id.imhappy);
        imhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imselect.setImageResource(R.drawable.happy);
                felling = "happy";
            }
        });
        ImageView imcry = findViewById(R.id.imcry);
        imcry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imselect.setImageResource(R.drawable.cry);
                felling = "cry";
            }
        });
        ImageView imlove = findViewById(R.id.imlove);
        imlove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imselect.setImageResource(R.drawable.love);
                felling = "love";
            }
        });
        ImageView imbad = findViewById(R.id.imbad);
        imbad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imselect.setImageResource(R.drawable.bad);
                felling = "bad";
            }
        });
        ImageView imomg = findViewById(R.id.imomg);
        imomg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imselect.setImageResource(R.drawable.omg);
                felling = "omg";
            }
        });
        ImageView imsick = findViewById(R.id.imsick);
        imsick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imselect.setImageResource(R.drawable.sick);
                felling = "sick";
            }
        });
        //----------------test finish intent----------------------------
        Button saveBtn = (Button) findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
