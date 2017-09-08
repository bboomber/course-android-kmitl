package kmitl.lab03.nutnicha58070035.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.LinkedList;

import kmitl.lab03.nutnicha58070035.Model.Dot;

public class DotView extends View {

    private Paint paint;
    private Dot dot;
    LinkedList<Dot> list = new LinkedList();

    public void DeleteDot(){
        dot = null;
        //dot ตัวสุดท้ายยังไม่หายไป เลยให้ใส่ null ใว้ ตัวสุดท้ายจะได้เป็นnullก่อนจะลบทั้งหมด
        list.clear();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(this.dot != null) {
            list.add(dot);
            paint.setColor(Color.RED);
            for(Dot i : list)  {
                paint.setARGB(255, i.getR(), i.getG(), i.getB());
                canvas.drawCircle(i.getCenterX(),
                        i.getCenterY(), i.getRadius(), paint);
            }
        }
    }

    public DotView(Context context) {
        super(context);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }


    public void setDot(Dot dot) {
        this.dot = dot;
    }


}
