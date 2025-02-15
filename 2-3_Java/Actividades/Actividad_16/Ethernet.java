package Actividades.Actividad_16;

public interface Ethernet {

    void setVelEthernet(int Ethernet);

    int getVelEthernet();

    boolean CONNECTED = true;
    boolean DISCONECTED = false;

    void ConectarEthernet();

    void DesconectarEthernet();
}
