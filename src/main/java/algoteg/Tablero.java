package algoteg;

import java.util.*;

public class Tablero {

    private List<Continente> continentes;
    private List<Pais> paises;
    private Dado dado;

    public Tablero(){
        Initialise init = new Initialise();
        this.continentes = init.getTodosLosContinentes();
        this.paises = init.getTodosLosPaises();

    }

    public void atacar(Pais paisAtacante, Pais paisDefensor, int numeroTropas){
        List<Integer> dadosAtacante = this.dado.obtenerDadosAtacante(numeroTropas );
        List<Integer> dadosDefensor = this.dado.obtenerDadosDefensor(paisDefensor.cantidadEjercito);
        Batalla batalla = new Batalla();
        batalla.obtenerVictoriosoDeGuerra(dadosAtacante,dadosDefensor, paisAtacante, paisDefensor);
    }

}
