package algoteg;

import java.util.List;

public class Batalla {
    private int victoriasAtacante;
    private int victoriasDefensor;

    public Batalla(){
        this.victoriasAtacante = 0;
        this.victoriasDefensor =0;

    }
    private void agregarVictoriaDefensor(){
        this.victoriasDefensor++;
    }
    private void agregarVictoriaAtacante(){
        this.victoriasAtacante++;
    }

    public Pais obtenerPerdedorDeBatalla(int dadoAtacante, int dadoDefensor, Pais paisAtacante, Pais paisDefensor){
        Pais perdedorDeBatalla = paisAtacante;
        if(dadoAtacante > dadoDefensor){
            perdedorDeBatalla = paisDefensor;
            this.agregarVictoriaAtacante();
        }
        else {
            this.agregarVictoriaDefensor();
        }
        return(perdedorDeBatalla);
    }

    private Pais determinarVictoriosoDeGuerra(Pais paisAtacante, Pais paisDefensor) {
        Pais victoriosoDeGuerra = paisDefensor;
        if(this.victoriasAtacante>this.victoriasDefensor) {
            victoriosoDeGuerra = paisAtacante;
            paisAtacante.ocupar(paisDefensor);
        }
        return(victoriosoDeGuerra);
    }
    public Pais obtenerVictoriosoDeGuerra(List<Integer> dadosAtacante, List<Integer> dadosDefensor, Pais paisAtacante, Pais paisDefensor){
        while (!dadosAtacante.isEmpty() && !dadosDefensor.isEmpty()){
            Pais perdedorDeBatalla = this.obtenerPerdedorDeBatalla( dadosAtacante.remove(0), dadosDefensor.remove(0), paisAtacante, paisDefensor);
            perdedorDeBatalla.reducirEjercito(1);

        }
        return(this.determinarVictoriosoDeGuerra(paisAtacante, paisDefensor));
    }
}
