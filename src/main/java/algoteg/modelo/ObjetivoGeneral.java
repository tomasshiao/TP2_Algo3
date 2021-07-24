package algoteg.modelo;


public class ObjetivoGeneral implements Objetivo{
    Jugador jugador;
    String mensajeObjetivo;

    public ObjetivoGeneral(Jugador jugador) {
        this.jugador = jugador;
    }


    @Override
    public boolean cumplido() {
        return (this.jugador.getCantidadPaisesConquistados()  > 29);
    }

    @Override
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void setMensajeObjetivo(String mensajeObjetivo) {
        this.mensajeObjetivo = mensajeObjetivo;
    }

    @Override
    public String getMensajeObjetivo() {
        return this.mensajeObjetivo;
    }
}