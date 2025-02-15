package Actividades.Actividad_16;

public class SmartTV extends ElectronicDevice implements Wifi, Ethernet {

    public static final String type = "SmartTV";

    static {
        System.out.println("\nCreando SmartTV");
    }

    public void getConectinType() {
        if (wifiConnected == true)
            System.out.println("Conectado a Wifi");
        else if (wifiConnected == true)
            System.out.println("Conectado a Ethernet");
        else
            System.out.println("Sin conexión");
    }

    // Wifi__________________________________________________
    private boolean wifiConnected = true;
    private int wiFiType;

    @Override
    public void setWiFiType(int wiFiType) {
        this.wiFiType = wiFiType;
    }

    @Override
    public int getWifi() {
        System.out.println("Tipo de Wifi: " + wiFiType);
        return wiFiType;
    }

    @Override
    public void ConectarWifi() {
        wifiConnected = true;
        ethernetConnected = false;
        System.out.println("Conectando a Wifi");
    }

    @Override
    public void DesconectarWifi() {
        wifiConnected = false;
        System.out.println("Desconectando Wifi");
    }

    // Ethernet_______________________________________________
    private int vel_Ethernet = 0;
    private boolean ethernetConnected = false;

    @Override
    public void setVelEthernet(int vel_Ethernet) {
        this.vel_Ethernet = vel_Ethernet;
    }

    @Override
    public int getVelEthernet() {
        System.out.println("Velocidad Ethernet: " + vel_Ethernet);
        return vel_Ethernet;
    }

    @Override
    public void ConectarEthernet() {
        ethernetConnected = true;
        wifiConnected = false;
        System.out.println("Conectando a Ethernet");
    }

    @Override
    public void DesconectarEthernet() {
        ethernetConnected = false;
        System.out.println("Desconectando Ethernet");
    }

    // Extras________________________________________________
    private int apps = 12;

    public void setApps(int apps) {
        this.apps = apps;
    }

    public void InstalarApp() {
        apps += 1;
        System.out.println("Instalando aplicación");
        System.out.println("Hay " + apps + " apps");
    }

    public void DesinstalarApp() {
        if (apps >= 1) {
            System.out.println("Desinstalando aplicación");
            apps -= 1;
            System.out.println(apps + " apps restantes");
        } else
            System.out.println("Ya no quedan aplicaciones");
    }

}
