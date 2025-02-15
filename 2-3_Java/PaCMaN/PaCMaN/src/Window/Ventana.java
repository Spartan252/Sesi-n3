package Window;

import java.awt.event.*;



import Characters.Character;

import java.awt.Color;
import java.awt.Font;

public class Ventana extends javax.swing.JFrame implements KeyListener {
        public javax.swing.JPanel jPanel1 = new javax.swing.JPanel();

                //           Personajes:
        
        //Jugador:
        public javax.swing.JLabel jLabelPacMan= new javax.swing.JLabel();
        protected static Character pacMan;

        public javax.swing.JLabel jLabelPuntaje = new javax.swing.JLabel(); // puntaje
        public javax.swing.JLabel jLabelVidas = new javax.swing.JLabel(); // vidas

        //Fantasmas:        
        public javax.swing.JLabel jLabelGhostC= new javax.swing.JLabel(); // Cyan
        public javax.swing.JLabel jLabelGhostP= new javax.swing.JLabel(); // pink
        public javax.swing.JLabel jLabelGhostR= new javax.swing.JLabel(); // Red
        public javax.swing.JLabel jLabelGhostY= new javax.swing.JLabel(); // Yellow
        protected static Character ghostC;
        protected static Character ghostP;
        protected static Character ghostR;
        protected static Character ghostY;
        
        
        //              Muros:
        public javax.swing.JLabel[] arrayJLabelMuros = new javax.swing.JLabel[35];
        //              Puntos:
        public javax.swing.JLabel[] arrayJLabelPuntos = new javax.swing.JLabel[115];
        protected static Character[] arrayPuntos = new Character[115];

        public Ventana() {
                for (int i =0; i<arrayJLabelMuros.length; i++) {
                arrayJLabelMuros[i] = new javax.swing.JLabel();
        }
                for (int i =0; i<arrayJLabelPuntos.length; i++) {
                arrayJLabelPuntos[i] = new javax.swing.JLabel();
        } 
                initComponents();
                setSize(440, 400);
                setResizable(false);
                
                



        }


