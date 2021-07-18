package algoteg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LanzadorDados {
    public int dadosParaTirarAtacante;
    public int dadosParaTirarDefensor;

    public LanzadorDados(){
        dadosParaTirarAtacante=0;
        dadosParaTirarDefensor=0;
    }
    public List<GeneradorRandom> obtenerDadosAtacante(Pais pais, int tropasParaAtacar){
        List<GeneradorRandom> dados = new ArrayList<>();
        int tropasEnPais = pais.getEjercitoActual();

        if(tropasParaAtacar > tropasEnPais-1)   //si quiero atacar con mas tropas de las que tengo en el pais,
            tropasParaAtacar = tropasEnPais-1;  //solo me va a dejar atacar con el maximo que pueda ese pais

        if(tropasParaAtacar >= 4)    //si se quiere atacar con muchas tropas, solo se puede tirar hasta 3 dados
            this.dadosParaTirarAtacante = 3;
        else this.dadosParaTirarAtacante = tropasParaAtacar;

        for(int i = 0; i<this.dadosParaTirarAtacante; i++){
            dados.add (new Dado());
        }
        dados.sort(Comparator.comparing(GeneradorRandom::getValor).reversed());
        return (dados);
    }
    public List<GeneradorRandom> obtenerDadosDefensor(Pais pais){
        List<GeneradorRandom> dados = new ArrayList<>();
        int tropasEnPais = pais.getEjercitoActual();

        if(tropasEnPais >= 3)   //se defiende con un maximo de 3 dados
            this.dadosParaTirarDefensor = 3;
        else this.dadosParaTirarDefensor = tropasEnPais;

        for(int i = 0; i< this.dadosParaTirarDefensor; i++){
            dados.add (new Dado());
        }
        dados.sort(Comparator.comparing(GeneradorRandom::getValor).reversed());
        return (dados);
    }

    public int getDadosParaTirarAtacante() {
        return dadosParaTirarAtacante;
    }

    public int getDadosParaTirarDefensor() {
        return dadosParaTirarDefensor;
    }
}
