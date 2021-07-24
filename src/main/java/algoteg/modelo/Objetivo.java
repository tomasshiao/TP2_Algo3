package algoteg.modelo;

public interface Objetivo {

    boolean cumplido();
    void setJugador(Jugador jugador);
    void setMensajeObjetivo(String mensajeObjetivo);
    String getMensajeObjetivo();
}
