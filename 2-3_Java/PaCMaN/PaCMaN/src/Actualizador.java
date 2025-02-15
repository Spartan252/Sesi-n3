


//import Iniciar;
import Characters.Character;
import Characters.Directions;
import Window.Environment;
import Window.Ventana;

import java.awt.Color;

import javax.swing.JOptionPane;

public class Actualizador extends Ventana implements Runnable {

    public static void actualizar(Character character, javax.swing.JLabel jLabel,javax.swing.JLabel[] arrayJLabelMuros) {
        if (character.x < character.moveX && PreColicion(character,Directions.RIGHT, arrayJLabelMuros)==false) {
            character.x++;
        }
        if (character.x > character.moveX && PreColicion(character,Directions.LEFT, arrayJLabelMuros)==false ){
            character.x--;
        }
        if (character.y < character.moveY && (PreColicion(character,Directions.UP, arrayJLabelMuros)==false) ){
            character.y++;
        }
        if (character.y > character.moveY && (PreColicion(character,Directions.DOWN, arrayJLabelMuros)==false)) {
            character.y--;
        }
        jLabel.setLocation(character.x, character.y);

    }





    public static boolean PreColicion(Character character,Directions direccion, javax.swing.JLabel... arrayJLabelMuros) {
        int xTemp = character.x;
        int yTemp = character.y;
        switch (direccion) {
            case UP: yTemp += 1; break;
            case DOWN: yTemp -= 1; break;
            case LEFT: xTemp -= 1; break;
            case RIGHT: xTemp += 1; break;
        }
        for (javax.swing.JLabel jLabel :arrayJLabelMuros){
            int x = jLabel.getX()-2;
            int y = jLabel.getY()-5;
            for (int i = 0; i < character.getWidth(); i++) {
                for (int j = 0; j < character.getHeight(); j++) {
                    if ((xTemp+i >= x && xTemp+i <= (jLabel.getWidth()+x)) && (yTemp+j >= y && yTemp+j <= (jLabel.getHeight()+y)) ) return true;
                }
            }
        }
        return false;
    }

    public static void addPoints(int n){
        points+=n;
    }
    public static int getPoints(){
        return points;
    }

    //


    int vidas = 3;
    private static int points = 0;


    public void run() {
        System.out.println("vidas = " + vidas);
        final String name = JOptionPane.showInputDialog("Type your in game name");
        while (vidas>=0) {
            
            Iniciar.actualizarLabel();

            if(points == 565){
                JOptionPane.showMessageDialog(jPanel1, "You WON " + name+"\nPoints: "+points+"\nLives left: "+ vidas, "Congratilations", 0);
                //int iniciar = JOptionPane.showOptionDialog (null, "Play again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
                System.exit(0);
            }


            if (pacMan.Colicion(ghostC.x, ghostC.y, jLabelGhostC.getWidth(), (jLabelGhostC.getHeight()-8)) == true){
                if(ghostC.getKillable()==true){
                    Environment.setDefaultLocation(ghostC, jLabelGhostC,(jPanel1.getWidth()/2-5),125);
                    ghostC.setKillable(false);
                    Iniciar.ventana.jLabelGhostC.setForeground(Color.CYAN);
                }else{
                    vidas--;
                    Environment.setDefaultLocation(pacMan, jLabelPacMan,(jPanel1.getWidth()/2-5),170);
                    if (vidas>=0)System.out.println("Game Over Ghost C : vidas = " + vidas);
                }
            }
            if (pacMan.Colicion(ghostR.x, ghostR.y, jLabelGhostR.getWidth(), jLabelGhostR.getHeight()-8) == true){ 
                if(ghostR.getKillable()==true){
                    Environment.setDefaultLocation(ghostR, jLabelGhostR,(jPanel1.getWidth()/2-5),125);
                    ghostR.setKillable(false);
                    Iniciar.ventana.jLabelGhostR.setForeground(Color.RED);
                }else{
                vidas--;
                Environment.setDefaultLocation(pacMan, jLabelPacMan,(jPanel1.getWidth()/2-5),170);
                if (vidas>=0)System.out.println("Game Over Ghost R : vidas = " + vidas);
                }
            }
            if (pacMan.Colicion(ghostP.x, ghostP.y, jLabelGhostP.getWidth(), jLabelGhostP.getHeight()-8) == true){ 
                if(ghostP.getKillable()==true){
                    Environment.setDefaultLocation(ghostP, jLabelGhostP,(jPanel1.getWidth()/2-5),125);
                    ghostP.setKillable(false);
                    Iniciar.ventana.jLabelGhostP.setForeground(Color.PINK);
                }else{
                vidas--;
                Environment.setDefaultLocation(pacMan, jLabelPacMan,(jPanel1.getWidth()/2-5),170);
                if (vidas>=0)System.out.println("Game Over Ghost P : vidas = " + vidas);
                }
            }
            if (pacMan.Colicion(ghostY.x, ghostY.y, jLabelGhostY.getWidth(), jLabelGhostY.getHeight()-8) == true){ 
                if(ghostY.getKillable()==true){
                    Environment.setDefaultLocation(ghostY, jLabelGhostY,(jPanel1.getWidth()/2-5),125);
                    ghostY.setKillable(false);
                    Iniciar.ventana.jLabelGhostY.setForeground(Color.YELLOW);
                }else{
                vidas--;
                Environment.setDefaultLocation(pacMan, jLabelPacMan,(jPanel1.getWidth()/2-5),170);
                if (vidas>=0)System.out.println("Game Over Ghost Y : vidas = " + vidas);
                }
            }
    }
    JOptionPane.showMessageDialog(jPanel1, "Points: "+points, "Game Over "+ name, 0);
    System.exit(0);// cierra el programa

    }
}
