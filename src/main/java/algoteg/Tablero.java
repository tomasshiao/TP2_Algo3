package algoteg;

import algoteg.Exceptions.*;

import java.util.*;

public class Tablero {

    private List<Continente> continentes;
    private List<Pais> paises;

    public void setContinentes(List<Continente> continentes){
        this.continentes = continentes;
    }
    public void setPaises(List<Pais>paises){
        this.paises = paises;
    }

    /*******
     * Realiza un ataque
     * @param jugadorAtacante Jugador Jugador atacante.
     * @param paisAtacante Pais país atacante.
     * @param paisDefensor Pais país defensor.
     * @param numeroTropas int número de tropas con la que se ataca.
     * @return Pais país ganador.
     * *********/
    public Pais atacar(Jugador jugadorAtacante, Pais paisAtacante, Pais paisDefensor, int numeroTropas) throws AtaqueInvalidoException {
        if(!paisAtacante.getPaisesLimitrofes().contains(paisDefensor)) {
            String exceptionType = "NoLimitrofe";
           throw new AtaqueInvalidoException(exceptionType);
        }
        if(paisAtacante.getEjercitoActual() < numeroTropas){
            String exceptionType = "TropasInsuficientes";
            throw new AtaqueInvalidoException(exceptionType);
        }
        if(!jugadorAtacante.getPaisesConquistados().contains(paisAtacante)){
            String exceptionType = "PaisNoMePertenece";
            throw new AtaqueInvalidoException(exceptionType);
        }
        if(jugadorAtacante.getPaisesConquistados().contains(paisDefensor)){
            String exceptionType = "ConquistarPaisPropio";
            throw new AtaqueInvalidoException(exceptionType);
        }
        LanzadorDados lanzadorDados = new LanzadorDados();
        List<GeneradorRandom> dadosAtacante = lanzadorDados.obtenerDadosAtacante(paisAtacante, numeroTropas);
        List<GeneradorRandom> dadosDefensor = lanzadorDados.obtenerDadosDefensor(paisDefensor);
        Batalla batalla = new Batalla();
        return batalla.obtenerVictoriosoDeGuerra(dadosAtacante, dadosDefensor, paisAtacante, paisDefensor, numeroTropas);
    }

    public List<Pais> getPaises(){
        return paises;
    }

    public Continente getContinente(String nombreContinente) {
        for(Continente c: this.continentes){
            String nombre = c.getNombre().toLowerCase();
            if(nombre.equals(nombreContinente))
                return c;
        }
        return null;//implementar continente no encontrado error
    }
}
