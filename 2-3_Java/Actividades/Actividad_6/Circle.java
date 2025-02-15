package Actividades.Actividad_6;

import javax.swing.JOptionPane;

public class Circle {

    private double radio = 0;

    public void setRadio(double radio) {
        if (radio >= 1)
            this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public double getArea() {
        return (Math.PI * Math.pow(radio, 2));
    }

    public double getPerimetro() {
        return ((radio * 2) * Math.PI);
    }

    public void print() {
        JOptionPane.showMessageDialog(null,
                "Radio: " + getRadio() + "\nÁrea: " + getArea() + "\nPerímetro: " + getPerimetro(), "\nCírculo", 2);
    }
}
