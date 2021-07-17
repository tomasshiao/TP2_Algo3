package algoteg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BatallaMock {
    private int victoriasAtacante;
    private int victoriasDefensor;

    public BatallaMock(){
        this.victoriasAtacante = 0;
        this.victoriasDefensor =0;

    }
    private void agregarVictoriaDefensor(){
        this.victoriasDefensor++;
    }
    private void agregarVictoriaAtacante(){
        this.victoriasAtacante++;
    }

    public Pais obtenerPerdedorDeBatalla(Dado dadoAtacante, Dado dadoDefensor, Pais paisAtacante, Pais paisDefensor){
        Pais perdedorDeBatalla = paisAtacante;
        if(dadoAtacante.getValor() > dadoDefensor.getValor()){
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
    public Pais obtenerVictoriosoDeGuerra(Pais paisAtacante, Pais paisDefensor){
        List<Dado> dadosAtacante = obtenerDadosAtacante(paisAtacante);
        List<Dado> dadosDefensor = obtenerDadosDefensor(paisDefensor);

        while (!dadosAtacante.isEmpty() && !dadosDefensor.isEmpty()){
            Pais perdedorDeBatalla = this.obtenerPerdedorDeBatalla( dadosAtacante.remove(0), dadosDefensor.remove(0), paisAtacante, paisDefensor);
            perdedorDeBatalla.reducirEjercito(1);

        }
        return(this.determinarVictoriosoDeGuerra(paisAtacante, paisDefensor));
    }

    public List<Dado> obtenerDadosAtacante(Pais paisAtacante){
        List<Dado> dados = new ArrayList<>();
        int cantidadTropas = paisAtacante.getEjercitoActual();
        int dadosPorTropa;

        if(cantidadTropas >= 4)
            dadosPorTropa = 3;
        else dadosPorTropa = (cantidadTropas-1);
        //i < (cantidadTropas -1) || i < 3
        for(int i = 0; i<(dadosPorTropa); i++){
            dados.add( new Dado());
        }
        dados.sort(Comparator.comparing(Dado::getValor).reversed());
        return (dados);
    }
    public List<Dado> obtenerDadosDefensor(Pais paisDefensor){
        int cantidadTropas = paisDefensor.getEjercitoActual();
        List<Dado> dados = new ArrayList<>();
        int dadoExtra = 1;
        int dadosPorTropa = cantidadTropas/2;
        for(int i = 0; i<=(dadosPorTropa+dadoExtra); i++){
            Dado dadomock = mock(Dado.class);
            when(dadomock.getValor()).thenReturn(0);
            dados.add(dadomock);
        }
        dados.sort(Comparator.comparing(Dado::getValor).reversed());
        return (dados);


    }

}
