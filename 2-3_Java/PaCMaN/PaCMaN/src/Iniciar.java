

import Window.*;


public class Iniciar extends Ventana {

    public static Ventana ventana;

    public static boolean verificador() {
        if ((pacMan.x == pacMan.moveX && pacMan.y == pacMan.moveY) &&
                (ghostC.x == ghostC.moveX && ghostC.y == ghostC.moveY) &&
                (ghostR.x == ghostR.moveX && ghostR.y == ghostR.moveY) &&
                (ghostP.x == ghostP.moveX && ghostP.y == ghostP.moveY) &&
                (ghostY.x == ghostY.moveX && ghostY.y == ghostY.moveY))
            return true;

        return false;
    }

    public static boolean actualizarLabel() {
        Actualizador.actualizar(pacMan, ventana.jLabelPacMan, ventana.arrayJLabelMuros);
        Actualizador.actualizar(ghostC, ventana.jLabelGhostC, ventana.arrayJLabelMuros);
        Actualizador.actualizar(ghostR, ventana.jLabelGhostR, ventana.arrayJLabelMuros);
        Actualizador.actualizar(ghostP, ventana.jLabelGhostP, ventana.arrayJLabelMuros);
        Actualizador.actualizar(ghostY, ventana.jLabelGhostY, ventana.arrayJLabelMuros); 
        try {
            Thread.sleep(20); // Hace que el hilo para poder esperar en milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return verificador();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        ventana = new Ventana();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventana.setVisible(true);
            }
        });

        // hilos
        Actualizador actualizador = new Actualizador();
        Thread threadActualizador = new Thread(actualizador);// Crea actualizador (file) como un ejecutable
        EnemyPosition enemyPosition = new EnemyPosition(ventana.jPanel1.getWidth(), ventana.jPanel1.getHeight());
        Thread threadEnemyPosition = new Thread(enemyPosition); // Crea enemyPosition (file) como un ejecutable
        RandomEnemyMovement randomEnemyMovement = new RandomEnemyMovement();
        Thread threadRandomEnemyMovement = new Thread(randomEnemyMovement); // Crea randomEnemyMovement (file) como un ejecutable
        PointsController pointsController = new PointsController();
        Thread threadPointsController = new Thread(pointsController); // Crea pointsController (file) como un ejecutable
        
        
        Environment.setEnvironment(ventana);
        
        

        Environment.setDefaultLocation(pacMan, ventana.jLabelPacMan,(ventana.jPanel1.getWidth()/2-5),170);
        Environment.setDefaultLocation(ghostC, ventana.jLabelGhostC,(ventana.jPanel1.getWidth()/2-5),125);
        Environment.setDefaultLocation(ghostR, ventana.jLabelGhostR,(ventana.jPanel1.getWidth()/2-5),125);
        Environment.setDefaultLocation(ghostP, ventana.jLabelGhostP,(ventana.jPanel1.getWidth()/2-5),125);
        Environment.setDefaultLocation(ghostY, ventana.jLabelGhostY,(ventana.jPanel1.getWidth()/2-5),125);

        System.out.println();
        System.out.println("…………………………………………………………………………");
        System.out.println("……………………… STARTING ………………………");
        System.out.println("…………………………………………………………………………");
        //System.out.println("Dimenciones: " + (ventana.jPanel1.getWidth() - 15) + " X " + (ventana.jPanel1.getHeight() - 15));
        //System.out.println("PacMan: " + (ventana.jLabelPacMan.getWidth()) + " X " + (ventana.jLabelPacMan.getHeight()));
        
        //Environment.setDefaultLocation(arrayPuntos[0], ventana.arrayJLabelPuntos[0],10,10);

        // procesos en paralelo
        threadEnemyPosition.start();
        threadRandomEnemyMovement.start();
        threadPointsController.start();
        threadActualizador.start();


    }
}
