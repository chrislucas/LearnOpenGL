package wiselabs.com.br.opengl.shapes;

/**
 * Created by C.Lucas on 24/09/2015.
 */
public class Point {
    private float x;
    private float y;
    private float z;
    public Point(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
