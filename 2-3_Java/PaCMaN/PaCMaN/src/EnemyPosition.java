

import java.util.Random;

import Characters.Character;
import Window.Ventana;

public class EnemyPosition extends Ventana implements Runnable {
    private static int HEIGHT;
    private static int WIDTH;
    //private Random random = new Random();
    public EnemyPosition (int width,int height) {
        WIDTH = width;
        HEIGHT = height;
    }
    public static int getHEIGHT() {
        return HEIGHT;
    }
    public static int getWIDTH() {
        return WIDTH;
    }

    public static void movement(Character character) {
        Random random = new Random();
        switch (random.nextInt(4)) {
            case 0:
                character.moveUp(character.x);
                break;
            case 1:
                character.moveDown(character.x, HEIGHT);
                break;
            case 2:
                character.moveRight(character.y, WIDTH);
                break; 
            case 3:
                character.moveLeft(character.y);
                break;
            default:
                break;
        }
    }

    

    public static boolean AlwaysMoving(Character character) {
        int FirstX, FirstY;
        FirstX=character.x;
        FirstY=character.y;
        try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (character.x==FirstX&&character.y==FirstY) {
            return true;
        }
        return false;
    }
    public void run() {
        movement(ghostC);
        movement(ghostR);
        movement(ghostP);
        movement(ghostY);
        while (true) {

            if (AlwaysMoving(ghostC)==true) movement(ghostC);
            if (AlwaysMoving(ghostR)==true) movement(ghostR);
            if (AlwaysMoving(ghostP)==true) movement(ghostP);
            if (AlwaysMoving(ghostY)==true) movement(ghostY);
            
            
        

        }
    }
}