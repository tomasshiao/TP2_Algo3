package algoteg.modelo;

import java.util.*;

public class ObjetivoDeConquista implements Objetivo{
    private Jugador jugador;
    private String mensajeObjetivo;
    private Map<Continente,Integer> territorioAConquistar;
    int cantidadLimitrofesAConquistar;

    public ObjetivoDeConquista(Map<Continente, Integer> territorioAConquistar){
        this.territorioAConquistar = territorioAConquistar;
    }

    public ObjetivoDeConquista(Map<Continente, Integer> territorioAConquistar, int cantidadLimitrofesAConquistar){
        this.territorioAConquistar = territorioAConquistar;
        this.cantidadLimitrofesAConquistar = cantidadLimitrofesAConquistar;
    }

    @Override
    public boolean cumplido() {

//        if(!jugador) errorJugadorNoAsignado

        if(!this.territorioAConquistar.isEmpty()) {
            //guardo la cantidad de paises necesaria en una lista
            List<Integer> valores = new ArrayList<>(territorioAConquistar.values());
            //guardo los continentes en una lista
            List<Continente> continentes = new ArrayList<>(territorioAConquistar.keySet());

            //recorro las listas y verifico que el jugador tenga la cantidad de paises requeridos.
            for (int i = 0; i < territorioAConquistar.size(); i++) {
                int cantidadDePaisesDelJugadorEnContinente = 0;
                List<Pais> paisesDelContinente = continentes.get(i).getPaises();
                for (Pais p : paisesDelContinente)
                    if (jugador.getPaisesConquistados().contains(p))
                        cantidadDePaisesDelJugadorEnContinente++;
                if (cantidadDePaisesDelJugadorEnContinente < valores.get(i))
                    return false;
            }
        }

        if(this.cantidadLimitrofesAConquistar > 0)
            return verificarLimitrofes();

        return true;
    }

    private boolean verificarLimitrofes() {
        int cantidadLimitrofesJugador = 0;

        List<Pais> paisesConquistados = this.jugador.getPaisesConquistados();
        List<Pais> paisesRecorridos = new ArrayList<>();

        for(Pais p: paisesConquistados) {
            if (!paisesRecorridos.contains(p))
                for (Pais l: p.getPaisesLimitrofes())
                    if (paisesConquistados.contains(l))
                        cantidadLimitrofesJugador++;
            paisesRecorridos.add(p);
        }
        return (cantidadLimitrofesJugador >= this.cantidadLimitrofesAConquistar);
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
