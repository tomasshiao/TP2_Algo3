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

        Batalla batalla = new Batalla();
        batalla.obtenerVictoriosoDeGuerra(paisAtacante, paisDefensor, numeroTropas);
    }

}
