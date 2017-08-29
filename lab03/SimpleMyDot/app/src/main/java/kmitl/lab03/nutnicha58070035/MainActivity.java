package kmitl.lab03.nutnicha58070035;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

import kmitl.lab03.nutnicha58070035.Model.Dot;
import kmitl.lab03.nutnicha58070035.view.DotView;

public class MainActivity extends AppCompatActivity
        implements Dot.OnDotChangeListener{

    private DotView dotView;
    private Dot dot;
    private Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotView = (DotView) findViewById(R.id.dotView);
    }
    public void onDeleteDot(View view){
        dotView.DeleteDot();
        dotView.invalidate();
        //ใส่dotView.invalidate()ให้แสดงผลแหละ
    }

    public void onRandomDot(View view) {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        int centerX = random.nextInt(800);
        int centerY = random.nextInt(800);
        new Dot(this, centerX, centerY, 30, r, g, b);
    }

    @Override
    public void OnDotChangeListener(Dot dot) {
        dotView.setDot(dot);
        dotView.invalidate();

    }
}
