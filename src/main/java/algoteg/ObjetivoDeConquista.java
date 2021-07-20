package algoteg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjetivoDeConquista implements Objetivo{
    private Jugador jugador;
    private String mensajeObjetivo;
    private Map<Continente,Integer> territorioAConquistar = new HashMap<>();

    public ObjetivoDeConquista(Map<Continente, Integer> territorioAConquistar){
        this.territorioAConquistar = territorioAConquistar;
    }

    @Override
    public boolean cumplido() {

        List<Integer> valores = new ArrayList<>();
        List<Continente> continentes = new ArrayList<>();
        for(Integer i: territorioAConquistar.values()) {
            valores.add(i);             //guardo la cantidad de paises necesaria en una lista
        }
        for(Continente c: territorioAConquistar.keySet())
            continentes.add(c);         //guardo los continentes en una lista

        //recorro las listas y verifico que el jugador tenga la cantidad de paises requeridos.
        for(int i=0; i<territorioAConquistar.size(); i++){
            int cantidadDePaisesDelJugadorEnContinente = 0;
            List<Pais> paisesDelContinente = continentes.get(i).getPaises();
            for(Pais p: paisesDelContinente)
                if(jugador.getPaisesConquistados().contains(p))
                    cantidadDePaisesDelJugadorEnContinente++;
            if(cantidadDePaisesDelJugadorEnContinente < valores.get(i))
                return false;
        }
        return true;
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
