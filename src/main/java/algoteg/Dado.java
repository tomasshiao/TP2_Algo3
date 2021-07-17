package algoteg;

import java.util.Random;

public class Dado{
    int valor;
    public Dado(){
        valor = this.obtenerDado();
    }
    private int obtenerDado(){
        Random random = new Random();
        return random.nextInt(7 - 1) + 1;
    }

    public int getValor(){ return this.valor;}

    public boolean esMayorQue(Dado dadoAComparar){
        return (this.valor >dadoAComparar.getValor());
    }
}
