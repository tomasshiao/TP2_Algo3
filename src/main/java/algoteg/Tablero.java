package algoteg;

import java.util.List;

public class Tablero {

    private List<String> continente;
    private Dado dado;

    public Tablero(){
        this.continente = List.of("Asia","Oceania","America","Europa","Africa");
    }

    public void atacar(Pais paisAtacante, Pais paisDefensor, int numeroTropas){
        List<Integer> dadosAtacante = this.dado.obtenerDadosAtacante(numeroTropas );
        List<Integer> dadosDefensor = this.dado.obtenerDadosDefensor(paisDefensor.cantidadEjercito);
        Batalla batalla = new Batalla();
        batalla.obtenerVictoriosoDeGuerra(dadosAtacante,dadosDefensor, paisAtacante, paisDefensor);
    }

}
