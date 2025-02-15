package Window;
import Characters.Character;

public class Environment  {

    public static void createWall(javax.swing.JLabel jLabelMuro ){
        jLabelMuro.setText("_______________________________________________________");
    }
    
    public static void setDefaultLocation(Character character,javax.swing.JLabel jLabel, int x, int y) {
            character.setPosition(x,y);
            jLabel.setLocation(character.x, character.y);
        }

    public static void setEnvironment(Ventana ventana){
        Ventana.pacMan.setKillable(true);

        //Muros Exteriores
        ventana.arrayJLabelMuros[0].setBounds(0, 0, ventana.jPanel1.getWidth(), 5);
        ventana.arrayJLabelMuros[1].setBounds(0, ventana.jPanel1.getHeight()-30, ventana.jPanel1.getWidth(), 30);
        ventana.arrayJLabelMuros[2].setBounds(0, 0, 5, ventana.jPanel1.getHeight());
        ventana.arrayJLabelMuros[3].setBounds(ventana.jPanel1.getWidth()-5, 0, 5, ventana.jPanel1.getHeight());
        //Muros Fantasmas
        ventana.arrayJLabelMuros[4].setBounds((ventana.jPanel1.getWidth()/2)-50, (ventana.jPanel1.getHeight()/2), 100, 10);
        ventana.arrayJLabelMuros[5].setBounds((ventana.jPanel1.getWidth()/2)-50, (ventana.jPanel1.getHeight()/2)-40, 10, 40);
        ventana.arrayJLabelMuros[6].setBounds((ventana.jPanel1.getWidth()/2)+40, (ventana.jPanel1.getHeight()/2)-40, 10, 40);
        
        //ventana.arrayJLabelMuros[7].setBounds((ventana.jPanel1.getWidth()/2)-50, (ventana.jPanel1.getHeight()/2)-40, 30, 10);
        //ventana.arrayJLabelMuros[8].setBounds((ventana.jPanel1.getWidth()/2)+20, (ventana.jPanel1.getHeight()/2)-40, 30, 10); 

        //Muros Arriba
        ventana.arrayJLabelMuros[9].setBounds((ventana.jPanel1.getWidth()/2)-50, 70, 100, 15);
        ventana.arrayJLabelMuros[10].setBounds((ventana.jPanel1.getWidth()/2)-90, 0, 15, 50);
        ventana.arrayJLabelMuros[11].setBounds((ventana.jPanel1.getWidth()/2)+75, 0, 15, 50);
        ventana.arrayJLabelMuros[12].setBounds((ventana.jPanel1.getWidth()/2)-90, 0, 170, 30);

        //Muros Abajo
        ventana.arrayJLabelMuros[13].setBounds((ventana.jPanel1.getWidth()/2)-50, (ventana.jPanel1.getHeight()/2)+40, 100, 15);
        ventana.arrayJLabelMuros[14].setBounds((ventana.jPanel1.getWidth()/2)-50, (ventana.jPanel1.getHeight()/2)+80, 100, 15);
        ventana.arrayJLabelMuros[15].setBounds((ventana.jPanel1.getWidth()/2)-90, ventana.jPanel1.getHeight()-75, 15, 50);
        ventana.arrayJLabelMuros[16].setBounds((ventana.jPanel1.getWidth()/2)+75, ventana.jPanel1.getHeight()-75, 15, 50);
        
        //Muros Izquierda
        ventana.arrayJLabelMuros[17].setBounds((ventana.jPanel1.getWidth()/2)-105, (ventana.jPanel1.getHeight()/2)+40, 30, 15);
        ventana.arrayJLabelMuros[18].setBounds((ventana.jPanel1.getWidth()/2)-105, (ventana.jPanel1.getHeight()/2), 30, 15);
        ventana.arrayJLabelMuros[19].setBounds((ventana.jPanel1.getWidth()/2)-105, (ventana.jPanel1.getHeight()/2)-40, 30, 15);
        ventana.arrayJLabelMuros[20].setBounds((ventana.jPanel1.getWidth()/2)-105, 70, 30, 15);
        ventana.arrayJLabelMuros[21].setBounds(25, ventana.jPanel1.getHeight()-75, 25, 15);
        ventana.arrayJLabelMuros[22].setBounds(25, ventana.jPanel1.getHeight()-140, 10, 70);
        ventana.arrayJLabelMuros[23].setBounds(25, 30, 25, 15);
        ventana.arrayJLabelMuros[24].setBounds(25, 30, 10, 80);
        ventana.arrayJLabelMuros[25].setBounds(25, (ventana.jPanel1.getHeight()/2)-20, 10, 15);

        //Muros Derecha
        ventana.arrayJLabelMuros[26].setBounds((ventana.jPanel1.getWidth()/2)+75, (ventana.jPanel1.getHeight()/2)+40, 30, 15);
        ventana.arrayJLabelMuros[27].setBounds((ventana.jPanel1.getWidth()/2)+75, (ventana.jPanel1.getHeight()/2), 30, 15);
        ventana.arrayJLabelMuros[28].setBounds((ventana.jPanel1.getWidth()/2)+75, (ventana.jPanel1.getHeight()/2)-40, 30, 15);
        ventana.arrayJLabelMuros[29].setBounds((ventana.jPanel1.getWidth()/2)+75, 70, 30, 15);
        ventana.arrayJLabelMuros[30].setBounds(ventana.jPanel1.getWidth()-50, ventana.jPanel1.getHeight()-75, 25, 15);
        ventana.arrayJLabelMuros[31].setBounds(ventana.jPanel1.getWidth()-35, ventana.jPanel1.getHeight()-140, 10, 70);
        ventana.arrayJLabelMuros[32].setBounds(ventana.jPanel1.getWidth()-50, 30, 25, 15);
        ventana.arrayJLabelMuros[33].setBounds(ventana.jPanel1.getWidth()-35, 30, 10, 80);
        ventana.arrayJLabelMuros[34].setBounds(ventana.jPanel1.getWidth()-35, (ventana.jPanel1.getHeight()/2)-20, 10, 15);


        for (int i=0; i<Ventana.arrayPuntos.length; i++){
            Environment.setDefaultLocation(Ventana.arrayPuntos[i], ventana.arrayJLabelPuntos[i],ventana.jPanel1.getWidth(),ventana.jPanel1.getHeight());

        }
        Environment.setDefaultLocation(Ventana.arrayPuntos[0], ventana.arrayJLabelPuntos[0],10,2);
        Environment.setDefaultLocation(Ventana.arrayPuntos[1], ventana.arrayJLabelPuntos[1],11,40);
        Environment.setDefaultLocation(Ventana.arrayPuntos[2], ventana.arrayJLabelPuntos[2],11,70);
        Environment.setDefaultLocation(Ventana.arrayPuntos[3], ventana.arrayJLabelPuntos[3],11,100);
        Environment.setDefaultLocation(Ventana.arrayPuntos[4], ventana.arrayJLabelPuntos[4],11,130);
        Environment.setDefaultLocation(Ventana.arrayPuntos[5], ventana.arrayJLabelPuntos[5],11,160);
        Environment.setDefaultLocation(Ventana.arrayPuntos[6], ventana.arrayJLabelPuntos[6],11,190);
        Environment.setDefaultLocation(Ventana.arrayPuntos[7], ventana.arrayJLabelPuntos[7],11,220);
        Environment.setDefaultLocation(Ventana.arrayPuntos[8], ventana.arrayJLabelPuntos[8],10,245);

        Environment.setDefaultLocation(Ventana.arrayPuntos[9], ventana.arrayJLabelPuntos[9],40,7);
        Environment.setDefaultLocation(Ventana.arrayPuntos[10], ventana.arrayJLabelPuntos[10],40,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[11], ventana.arrayJLabelPuntos[11],40,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[12], ventana.arrayJLabelPuntos[12],40,110);
        Environment.setDefaultLocation(Ventana.arrayPuntos[13], ventana.arrayJLabelPuntos[13],40,140);
        Environment.setDefaultLocation(Ventana.arrayPuntos[14], ventana.arrayJLabelPuntos[14],40,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[15], ventana.arrayJLabelPuntos[15],40,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[16], ventana.arrayJLabelPuntos[16],40,250);

        Environment.setDefaultLocation(Ventana.arrayPuntos[17], ventana.arrayJLabelPuntos[17],70,7);
        Environment.setDefaultLocation(Ventana.arrayPuntos[18], ventana.arrayJLabelPuntos[18],70,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[19], ventana.arrayJLabelPuntos[19],70,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[20], ventana.arrayJLabelPuntos[20],70,130);
        Environment.setDefaultLocation(Ventana.arrayPuntos[21], ventana.arrayJLabelPuntos[21],70,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[22], ventana.arrayJLabelPuntos[22],70,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[23], ventana.arrayJLabelPuntos[23],70,230);
        Environment.setDefaultLocation(Ventana.arrayPuntos[24], ventana.arrayJLabelPuntos[24],70,250);

        
        Environment.setDefaultLocation(Ventana.arrayPuntos[25], ventana.arrayJLabelPuntos[25],92,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[26], ventana.arrayJLabelPuntos[26],92,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[27], ventana.arrayJLabelPuntos[27],92,130);
        Environment.setDefaultLocation(Ventana.arrayPuntos[28], ventana.arrayJLabelPuntos[28],92,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[29], ventana.arrayJLabelPuntos[29],92,210);

        Environment.setDefaultLocation(Ventana.arrayPuntos[30], ventana.arrayJLabelPuntos[30],111,30);
        Environment.setDefaultLocation(Ventana.arrayPuntos[31], ventana.arrayJLabelPuntos[31],111,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[32], ventana.arrayJLabelPuntos[32],111,85); 
        Environment.setDefaultLocation(Ventana.arrayPuntos[33], ventana.arrayJLabelPuntos[33],111,130);
        Environment.setDefaultLocation(Ventana.arrayPuntos[34], ventana.arrayJLabelPuntos[34],111,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[35], ventana.arrayJLabelPuntos[35],111,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[36], ventana.arrayJLabelPuntos[36],111,230);
        Environment.setDefaultLocation(Ventana.arrayPuntos[37], ventana.arrayJLabelPuntos[37],111,250);
        
        Environment.setDefaultLocation(Ventana.arrayPuntos[38], ventana.arrayJLabelPuntos[38],132,30);
        Environment.setDefaultLocation(Ventana.arrayPuntos[39], ventana.arrayJLabelPuntos[39],132,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[40], ventana.arrayJLabelPuntos[40],132,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[41], ventana.arrayJLabelPuntos[41],132,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[42], ventana.arrayJLabelPuntos[42],132,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[43], ventana.arrayJLabelPuntos[43],132,250);
        
        Environment.setDefaultLocation(Ventana.arrayPuntos[44], ventana.arrayJLabelPuntos[44],153,30);
        Environment.setDefaultLocation(Ventana.arrayPuntos[45], ventana.arrayJLabelPuntos[45],153,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[46], ventana.arrayJLabelPuntos[46],153,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[47], ventana.arrayJLabelPuntos[47],153,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[48], ventana.arrayJLabelPuntos[48],153,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[49], ventana.arrayJLabelPuntos[49],153,250);
        
        Environment.setDefaultLocation(Ventana.arrayPuntos[50], ventana.arrayJLabelPuntos[50],174,30);
        Environment.setDefaultLocation(Ventana.arrayPuntos[51], ventana.arrayJLabelPuntos[51],174,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[52], ventana.arrayJLabelPuntos[52],174,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[53], ventana.arrayJLabelPuntos[53],174,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[54], ventana.arrayJLabelPuntos[54],174,250);
        
        Environment.setDefaultLocation(Ventana.arrayPuntos[55], ventana.arrayJLabelPuntos[55],195,30);
        Environment.setDefaultLocation(Ventana.arrayPuntos[56], ventana.arrayJLabelPuntos[56],195,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[57], ventana.arrayJLabelPuntos[57],195,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[58], ventana.arrayJLabelPuntos[58],195,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[59], ventana.arrayJLabelPuntos[59],195,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[60], ventana.arrayJLabelPuntos[60],195,250);
        
        Environment.setDefaultLocation(Ventana.arrayPuntos[61], ventana.arrayJLabelPuntos[61],216,30);
        Environment.setDefaultLocation(Ventana.arrayPuntos[62], ventana.arrayJLabelPuntos[62],216,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[63], ventana.arrayJLabelPuntos[63],216,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[64], ventana.arrayJLabelPuntos[64],216,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[65], ventana.arrayJLabelPuntos[65],216,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[66], ventana.arrayJLabelPuntos[66],216,250);

        Environment.setDefaultLocation(Ventana.arrayPuntos[67], ventana.arrayJLabelPuntos[67],237,30);
        Environment.setDefaultLocation(Ventana.arrayPuntos[68], ventana.arrayJLabelPuntos[68],237,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[69], ventana.arrayJLabelPuntos[69],237,85); 
        Environment.setDefaultLocation(Ventana.arrayPuntos[70], ventana.arrayJLabelPuntos[70],237,130);
        Environment.setDefaultLocation(Ventana.arrayPuntos[71], ventana.arrayJLabelPuntos[71],237,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[72], ventana.arrayJLabelPuntos[72],237,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[73], ventana.arrayJLabelPuntos[73],237,230);
        Environment.setDefaultLocation(Ventana.arrayPuntos[74], ventana.arrayJLabelPuntos[74],237,250);
        
        Environment.setDefaultLocation(Ventana.arrayPuntos[85], ventana.arrayJLabelPuntos[85],257,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[86], ventana.arrayJLabelPuntos[86],257,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[87], ventana.arrayJLabelPuntos[87],257,130);
        Environment.setDefaultLocation(Ventana.arrayPuntos[88], ventana.arrayJLabelPuntos[88],257,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[89], ventana.arrayJLabelPuntos[89],257,210);

        Environment.setDefaultLocation(Ventana.arrayPuntos[90], ventana.arrayJLabelPuntos[90],280,7);
        Environment.setDefaultLocation(Ventana.arrayPuntos[91], ventana.arrayJLabelPuntos[91],280,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[92], ventana.arrayJLabelPuntos[92],280,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[93], ventana.arrayJLabelPuntos[93],280,130);
        Environment.setDefaultLocation(Ventana.arrayPuntos[94], ventana.arrayJLabelPuntos[94],280,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[95], ventana.arrayJLabelPuntos[95],280,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[96], ventana.arrayJLabelPuntos[96],280,230);
        Environment.setDefaultLocation(Ventana.arrayPuntos[97], ventana.arrayJLabelPuntos[97],280,250);

        Environment.setDefaultLocation(Ventana.arrayPuntos[98], ventana.arrayJLabelPuntos[98],305,7);
        Environment.setDefaultLocation(Ventana.arrayPuntos[99], ventana.arrayJLabelPuntos[99],305,50);
        Environment.setDefaultLocation(Ventana.arrayPuntos[100], ventana.arrayJLabelPuntos[100],305,85);
        Environment.setDefaultLocation(Ventana.arrayPuntos[101], ventana.arrayJLabelPuntos[101],305,110);
        Environment.setDefaultLocation(Ventana.arrayPuntos[102], ventana.arrayJLabelPuntos[102],305,140);
        Environment.setDefaultLocation(Ventana.arrayPuntos[103], ventana.arrayJLabelPuntos[103],305,170);
        Environment.setDefaultLocation(Ventana.arrayPuntos[104], ventana.arrayJLabelPuntos[104],305,210);
        Environment.setDefaultLocation(Ventana.arrayPuntos[105], ventana.arrayJLabelPuntos[105],305,250);

        Environment.setDefaultLocation(Ventana.arrayPuntos[106], ventana.arrayJLabelPuntos[106],335,2);
        Environment.setDefaultLocation(Ventana.arrayPuntos[107], ventana.arrayJLabelPuntos[107],337,40);
        Environment.setDefaultLocation(Ventana.arrayPuntos[108], ventana.arrayJLabelPuntos[108],337,70);
        Environment.setDefaultLocation(Ventana.arrayPuntos[109], ventana.arrayJLabelPuntos[109],337,100);
        Environment.setDefaultLocation(Ventana.arrayPuntos[110], ventana.arrayJLabelPuntos[110],337,130);
        Environment.setDefaultLocation(Ventana.arrayPuntos[111], ventana.arrayJLabelPuntos[111],337,160);
        Environment.setDefaultLocation(Ventana.arrayPuntos[112], ventana.arrayJLabelPuntos[112],337,190);
        Environment.setDefaultLocation(Ventana.arrayPuntos[113], ventana.arrayJLabelPuntos[113],337,220);
        Environment.setDefaultLocation(Ventana.arrayPuntos[114], ventana.arrayJLabelPuntos[114],335,245);
    } 

}
