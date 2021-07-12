package algoteg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Dado {


    public List<Integer> obtenerDadosAtacante(int cantidadTropas){
        List<Integer> dados = new ArrayList();

        int dadosPorTropa = cantidadTropas/2;
        for(int i = 0; i<=(dadosPorTropa); i++){
            dados.add( this.random());
        }
        return dados;
    }

    public List<Integer> obtenerDadosDefensor(int cantidadTropas){
        List<Integer> dados = new ArrayList<Integer>();
        int dadoExtra = 1;
        int dadosPorTropa = cantidadTropas/2;
        for(int i = 0; i<=(dadosPorTropa+dadoExtra); i++){
            dados.add( this.random());
        }
        return dados;

    }

    public int random(){

        Random random = new Random();
        return random.nextInt(7 - 1) + 1;

    }
}
