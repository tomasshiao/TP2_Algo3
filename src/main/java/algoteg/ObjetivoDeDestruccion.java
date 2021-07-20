package algoteg;

import java.util.ArrayList;
import java.util.List;

public class ObjetivoDeDestruccion implements Objetivo {
    private List<Pais> paisesConquistados;
    private ArrayList<Jugador> listaJugadores;
    private String colorADestruir;
    private Jugador jugador;
    private String mensajeObjetivo;
    
    public ObjetivoDeDestruccion(String color, ArrayList<Jugador> listaJugadores){
        this.colorADestruir = color;
        this.listaJugadores = listaJugadores;
    }

    @Override
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    //Mensaje que se muestra al jugador para que conozca su objetivo
    @Override
    public void setMensajeObjetivo(String mensaje){
        this.mensajeObjetivo = mensaje;
    }

    public Jugador getJugador(){
        return this.jugador;
    }

    public String getColorADestruir(){
        return this.colorADestruir;
    }

    public String getMensajeObjetivo(){
        return this.mensajeObjetivo;
    }

    //Segun el objetivo y la cantidad de jugadores, se verifica cual es el ejercito que se debe deestruir
    private String determinarColorADestruir(){
        for(Jugador jugador: listaJugadores)
            if(!jugador.getColor().contains(this.colorADestruir)){
                int idJugador = this.getJugador().getId();
                int idADestruir = nextId(idJugador);
                this.colorADestruir = buscarColorPorId(idADestruir);
            }
        return this.colorADestruir;
    }

    //Devuelve el jugador que tiene un turno siguiente al actual
    private int nextId(int id){
        int cantidadJugadores = listaJugadores.size();
        int idADestruir = id+1;

        if(id == cantidadJugadores)
            idADestruir = 1;

        return idADestruir;
    }

    //Por medio de el id del jugador, determina cual es el color que corresponde al mismo
    private String buscarColorPorId(int idADestruir){
        String colorADestruir = "";
        for(Jugador jugador: listaJugadores)
            if(jugador.getId() == idADestruir)
                colorADestruir = jugador.getColor();
        return colorADestruir;
    }

    public boolean cumplido(){
        String colorADestruir = determinarColorADestruir();
        Jugador jugadorADestuir = null;
        for(Jugador jugador: listaJugadores)
            if(jugador.getColor().equals(colorADestruir))
                jugadorADestuir = jugador;
        return (jugadorADestuir.getCantidadPaisesConquistados() == 0);
    }
}
