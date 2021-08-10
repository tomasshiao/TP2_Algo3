package algoteg.modelo;

import java.util.*;

public class Batalla {
    private int victoriasAtacante;
    private int victoriasDefensor;
    private int dadosParaTirarAtacante;
    private int dadosParaTirarDefensor;

    public Batalla() {
        this.victoriasAtacante = 0;
        this.victoriasDefensor = 0;
        this.dadosParaTirarAtacante = 0;
        this.dadosParaTirarDefensor = 0;
    }

    private void agregarVictoriaDefensor() {
        this.victoriasDefensor++;
    }

    private void agregarVictoriaAtacante() {
        this.victoriasAtacante++;
    }

    public Pais obtenerPerdedorDeBatalla(GeneradorRandom dadoAtacante, GeneradorRandom dadoDefensor, Pais paisAtacante, Pais paisDefensor) {
        Pais perdedorDeBatalla = paisAtacante;
        if (dadoAtacante.getValor() > dadoDefensor.getValor()) {
            perdedorDeBatalla = paisDefensor;
            this.agregarVictoriaAtacante();
        } else {
            this.agregarVictoriaDefensor();
        }
        return (perdedorDeBatalla);
    }

    private Pais determinarVictoriosoDeGuerra(Pais paisAtacante, Pais paisDefensor) {
        Pais victoriosoDeGuerra = paisDefensor;
        if (this.victoriasAtacante > this.victoriasDefensor) {
            victoriosoDeGuerra = paisAtacante;
            if (paisDefensor.noTengoTropas()) {
                paisAtacante.ocupar(paisDefensor);
            }
        }
        return (victoriosoDeGuerra);
    }

    public Pais obtenerVictoriosoDeGuerra(List<GeneradorRandom> dadosAtacante, List<GeneradorRandom> dadosDefensor, Pais paisAtacante, Pais paisDefensor, int tropasParaAtacar) {

        while (!dadosAtacante.isEmpty() && !dadosDefensor.isEmpty()) {
            Pais perdedorDeBatalla = this.obtenerPerdedorDeBatalla(dadosAtacante.remove(0), dadosDefensor.remove(0), paisAtacante, paisDefensor);
            perdedorDeBatalla.reducirEjercito(1);

        }
        return this.determinarVictoriosoDeGuerra(paisAtacante, paisDefensor);
    }
}
