package algoteg.modelo;

import java.util.Random;

public class Dado implements GeneradorRandom{
    int valor;
    public Dado(){
        valor = this.obtenerDado();
    }


    private int obtenerDado(){
        Random random = new Random();
        return random.nextInt(7 - 1) + 1;
    }

    @Override
    public int getValor(){ return this.valor;}

    public boolean esMayorQue(Dado dadoAComparar){
        return (this.valor >dadoAComparar.getValor());
    }


}
