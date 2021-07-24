package algoteg.PruebasUnitarias;

import algoteg.modelo.Dado;
import algoteg.modelo.GeneradorRandom;

public class DadoStub implements GeneradorRandom {
    int valor;

    public DadoStub(int valor){
        this.valor = valor;
    }

    @Override
    public int getValor(){
        return valor;
    }
    public boolean esMayorQue(Dado dadoAComparar){
        return (this.valor >dadoAComparar.getValor());
    }

}
