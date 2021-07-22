package algoteg;

import java.util.*;

public class Batalla {
    private int victoriasAtacante;
    private int victoriasDefensor;
    private int dadosParaTirarAtacante;
    private int dadosParaTirarDefensor;

    public Batalla(){
        this.victoriasAtacante = 0;
        this.victoriasDefensor =0;
        this.dadosParaTirarAtacante = 0;
        this.dadosParaTirarDefensor = 0;
    }

    private void agregarVictoriaDefensor(){
        this.victoriasDefensor++;
    }
    private void agregarVictoriaAtacante(){
        this.victoriasAtacante++;
    }

    public Pais obtenerPerdedorDeBatalla(GeneradorRandom dadoAtacante, GeneradorRandom dadoDefensor, Pais paisAtacante, Pais paisDefensor){
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
        if(this.victoriasAtacante>this.victoriasDefensor ) {
            victoriosoDeGuerra = paisAtacante;
            if (paisDefensor.noTengoTropas()){
                paisAtacante.ocupar(paisDefensor);
            }
        }
        return(victoriosoDeGuerra);
    }
    public Pais obtenerVictoriosoDeGuerra(List<GeneradorRandom> dadosAtacante, List<GeneradorRandom> dadosDefensor, Pais paisAtacante, Pais paisDefensor, int tropasParaAtacar){

        while (!dadosAtacante.isEmpty() && !dadosDefensor.isEmpty()){
            Pais perdedorDeBatalla = this.obtenerPerdedorDeBatalla( dadosAtacante.remove(0), dadosDefensor.remove(0), paisAtacante, paisDefensor);
            perdedorDeBatalla.reducirEjercito(1);

        }
        return this.determinarVictoriosoDeGuerra(paisAtacante, paisDefensor);
    }
/*
    public List<Dado> obtenerDadosAtacante(Pais pais, int tropasParaAtacar){
        List<Dado> dados = new ArrayList<>();
        int tropasEnPais = pais.getEjercitoActual();

        if(tropasParaAtacar > tropasEnPais-1)   //si quiero atacar con mas tropas de las que tengo en el pais,
            tropasParaAtacar = tropasEnPais-1;  //solo me va a dejar atacar con el maximo que pueda ese pais

        if(tropasParaAtacar >= 4)    //si se quiere atacar con muchas tropas, solo se puede tirar hasta 3 dados
            this.dadosParaTirarAtacante = 3;
        else this.dadosParaTirarAtacante = tropasParaAtacar;

        for(int i = 0; i<this.dadosParaTirarAtacante; i++){
            dados.add (new Dado());
        }
        dados.sort(Comparator.comparing(Dado::getValor).reversed());
        return (dados);
    }

    public List<Dado> obtenerDadosDefensor(Pais pais){
        List<Dado> dados = new ArrayList<>();
        int tropasEnPais = pais.getEjercitoActual();

        if(tropasEnPais >= 3)   //se defiende con un maximo de 3 dados
            this.dadosParaTirarDefensor = 3;
        else this.dadosParaTirarDefensor = tropasEnPais;

        for(int i = 0; i< this.dadosParaTirarDefensor; i++){
            dados.add (new Dado());
        }
        dados.sort(Comparator.comparing(Dado::getValor).reversed());
        return (dados);
    }

    public int getDadosParaTirarAtacante() {
        return dadosParaTirarAtacante;
    }
    public int getDadosParaTirarDefensor(){
        return dadosParaTirarDefensor;
    }*/
}
