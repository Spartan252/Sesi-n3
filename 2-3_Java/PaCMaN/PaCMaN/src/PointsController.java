import java.awt.Color;


import Window.Ventana;

public class PointsController extends Ventana implements Runnable{

    private void pointsChecker(Ventana ventana,javax.swing.JLabel... puntos){
        for (int i =0; i<puntos.length; i++) {
            
            if(pacMan.Colicion(ventana.arrayJLabelPuntos[i].getX(),ventana.arrayJLabelPuntos[i].getY(),puntos[i].getWidth(),puntos[i].getHeight())==true){
                if (i==0||i==8||i==106||i==114){
                    Actualizador.addPoints(15);
                    ghostC.setKillable(true);
                    ventana.jLabelGhostC.setForeground(Color.BLUE);
                    ghostR.setKillable(true);
                    ventana.jLabelGhostR.setForeground(Color.BLUE);
                    ghostP.setKillable(true);
                    ventana.jLabelGhostP.setForeground(Color.BLUE);
                    ghostY.setKillable(true);
                    ventana.jLabelGhostY.setForeground(Color.BLUE);
                    new Thread(new Runnable() {
                                public void run() {
                                    try {
                                        Thread.sleep(10000); // Esperar 10 segundos
                                        ghostC.setKillable(false);
                                        ventana.jLabelGhostC.setForeground(Color.CYAN);
                                        ghostR.setKillable(false);
                                        ventana.jLabelGhostR.setForeground(Color.RED);
                                        ghostP.setKillable(false);
                                        ventana.jLabelGhostP.setForeground(Color.PINK);
                                        ghostY.setKillable(false);
                                        ventana.jLabelGhostY.setForeground(Color.YELLOW);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                    }).start();
                }else{
                    Actualizador.addPoints(5);
                }
                ventana.arrayJLabelPuntos[i].setLocation(EnemyPosition.getWIDTH(),EnemyPosition.getHEIGHT());
        }
        }
    }
    @Override
    public void run() {
        while(true){
            pointsChecker(Iniciar.ventana,arrayJLabelPuntos);
            
        }
    }
    
}
