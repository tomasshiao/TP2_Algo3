package algoteg;

import java.util.ArrayList;
import java.util.List;

public class ObjetivoPorDestruccion implements Objetivo {
    private List<Pais> paisesConquistados;
    private ArrayList<Jugador> listaJugadores;
    private String colorADestruir;
    private Jugador jugador;
    
    public ObjetivoPorDestruccion(String color, ArrayList<Jugador> listaJugadores){
        this.colorADestruir = color;
        this.listaJugadores = listaJugadores;
    }

    @Override
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public Jugador getJugador(){
        return this.jugador;
    }

    public String getColorADestruir(){
        return this.colorADestruir;
    }

    private String determinarColorADestruir(){
        for(Jugador jugador: listaJugadores)
            if(!jugador.getColor().contains(this.colorADestruir)){
                int idJugador = this.getJugador().getId();
                int idADestruir = nextId(idJugador);
                this.colorADestruir = buscarColorPorId(idADestruir);
            }
        return this.colorADestruir;
    }

    private int nextId(int id){
        int cantidadJugadores = listaJugadores.size();
        int idADestruir = id+1;

        if(id == cantidadJugadores)
            idADestruir = 1;

        return idADestruir;
    }

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
