package Actividades.Actividad_16;

public interface Wifi {
	boolean CONNECTED = true;
	boolean DISCONECTED = false;
	int WIFI2_4 = 2;
	int WIFI5 = 5;
	int WIFI6 = 6;
	
	void ConectarWifi();
    void DesconectarWifi();
	
	void setWiFiType(int wiFiType);
    int getWifi();
}

