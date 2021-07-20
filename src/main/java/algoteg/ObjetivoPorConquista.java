package algoteg;

import java.util.*;

public class ObjetivoPorConquista implements Objetivo {
    private Map<Continente,Integer> mapaContinenteYCantidadPaises = new HashMap<>();
    private Jugador jugador;
    private String colorGobernante;
    private String mensajeObjetivo;

    public  ObjetivoPorConquista(List<Continente> continentes, List<Integer> paisesConquistados){

        for(int i = 0; i< continentes.size(); i++){
            mapaContinenteYCantidadPaises.put(continentes.get(i), paisesConquistados.get(i));
        }
    }
    @Override
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
        this.colorGobernante = jugador.getColor();
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

    @Override
    public void setMensajeObjetivo(String mensaje){
        this.mensajeObjetivo = mensaje;
    }

    @Override
    public String getMensajeObjetivo(){
        return this.mensajeObjetivo;
    }

    private Integer obtenerCantidadPaisesConquistadosDelContinente(Continente continente) {
        List<Pais> paisesConquistadosDelContinente = continente.getConquistadosPor( colorGobernante);
        return paisesConquistadosDelContinente.size();
    }

}