        private void initComponents() {

                
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                Font fuente = new Font(jLabelPacMan.getFont().getName(), Font.PLAIN, 24); // Tamaño de letra: 24
                Font fuente2 = new Font(jLabelPacMan.getFont().getName(), Font.PLAIN, 16); // Tamaño de letra: 24
                Font fuente3 = new Font(jLabelPacMan.getFont().getName(), Font.PLAIN, 26); // Tamaño de letra: 24
                
                //"\u2229" -> U inversa 
                //"\u0D9E" -> ඞ

                jLabelPacMan.setText("O");    
                jLabelPacMan.setForeground(Color.YELLOW);    // PAC-MAN
                jLabelPacMan.setFont(fuente2);
                

                jLabelGhostR.setText("ඞ");
                jLabelGhostR.setForeground(Color.RED);    // Ghost Red
                jLabelGhostR.setFont(fuente);
                
                jLabelGhostC.setText("ඞ");
                jLabelGhostC.setForeground(Color.CYAN);    // Ghost Cyan 
                jLabelGhostC.setFont(fuente);
                
                jLabelGhostP.setText("ඞ");
                jLabelGhostP.setForeground(Color.PINK);    // Ghost Pink
                jLabelGhostP.setFont(fuente);

                jLabelGhostY.setText("ඞ");
                jLabelGhostY.setForeground(Color.YELLOW);    // Ghost Yellow
                jLabelGhostY.setFont(fuente);


                
                Environment.createWall(arrayJLabelMuros[0]);
                Environment.createWall(arrayJLabelMuros[1]);

                
                for (javax.swing.JLabel jLabel : arrayJLabelMuros){
                        jLabel.setOpaque(rootPaneCheckingEnabled);
                        jLabel.setBackground(Color.BLACK);
                }
                for (javax.swing.JLabel jLabel : arrayJLabelPuntos){
                        jLabel.setText("•");
                        jLabel.setFont(fuente2);
                        jLabel.setBounds(0,0,jLabel.getWidth(),jLabel.getHeight());
                        
                        jLabel.setForeground(Color.WHITE);
                }
                arrayJLabelPuntos[0].setFont(fuente3);
                arrayJLabelPuntos[8].setFont(fuente3);
                arrayJLabelPuntos[106].setFont(fuente3);
                arrayJLabelPuntos[114].setFont(fuente3);
                


                jPanel1.setBackground(Color.BLUE.darker().darker().darker());


        
                int a=40;
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);

                
                jPanel1.setLayout(jPanel1Layout);
                jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2));
                
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(arrayJLabelPuntos[0]).addComponent(arrayJLabelPuntos[1]).addComponent(arrayJLabelPuntos[2]).addComponent(arrayJLabelPuntos[3]).addComponent(arrayJLabelPuntos[4]).addComponent(arrayJLabelPuntos[5]).addComponent(arrayJLabelPuntos[6]).addComponent(arrayJLabelPuntos[7]).addComponent(arrayJLabelPuntos[8]).addComponent(arrayJLabelPuntos[9]).addComponent(arrayJLabelPuntos[10]).addComponent(arrayJLabelPuntos[11]).addComponent(arrayJLabelPuntos[12]).addComponent(arrayJLabelPuntos[13]).addComponent(arrayJLabelPuntos[14]).addComponent(arrayJLabelPuntos[15]).addComponent(arrayJLabelPuntos[16]).addComponent(arrayJLabelPuntos[17]).addComponent(arrayJLabelPuntos[18]).addComponent(arrayJLabelPuntos[19]).addComponent(arrayJLabelPuntos[20]).addComponent(arrayJLabelPuntos[21]).addComponent(arrayJLabelPuntos[22]).addComponent(arrayJLabelPuntos[23]).addComponent(arrayJLabelPuntos[24]).addComponent(arrayJLabelPuntos[25]).addComponent(arrayJLabelPuntos[26]).addComponent(arrayJLabelPuntos[27]).addComponent(arrayJLabelPuntos[28]).addComponent(arrayJLabelPuntos[29]).addComponent(arrayJLabelPuntos[30]).addComponent(arrayJLabelPuntos[31]).addComponent(arrayJLabelPuntos[32]).addComponent(arrayJLabelPuntos[33]).addComponent(arrayJLabelPuntos[34]).addComponent(arrayJLabelPuntos[35]).addComponent(arrayJLabelPuntos[36]).addComponent(arrayJLabelPuntos[37]).addComponent(arrayJLabelPuntos[38]).addComponent(arrayJLabelPuntos[39]).addComponent(arrayJLabelPuntos[40])
                        .addComponent(arrayJLabelPuntos[1+a]).addComponent(arrayJLabelPuntos[2+a]).addComponent(arrayJLabelPuntos[3+a]).addComponent(arrayJLabelPuntos[4+a]).addComponent(arrayJLabelPuntos[5+a]).addComponent(arrayJLabelPuntos[6+a]).addComponent(arrayJLabelPuntos[7+a]).addComponent(arrayJLabelPuntos[8+a]).addComponent(arrayJLabelPuntos[9+a]).addComponent(arrayJLabelPuntos[10+a]).addComponent(arrayJLabelPuntos[11+a]).addComponent(arrayJLabelPuntos[12+a]).addComponent(arrayJLabelPuntos[13+a]).addComponent(arrayJLabelPuntos[14+a]).addComponent(arrayJLabelPuntos[15+a]).addComponent(arrayJLabelPuntos[16+a]).addComponent(arrayJLabelPuntos[17+a]).addComponent(arrayJLabelPuntos[18+a]).addComponent(arrayJLabelPuntos[19+a]).addComponent(arrayJLabelPuntos[20+a]).addComponent(arrayJLabelPuntos[21+a]).addComponent(arrayJLabelPuntos[22+a]).addComponent(arrayJLabelPuntos[23+a]).addComponent(arrayJLabelPuntos[24+a]).addComponent(arrayJLabelPuntos[25+a]).addComponent(arrayJLabelPuntos[26+a]).addComponent(arrayJLabelPuntos[27+a]).addComponent(arrayJLabelPuntos[28+a]).addComponent(arrayJLabelPuntos[29+a]).addComponent(arrayJLabelPuntos[30+a]).addComponent(arrayJLabelPuntos[31+a]).addComponent(arrayJLabelPuntos[32+a]).addComponent(arrayJLabelPuntos[33+a]).addComponent(arrayJLabelPuntos[34+a]).addComponent(arrayJLabelPuntos[35+a]).addComponent(arrayJLabelPuntos[36+a]).addComponent(arrayJLabelPuntos[37+a]).addComponent(arrayJLabelPuntos[38+a]).addComponent(arrayJLabelPuntos[39+a]).addComponent(arrayJLabelPuntos[40+a])
                                .addComponent(arrayJLabelPuntos[1+a+a]).addComponent(arrayJLabelPuntos[2+a+a]).addComponent(arrayJLabelPuntos[3+a+a]).addComponent(arrayJLabelPuntos[4+a+a]).addComponent(arrayJLabelPuntos[5+a+a]).addComponent(arrayJLabelPuntos[6+a+a]).addComponent(arrayJLabelPuntos[7+a+a]).addComponent(arrayJLabelPuntos[8+a+a]).addComponent(arrayJLabelPuntos[9+a+a]).addComponent(arrayJLabelPuntos[10+a+a]).addComponent(arrayJLabelPuntos[11+a+a]).addComponent(arrayJLabelPuntos[12+a+a]).addComponent(arrayJLabelPuntos[13+a+a]).addComponent(arrayJLabelPuntos[14+a+a]).addComponent(arrayJLabelPuntos[15+a+a]).addComponent(arrayJLabelPuntos[16+a+a]).addComponent(arrayJLabelPuntos[17+a+a]).addComponent(arrayJLabelPuntos[18+a+a]).addComponent(arrayJLabelPuntos[19+a+a]).addComponent(arrayJLabelPuntos[20+a+a]).addComponent(arrayJLabelPuntos[21+a+a]).addComponent(arrayJLabelPuntos[22+a+a]).addComponent(arrayJLabelPuntos[23+a+a]).addComponent(arrayJLabelPuntos[24+a+a]).addComponent(arrayJLabelPuntos[25+a+a]).addComponent(arrayJLabelPuntos[26+a+a]).addComponent(arrayJLabelPuntos[27+a+a]).addComponent(arrayJLabelPuntos[28+a+a]).addComponent(arrayJLabelPuntos[29+a+a]).addComponent(arrayJLabelPuntos[30+a+a]).addComponent(arrayJLabelPuntos[31+a+a]).addComponent(arrayJLabelPuntos[32+a+a]).addComponent(arrayJLabelPuntos[33+a+a]).addComponent(arrayJLabelPuntos[34+a+a])
                        
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                                
                                .addGroup(jPanel1Layout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelGhostY)
                                        .addComponent(jLabelGhostP)
                                        .addComponent(jLabelGhostC)
                                        .addComponent(jLabelGhostR)
                                        
                                        ))
                                        .addComponent(arrayJLabelMuros[0]).addComponent(arrayJLabelMuros[1]).addComponent(arrayJLabelMuros[2]).addComponent(arrayJLabelMuros[3]).addComponent(arrayJLabelMuros[4]).addComponent(arrayJLabelMuros[5]).addComponent(arrayJLabelMuros[6]).addComponent(arrayJLabelMuros[7]).addComponent(arrayJLabelMuros[8]).addComponent(arrayJLabelMuros[9]).addComponent(arrayJLabelMuros[10]).addComponent(arrayJLabelMuros[11]).addComponent(arrayJLabelMuros[12]).addComponent(arrayJLabelMuros[13]).addComponent(arrayJLabelMuros[14]).addComponent(arrayJLabelMuros[15]).addComponent(arrayJLabelMuros[16]).addComponent(arrayJLabelMuros[17]).addComponent(arrayJLabelMuros[18]).addComponent(arrayJLabelMuros[19]).addComponent(arrayJLabelMuros[20]).addComponent(arrayJLabelMuros[21]).addComponent(arrayJLabelMuros[22]).addComponent(arrayJLabelMuros[23]).addComponent(arrayJLabelMuros[24]).addComponent(arrayJLabelMuros[25]).addComponent(arrayJLabelMuros[26]).addComponent(arrayJLabelMuros[27]).addComponent(arrayJLabelMuros[28]).addComponent(arrayJLabelMuros[29]).addComponent(arrayJLabelMuros[30]).addComponent(arrayJLabelMuros[31]).addComponent(arrayJLabelMuros[32]).addComponent(arrayJLabelMuros[33]).addComponent(arrayJLabelMuros[34])
                                        .addGroup(jPanel1Layout
                                        .createSequentialGroup()
                                        .addGap(121, 121, 121)
                                        .addComponent(jLabelPacMan)))
                                        ));
                                        
                                        
                        jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(arrayJLabelPuntos[0]).addComponent(arrayJLabelPuntos[1]).addComponent(arrayJLabelPuntos[2]).addComponent(arrayJLabelPuntos[3]).addComponent(arrayJLabelPuntos[4]).addComponent(arrayJLabelPuntos[5]).addComponent(arrayJLabelPuntos[6]).addComponent(arrayJLabelPuntos[7]).addComponent(arrayJLabelPuntos[8]).addComponent(arrayJLabelPuntos[9]).addComponent(arrayJLabelPuntos[10]).addComponent(arrayJLabelPuntos[11]).addComponent(arrayJLabelPuntos[12]).addComponent(arrayJLabelPuntos[13]).addComponent(arrayJLabelPuntos[14]).addComponent(arrayJLabelPuntos[15]).addComponent(arrayJLabelPuntos[16]).addComponent(arrayJLabelPuntos[17]).addComponent(arrayJLabelPuntos[18]).addComponent(arrayJLabelPuntos[19]).addComponent(arrayJLabelPuntos[20]).addComponent(arrayJLabelPuntos[21]).addComponent(arrayJLabelPuntos[22]).addComponent(arrayJLabelPuntos[23]).addComponent(arrayJLabelPuntos[24]).addComponent(arrayJLabelPuntos[25]).addComponent(arrayJLabelPuntos[26]).addComponent(arrayJLabelPuntos[27]).addComponent(arrayJLabelPuntos[28]).addComponent(arrayJLabelPuntos[29]).addComponent(arrayJLabelPuntos[30]).addComponent(arrayJLabelPuntos[31]).addComponent(arrayJLabelPuntos[32]).addComponent(arrayJLabelPuntos[33]).addComponent(arrayJLabelPuntos[34]).addComponent(arrayJLabelPuntos[35]).addComponent(arrayJLabelPuntos[36]).addComponent(arrayJLabelPuntos[37]).addComponent(arrayJLabelPuntos[38]).addComponent(arrayJLabelPuntos[39]).addComponent(arrayJLabelPuntos[40])
                                .addComponent(arrayJLabelPuntos[1+a]).addComponent(arrayJLabelPuntos[2+a]).addComponent(arrayJLabelPuntos[3+a]).addComponent(arrayJLabelPuntos[4+a]).addComponent(arrayJLabelPuntos[5+a]).addComponent(arrayJLabelPuntos[6+a]).addComponent(arrayJLabelPuntos[7+a]).addComponent(arrayJLabelPuntos[8+a]).addComponent(arrayJLabelPuntos[9+a]).addComponent(arrayJLabelPuntos[10+a]).addComponent(arrayJLabelPuntos[11+a]).addComponent(arrayJLabelPuntos[12+a]).addComponent(arrayJLabelPuntos[13+a]).addComponent(arrayJLabelPuntos[14+a]).addComponent(arrayJLabelPuntos[15+a]).addComponent(arrayJLabelPuntos[16+a]).addComponent(arrayJLabelPuntos[17+a]).addComponent(arrayJLabelPuntos[18+a]).addComponent(arrayJLabelPuntos[19+a]).addComponent(arrayJLabelPuntos[20+a]).addComponent(arrayJLabelPuntos[21+a]).addComponent(arrayJLabelPuntos[22+a]).addComponent(arrayJLabelPuntos[23+a]).addComponent(arrayJLabelPuntos[24+a]).addComponent(arrayJLabelPuntos[25+a]).addComponent(arrayJLabelPuntos[26+a]).addComponent(arrayJLabelPuntos[27+a]).addComponent(arrayJLabelPuntos[28+a]).addComponent(arrayJLabelPuntos[29+a]).addComponent(arrayJLabelPuntos[30+a]).addComponent(arrayJLabelPuntos[31+a]).addComponent(arrayJLabelPuntos[32+a]).addComponent(arrayJLabelPuntos[33+a]).addComponent(arrayJLabelPuntos[34+a]).addComponent(arrayJLabelPuntos[35+a]).addComponent(arrayJLabelPuntos[36+a]).addComponent(arrayJLabelPuntos[37+a]).addComponent(arrayJLabelPuntos[38+a]).addComponent(arrayJLabelPuntos[39+a]).addComponent(arrayJLabelPuntos[40+a])
                                .addComponent(arrayJLabelPuntos[1+a+a]).addComponent(arrayJLabelPuntos[2+a+a]).addComponent(arrayJLabelPuntos[3+a+a]).addComponent(arrayJLabelPuntos[4+a+a]).addComponent(arrayJLabelPuntos[5+a+a]).addComponent(arrayJLabelPuntos[6+a+a]).addComponent(arrayJLabelPuntos[7+a+a]).addComponent(arrayJLabelPuntos[8+a+a]).addComponent(arrayJLabelPuntos[9+a+a]).addComponent(arrayJLabelPuntos[10+a+a]).addComponent(arrayJLabelPuntos[11+a+a]).addComponent(arrayJLabelPuntos[12+a+a]).addComponent(arrayJLabelPuntos[13+a+a]).addComponent(arrayJLabelPuntos[14+a+a]).addComponent(arrayJLabelPuntos[15+a+a]).addComponent(arrayJLabelPuntos[16+a+a]).addComponent(arrayJLabelPuntos[17+a+a]).addComponent(arrayJLabelPuntos[18+a+a]).addComponent(arrayJLabelPuntos[19+a+a]).addComponent(arrayJLabelPuntos[20+a+a]).addComponent(arrayJLabelPuntos[21+a+a]).addComponent(arrayJLabelPuntos[22+a+a]).addComponent(arrayJLabelPuntos[23+a+a]).addComponent(arrayJLabelPuntos[24+a+a]).addComponent(arrayJLabelPuntos[25+a+a]).addComponent(arrayJLabelPuntos[26+a+a]).addComponent(arrayJLabelPuntos[27+a+a]).addComponent(arrayJLabelPuntos[28+a+a]).addComponent(arrayJLabelPuntos[29+a+a]).addComponent(arrayJLabelPuntos[30+a+a]).addComponent(arrayJLabelPuntos[31+a+a]).addComponent(arrayJLabelPuntos[32+a+a]).addComponent(arrayJLabelPuntos[33+a+a]).addComponent(arrayJLabelPuntos[34+a+a])

                                .addGroup(jPanel1Layout.createSequentialGroup()
                                
                                .addGap(50, 50, 50)
                                .addComponent(jLabelGhostR)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelGhostC)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelGhostP)
                                                
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabelGhostY)
                                                        .addComponent(arrayJLabelMuros[0]).addComponent(arrayJLabelMuros[1]).addComponent(arrayJLabelMuros[2]).addComponent(arrayJLabelMuros[3]).addComponent(arrayJLabelMuros[4]).addComponent(arrayJLabelMuros[5]).addComponent(arrayJLabelMuros[6]).addComponent(arrayJLabelMuros[7]).addComponent(arrayJLabelMuros[8]).addComponent(arrayJLabelMuros[9]).addComponent(arrayJLabelMuros[10]).addComponent(arrayJLabelMuros[11]).addComponent(arrayJLabelMuros[12]).addComponent(arrayJLabelMuros[13]).addComponent(arrayJLabelMuros[14]).addComponent(arrayJLabelMuros[15]).addComponent(arrayJLabelMuros[16]).addComponent(arrayJLabelMuros[17]).addComponent(arrayJLabelMuros[18]).addComponent(arrayJLabelMuros[19]).addComponent(arrayJLabelMuros[20]).addComponent(arrayJLabelMuros[21]).addComponent(arrayJLabelMuros[22]).addComponent(arrayJLabelMuros[23]).addComponent(arrayJLabelMuros[24]).addComponent(arrayJLabelMuros[25]).addComponent(arrayJLabelMuros[26]).addComponent(arrayJLabelMuros[27]).addComponent(arrayJLabelMuros[28]).addComponent(arrayJLabelMuros[29]).addComponent(arrayJLabelMuros[30]).addComponent(arrayJLabelMuros[31]).addComponent(arrayJLabelMuros[32]).addComponent(arrayJLabelMuros[33]).addComponent(arrayJLabelMuros[34])

                                                        .addGap(60, 60, 60)
                                                        .addComponent(jLabelPacMan)
                                                        ));
                                                        
                                                        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE)));
                        

                        pack(); 
                        
                

        

        pacMan = new Character((jPanel1.getWidth()/2-5),170);
        ghostR = new Character(jLabelGhostR.getX(),jLabelGhostR.getY());
        
        ghostR.setHeight(17);
        ghostC = new Character(jLabelGhostC.getX(),jLabelGhostC.getY());
        ghostC.setHeight(17);
        ghostP = new Character(jLabelGhostP.getX(),jLabelGhostP.getY());
        ghostP.setHeight(17);
        ghostY = new Character(jLabelGhostY.getX(),jLabelGhostY.getY());
        ghostY.setHeight(17);


        for (int i =0; i<arrayPuntos.length; i++) {
                arrayPuntos[i] = new Character();
                arrayPuntos[i].setHeight(3);
                arrayPuntos[i].setWidth(3);
        } 
        
        addKeyListener(this);

        }
        
        public void keyPressed(KeyEvent e) { // al presionar la tecla ejecuta:
                int keyCode = e.getKeyCode();
                //System.out.println("Tecla precionada: " + KeyEvent.getKeyText(keyCode));// imprime a consola la tecla
                                                                                        // presionada

                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
                        pacMan.moveUp(pacMan.x);
                }
                if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
                        pacMan.moveDown(pacMan.x, jPanel1.getHeight());
                }
                if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
                        pacMan.moveLeft(pacMan.y);
                }
                if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
                        pacMan.moveRight(pacMan.y, jPanel1.getWidth());
                }
        }
        
        public void keyTyped(KeyEvent e) {// debe estar definido
        }
        
        public void keyReleased(KeyEvent e) { // debe estar definido
        }
}
