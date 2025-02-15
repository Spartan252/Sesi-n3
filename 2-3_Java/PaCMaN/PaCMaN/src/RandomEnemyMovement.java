
import Window.Ventana;

public class RandomEnemyMovement extends Ventana implements Runnable{
    public static void movement(Character character){
        
    }

        @Override
    public void run() {
        while (true) {
            EnemyPosition.movement(ghostC);
            EnemyPosition.movement(ghostR);
            EnemyPosition.movement(ghostP);
            EnemyPosition.movement(ghostY);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    
}
