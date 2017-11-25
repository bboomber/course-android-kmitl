package my.calendar.calender1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private static final String TAG = "Calender";
    private CalendarView mCalendarView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.testTV);

        mCalendarView =(CalendarView) findViewById(R.id.calendarView1);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                linearLayout = findViewById(R.id.noteLayout);
                linearLayout.setVisibility(View.VISIBLE);

                String date = i2 + "/" + (i1+1) + "/" + i;
                textView.setText(date);

            }
        });

        Button noteBtn = (Button) findViewById(R.id.noteBtn);
        noteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Note.class);
                startActivity(intent);
            }
        });


    }

}
