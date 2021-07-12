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
        this.victoriasAtacante++;
    }
    private void agregarVictoriaAtacante(){
        this.victoriasDefensor++;
    }

    public Pais obtenerVictoriosoDeBatalla(int dadoAtacante, int dadoDefensor, Pais paisAtacante, Pais paisDefensor){
        Pais victoriosoBatalla = paisDefensor;
        if(dadoAtacante > dadoDefensor){
            victoriosoBatalla = paisAtacante;
            this.agregarVictoriaAtacante();
        }
        else {
            this.agregarVictoriaDefensor();
        }
        return(victoriosoBatalla);
    }

    private Pais determinarVictoriosoDeGuerra(Pais paisAtacante, Pais paisDefensor) {
        Pais victoriosoDeGuerra = paisDefensor;
        if(this.victoriasAtacante>this.victoriasDefensor) {
            victoriosoDeGuerra = paisAtacante;
        }
        return(victoriosoDeGuerra);
    }
    public Pais obtenerVictoriosoDeGuerra(List<Integer> dadosAtacante, List<Integer> dadosDefensor, Pais paisAtacante, Pais paisDefensor){
        while (!dadosAtacante.isEmpty() && !dadosDefensor.isEmpty()){
            Pais victoriosoBatalla = this.obtenerVictoriosoDeBatalla( dadosAtacante.remove(0), dadosDefensor.remove(0), paisAtacante, paisDefensor);
            victoriosoBatalla.reducirEjercito(1);

        }
        return(this.determinarVictoriosoDeGuerra(paisAtacante, paisDefensor));
    }
}
