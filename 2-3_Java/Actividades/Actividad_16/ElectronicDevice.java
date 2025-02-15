package Actividades.Actividad_16;

public abstract class ElectronicDevice {

  // Marca____________________________________________________
  public static final int NO_ESPECIFICADA = 0;
  public static final int APPLE = 1;
  public static final int SAMSUNG = 2;
  public static final int HP = 3;
  public static final int DELL = 4;
  public static final int HISENSE = 5;
  public static final int SONY = 6;

  protected int marca = NO_ESPECIFICADA;

  public void setMarca(int marca) {
    if (marca >= 1 && marca <= 6)
      this.marca = marca;
  }

  public int getMarca() {
    if (marca == NO_ESPECIFICADA)
      System.out.println("Marca no especificada");
    return marca;
  }

  // Pantalla_____________________________________________
  public int pantalla = 0;

  public void setPantalla(int pantalla) {
    if (pantalla >= 1)
      this.pantalla = pantalla;
  }

  public int getPantalla() {
    System.out.println("Medida de pantalla: " + pantalla + " pulgadas");
    return pantalla;
  }

  // Sistema_operativo________________________________________
  public static final int WINDOWS = 1;
  public static final int LINUX = 2;
  public static final int IOS = 3;
  public static final int ANDROID = 4;
  public static final int ANDROIDTV = 5;
  public static final int ROKU = 6;
  public static final int TIZEN = 7;
  public static final int WEBOS = 8;

  protected int sistema = NO_ESPECIFICADA;

  public void setSistema(int sistema) {
    if (sistema >= 1 && sistema <= 8)
      this.sistema = sistema;
  }

  public int getSistema() {
    if (sistema == NO_ESPECIFICADA)
      System.out.println("Sistema no especificado");
    return sistema;
  }

  // ON-OF____________________________________________________
  public boolean estado = true;

  public void getEstado() {
    if (estado == true)
      System.out.println("Dispositivo encendido");
    else
      System.out.println("Dispositivo apagado");
  }

  public void encender() {
    System.out.println("Encendiendo dispositivo");
    estado = true;
  }

  public void apagar() {
    System.out.println("Apagando dispositivo");
    estado = false;
  }

}
