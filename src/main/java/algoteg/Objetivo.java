package algoteg;

import java.util.ArrayList;
import java.util.List;

public class Objetivo {
    List<Pais> paises ;
    List<Continente> continentes;
    Jugador jugador;
    String colorGobernante;
    public  Objetivo(List<Pais> paises, List<Continente> continentes){
        this.paises = paises;
        this.continentes = continentes;
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
        this.colorGobernante = jugador.getColor();
    }

    public boolean objetivoCumplido() {

        return((conquistoPaises() & conquistoContinentes()) | cumplioObjetivoGlobal());

    }

    private boolean conquistoPaises( ) {
        boolean paisesConquistados = true;
        int i = 0;
        while (paisesConquistados & i < paises.size()) {
            paisesConquistados = paises.get(i).esGobernante(this.colorGobernante);
            i++;
        }
        return paisesConquistados;
    }
    private boolean conquistoContinentes(){
        boolean continentesConquistados = true;
        int i = 0;
        while(continentesConquistados & i< continentes.size()){
            continentesConquistados = continentes.get(i).esGobernante(this.colorGobernante);
            i++;
        }
        return continentesConquistados;
    }
    private boolean cumplioObjetivoGlobal(){
        return(jugador.getCantidadPaisesConquistados() == 30);
    }
}

