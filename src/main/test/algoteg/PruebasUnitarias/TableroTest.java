package algoteg.PruebasUnitarias;

import algoteg.modelo.*;
import algoteg.Exceptions.*;
import algoteg.datosJuego.InitializePaisesYContinentes;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class TableroTest {
    InitializePaisesYContinentes init = new InitializePaisesYContinentes();
    private List<Continente> continentes = init.getTodosLosContinentes();
    private List<Pais> paises = init.getTodosLosPaises();
    private LanzadorDados lanzadorDados = mock(LanzadorDados.class);
    private Jugador j1 = mock(Jugador.class);
    private Continente c1 = mock(Continente.class);
    private Continente c2 = mock(Continente.class);
    private Dado dadoGanador = mock(Dado.class);
    private Dado dadoPerdedor = mock(Dado.class);
    private Dado dadoParaEmpate = mock(Dado.class);
    private List<GeneradorRandom> dadosGanadores = Arrays.asList(dadoGanador, dadoGanador);
    private List<GeneradorRandom> dadosPerdedores = Arrays.asList(dadoPerdedor, dadoPerdedor);
    private List<GeneradorRandom> dadosEmpardados = Arrays.asList(dadoParaEmpate, dadoParaEmpate);


    /**********************
     * Test constructor y getters.
     **********************/

     @Test 
     public void constructorYGettersFuncionanDebidamente(){
         Tablero tablero = new Tablero(continentes, paises, lanzadorDados);

         assertEquals(continentes, tablero.getContinentes());
         assertEquals(paises, tablero.getPaises());
     }

    /********************
     * Test setters funcionan bien
     ********************/
    @Test
    public void settersFuncionanCorrectamente(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Continente a = new Continente("A", 3);
        List<Continente> otrosContinentes = Collections.singletonList(a);
        Jugador p = new Jugador(2, "Ocre");
        Pais j = new Pais("J", p);
        Pais u = new Pais("U", p);
        List<Pais> otrosPaises = Arrays.asList(j, u);
        
        tablero.setContinentes(otrosContinentes);
        tablero.setPaises(otrosPaises);

        assertEquals(otrosContinentes, tablero.getContinentes());
        assertEquals(otrosPaises, tablero.getPaises());
    }

    /****************
     * Test Get continente
     * Caso positivo 1: se busca y encuentra un continente existente pasandole el nombre escrito correctamente.
     * Caso positivo 2: se busca y encuentra un continente existente pasandole el nombre escrito con mayúsculas y minúsculas que no corresponde.
     * Caso negativo: se busca un continente inexistente, debe levantar la excepcion ContinenteInexistente.
     ****************/
    @Test 
    public void getContinenteEncuentraAlContinenteBuscado1(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Continente buscado = this.continentes.get(0);
        String nombreBuscado = buscado.getNombre();

        try{
            assertEquals(buscado, tablero.getContinente(nombreBuscado));
        }catch(Exception e){
            return;
        }
    }

    @Test 
    public void getContinenteEncuentraAlContinenteBuscado2(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Continente buscado = this.continentes.get(0);
        String nombreBuscado = buscado.getNombre().toUpperCase();

        try{
            assertEquals(buscado, tablero.getContinente(nombreBuscado));
        }catch(Exception e){
            return;
        }
    }

    @Test
    public void getContinenteNoEncuentraAlContinenteBuscado(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        String nombreBuscado = "buscado.getNombre()";

        assertThrows(ContinenteInexistenteException.class, () -> {tablero.getContinente(nombreBuscado);});
    }


    /*******************
     * Test continentes gobernados por jugador.
     * Caso Positivo 1: el jugador domina al menos un continente.
     * Caso Positivo 2: el jugador domina todos los continentes.
     * Caso Negativo 1: el jugador no domina ningún continente.
     *******************/
    @Test 
    public void jugadorDominaUnContinenteDevuelveListaCorrecta1(){
        when(c1.esGobernante(j1)).thenReturn(false);
        when(c2.esGobernante(j1)).thenReturn(true);
        List<Continente> listaContinentes = Arrays.asList(c1, c2);
        
        Tablero tablero = new Tablero(listaContinentes, paises, lanzadorDados);
        
        assertEquals(1, tablero.getContinentesGobernadosPor(j1).size());
    }

    @Test 
    public void jugadorDominaUnContinenteDevuelveListaCorrecta2(){
        when(c1.esGobernante(j1)).thenReturn(true);
        when(c2.esGobernante(j1)).thenReturn(false);
        List<Continente> listaContinentes = Arrays.asList(c1, c2);
        
        Tablero tablero = new Tablero(listaContinentes, paises, lanzadorDados);
        
        assertEquals(1, tablero.getContinentesGobernadosPor(j1).size());
    }

    @Test 
    public void jugadorDominaTodosLosContinentesDevuelveListaCorrecta(){
        when(c1.esGobernante(j1)).thenReturn(true);
        when(c2.esGobernante(j1)).thenReturn(true);
        List<Continente> listaContinentes = Arrays.asList(c1, c2);
        
        Tablero tablero = new Tablero(listaContinentes, paises, lanzadorDados);
        
        assertEquals(2, tablero.getContinentesGobernadosPor(j1).size());
    }

    @Test 
    public void jugadorNoDominaNingunContinentDevuelveListaCorrecta(){
        when(c1.esGobernante(j1)).thenReturn(false);
        when(c2.esGobernante(j1)).thenReturn(false);
        List<Continente> listaContinentes = Arrays.asList(c1, c2);
        
        Tablero tablero = new Tablero(listaContinentes, paises, lanzadorDados);
        
        assertEquals(0, tablero.getContinentesGobernadosPor(j1).size());
    }

    /***********************
     * Test atacar un país
     * Caso 1: los países belignantes no son limítrofes.
     * Caso 2: el país atacante no tiene tropas suficientes para realizar el ataque.
     * Caso 3: el país atacante no le pertenece al jugador atacante.
     * Caso 4: intento de conquista a un país que ya le pertenece al jugador atacante.
     * Caso 5: los dos países son limítrofes, pertenecen a distintos jugadores y las tropas alcanzan con atacante de ganador.
     * Caso 6: los dos países son limítrofes, pertenecen a distintos jugadores y las tropas alcanzan con defensor de ganador.
     * Caso 7: los dos países son limítrofes, pertenecen a distintos jugadores y las tropas alcanzan con defensor de ganador por empate.
     ***********************/
    @Test
    public void paisesBelignantesNoLimitrofes(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Pais p1 = paises.get(0);
        Pais p2 = paises.get(paises.size() - 1);
        
        assertThrows(AtaqueInvalidoException.class, () -> {tablero.atacar(j1, p1, p2, 2);});
    }

    @Test
    public void paisAtacanteNoTieneTropasSuficientesParaAtacar(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Pais p1 = mock(Pais.class);
        Pais p2 = mock(Pais.class);
        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
        when(p2.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p1));
        when(p1.getEjercitoActual()).thenReturn(2);

        assertThrows(AtaqueInvalidoException.class, () -> {tablero.atacar(j1, p1, p2, 5);});
    }

    @Test
    public void paisAtacanteNoLePerteneceAlAtacante(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Pais p1 = mock(Pais.class);
        Pais p2 = mock(Pais.class);
        Pais p3 = mock(Pais.class);
        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
        when(p2.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p1));
        when(j1.getPaisesConquistados()).thenReturn(Collections.singletonList(p3));
        when(p1.getEjercitoActual()).thenReturn(5);

        assertThrows(AtaqueInvalidoException.class, () -> {tablero.atacar(j1, p1, p2, 2);});
    }

    @Test
    public void paisAConquistarYaLePerteneceAlAtacante(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Pais p1 = mock(Pais.class);
        Pais p2 = mock(Pais.class);
        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
        when(p2.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p1));
        when(j1.getPaisesConquistados()).thenReturn(Arrays.asList(p1, p2));
        when(p1.getEjercitoActual()).thenReturn(5);

        assertThrows(AtaqueInvalidoException.class, () -> {tablero.atacar(j1, p1, p2, 2);});
    }

    @Test 
    public void realizarUnAtaqueValidoSeObtieneGanadorCorrecto1(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Pais p1 = mock(Pais.class);
        Pais p2 = mock(Pais.class);
        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
        when(p2.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p1));
        when(j1.getPaisesConquistados()).thenReturn(Collections.singletonList(p1));
        int numeroTropas = 2;
        when(dadoGanador.getValor()).thenReturn(6);
        when(dadoPerdedor.getValor()).thenReturn(3);
        when(lanzadorDados.obtenerDadosAtacante(p1, numeroTropas)).thenReturn(dadosGanadores);
        when(lanzadorDados.obtenerDadosDefensor(p2)).thenReturn(dadosPerdedores);

        try{
            assertEquals(p1, tablero.atacar(j1, p1, p2, 2));
        }catch(Exception e){
            return;
        }
    }

    @Test 
    public void realizarUnAtaqueValidoSeObtieneGanadorCorrecto2(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Pais p1 = mock(Pais.class);
        Pais p2 = mock(Pais.class);
        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
        when(p2.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p1));
        when(j1.getPaisesConquistados()).thenReturn(Collections.singletonList(p1));
        int numeroTropas = 2;
        when(dadoGanador.getValor()).thenReturn(2);
        when(dadoPerdedor.getValor()).thenReturn(1);
        when(lanzadorDados.obtenerDadosAtacante(p1, numeroTropas)).thenReturn(dadosPerdedores);
        when(lanzadorDados.obtenerDadosDefensor(p2)).thenReturn(dadosGanadores);

        try{
            assertEquals(p2, tablero.atacar(j1, p1, p2, 2));
        }catch(Exception e){
            return;
        }
    }

    @Test 
    public void realizarUnAtaqueValidoSeObtieneGanadorCorrecto3(){
        Tablero tablero = new Tablero(continentes, paises, lanzadorDados);
        Pais p1 = mock(Pais.class);
        Pais p2 = mock(Pais.class);
        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
        when(p2.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p1));
        when(j1.getPaisesConquistados()).thenReturn(Collections.singletonList(p1));
        int numeroTropas = 2;
        when(dadoParaEmpate.getValor()).thenReturn(5);
        when(lanzadorDados.obtenerDadosAtacante(p1, numeroTropas)).thenReturn(dadosEmpardados);
        when(lanzadorDados.obtenerDadosDefensor(p2)).thenReturn(dadosEmpardados);

        try{
            assertEquals(p2, tablero.atacar(j1, p1, p2, 2));
        }catch(Exception e){
            return;
        }
    }
}
