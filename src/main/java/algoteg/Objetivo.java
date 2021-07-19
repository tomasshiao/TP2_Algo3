package algoteg;

public interface Objetivo {

    boolean cumplido();
    void setJugador(Jugador jugador);
    String verObjetivo();
    void setMensajeObjetivo(String mensajeObjetivo);
}
