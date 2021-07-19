package algoteg;

import java.util.*;

public class ObjetivoPorConquista implements Objetivo {
    Map<Continente,Integer> mapaContinenteYCantidadPaises;
    Jugador jugador;
    public  ObjetivoPorConquista(Map<Continente, Integer> mapaContinenteYCantidadPaises){

        this.mapaContinenteYCantidadPaises = mapaContinenteYCantidadPaises;
    }
    @Override
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }
    @Override
    public boolean cumplido() {
        boolean cumplido = true;
        Iterator it = mapaContinenteYCantidadPaises.entrySet().iterator();
        while (it.hasNext() & cumplido) {
            Map.Entry par = (Map.Entry)it.next();
            Continente continente = (Continente) par.getKey();
            int cantPaisesNecesarios = (Integer) par.getValue();

            int paisesConquistadosDelContinente  = this.obtenerCantidadPaisesConquistadosDelContinente(continente);
            cumplido = paisesConquistadosDelContinente == cantPaisesNecesarios;
        }


        return cumplido;
    }


    private Integer obtenerCantidadPaisesConquistadosDelContinente(Continente continente) {
        List<Pais> paisesConquistadosDelContinente = continente.getConquistadosPor( jugador);
        return paisesConquistadosDelContinente.size();
    }

}

