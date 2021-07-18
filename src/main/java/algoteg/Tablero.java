package algoteg;

import algoteg.datosJuego.InitializePaisesYContinentes;

import java.util.*;

public class Tablero {

    private List<Continente> continentes;
    private List<Pais> paises;

    public void setContinentes(List<Continente> continentes){
        this.continentes = continentes;
    }
    public void setPaises(List<Pais>paises){
        this.paises = paises;
    }

    public void atacar(Pais paisAtacante, Pais paisDefensor, int numeroTropas){
        LanzadorDados lanzadorDados = new LanzadorDados();
        List<GeneradorRandom> dadosAtacante = lanzadorDados.obtenerDadosAtacante(paisAtacante, numeroTropas);
        List<GeneradorRandom> dadosDefensor = lanzadorDados.obtenerDadosDefensor(paisDefensor);
        Batalla batalla = new Batalla();
        batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacante, paisDefensor, numeroTropas);
    }

}
