package Characters;

public class Character {

    public int x;
    public int y;
    private boolean matable= false;
    public int moveX = 2;
    public int moveY = 0;
    private int h=10;
    private int w=10;

    
    // Constructores
    public Character() {
        this.x = 2;
        this.y = 1;
    }

    public Character(int x, int y) {
        setPosition(x, y);
    }

    public void setPosition(int x, int y) { // Derecha
        this.moveX = x;
        this.moveY = y;
        this.x = x;
        this.y = y;
    }

    public void setHeight(int height) {
        h=height;
    }
    public int getHeight() {
        return h;
    }
    public void setWidth(int width) {
        w=width;
    }
    public int getWidth() {
        return w;
    }
    public void setKillable(boolean flag) {
        matable=flag;
    }
    public boolean getKillable() {
        return matable;
    }

    public void moveRight(int y, int width) { // Derecha
        this.moveX = width - 15;
        this.moveY = y;
    }

    public void moveLeft(int y) { // Izquierda
        this.moveX = 2;
        this.moveY = y;
    }

    public void moveUp(int x) { // Arriba
        this.moveY = 1;
        this.moveX = x;
    }

    public void moveDown(int x, int height) { // Abajo
        this.moveY = height - 15;
        this.moveX = x;
    }

    public boolean Colicion(int x, int y, int width, int height) {
        int xTemp = this.x;
        int yTemp = this.y;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if ((xTemp+i >= x && xTemp+i <= (width+x)) && (yTemp+j >= y && yTemp+j <= (height+y)) ) return true;
            }
        }
        return false;
    }
}
