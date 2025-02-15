package Actividades.Actividad_16;

public class Telefono extends ElectronicDevice implements Bateria, Wifi {

    public static final String type = "Teléfono";

    static {
        System.out.println("\nCreando Teléfono");
    }

    public void getConectinType() {
        if (wifiConnected == true)
            System.out.println("Conectado a Wifi");
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
        System.out.println("Conectando a Wifi");
    }

    @Override
    public void DesconectarWifi() {
        wifiConnected = false;
        System.out.println("Desconectando Wifi");
    }

    // Bateria________________________________________________
    private int capacidad = 4500;
    private int porcentaje_carga = 55;
    private boolean conectado = false;

    @Override
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public int getCapacidad() {
        System.out.println("Capacidad de batería: " + capacidad + " miliampers");
        return capacidad;
    }

    @Override
    public void setPorcentajeCarga(int porcentaje_carga) {
        if (porcentaje_carga >= 0 && porcentaje_carga <= 100)
            this.porcentaje_carga = porcentaje_carga;
    }

    @Override
    public int GetPorcentajeCarga() {
        System.out.println("Porcentaje de carga: " + porcentaje_carga);
        return porcentaje_carga;
    }

    @Override
    public void CargarPila() {
        conectado = true;
        System.out.println("Cargando batería");

    }

    @Override
    public void DesconectarPila() {
        conectado = false;
        System.out.println("Desconectando batería");
    }

    // Extras________________________________________________
    public void HacerLlamada() {
        System.out.println("Llamando");
    }

    private int apps = 6;

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
