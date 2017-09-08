package kmitl.lab03.nutnicha58070035.Model;


public class Dot {

    public interface OnDotChangeListener {
        void OnDotChangeListener(Dot dot);
    }

    public void setListener(OnDotChangeListener listener){
        this.listener = listener;
    }

    private int centerX;
    private int centerY;
    private int radius;
    private int r;
    private int g;
    private int b;

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getR() {

        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    private OnDotChangeListener listener;

    public Dot( OnDotChangeListener listener, int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.listener = listener;
        this.listener.OnDotChangeListener(this);
        //คนใช้ต้องส่งlistenerมาด้วย
    }

    public Dot(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.listener.OnDotChangeListener(this);

    }

    public Dot(OnDotChangeListener listener, int centerX, int centerY, int radius, int r, int g, int b) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.r = r;
        this.g = g;
        this.b = b;
        this.listener = listener;
        this.listener.OnDotChangeListener(this);

    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }
}
