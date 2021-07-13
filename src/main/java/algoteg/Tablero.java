package algoteg;

import java.util.List;

public class Tablero {

    private List<String> continentes;
    private Batalla batalla;
    private Dado dado;

    public Tablero(){
        this.continente = List.of("Asia","Oceania","America","Europa","Africa");
    }

    public void atacar(Pais paisAtacante, Pais paisDefensor, int numeroTropas){
        List<Integer> dadosAtacante = this.dado.obtenerDadosAtacante(numeroTropas );
        List<Integer> dadosDefensor = this.dado.obtenerDadosDefensor(paisDefensor.cantidadEjercito);
        this.batalla.obtenerVictoriosoDeGuerra(dadosAtacante,dadosDefensor, paisAtacante, paisDefensor);
    }

}
