package algoteg.PruebasUnitarias;

import algoteg.datosJuego.*;
import algoteg.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//public class TurnoAtaqueTest {
//    private Jugador jugador = mock(Jugador.class);
//    private Pais paisAtacante = mock(Pais.class);
//    private Pais paisDefensor = mock(Pais.class);
//    private List<Continente> continentes = (new InitializePaisesYContinentes()).getTodosLosContinentes();
//    private List<Pais> paises = (new InitializePaisesYContinentes()).getTodosLosPaises();
//    private LanzadorDados lanzadorDados = new LanzadorDados();
////    private Tablero tablero = new Tablero(continentes, paises, lanzadorDados);

    
    /***************
     * Test constructor y getters.
     ***************/
//    @Test
//    public void constructorYGettersFuncionanDebidamente(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        assertEquals(this.tablero, ra.getTablero());
//        assertEquals(this.jugador, ra.getJugadorActual());
//    }
//
//    /*******************
//     * Test atacar
//     * Caso ataque se pudo realizar: debe devolver null.
//     * Caso ataque no se pudo realizar: debe resolver el mensaje correspondiente al error.
//     *******************/
//    @Test
//    public void paisesBelignantesNoLimitrofes(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(new ArrayList<Pais>());
//        String expected = "No se puede atacar a un país que no es límitrofe.";
//
//        try{
//            assertEquals(expected, ra.atacar(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    @Test
//    public void paisAtacanteNoTieneTropasSuficientesParaAtacar(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
//        when(p1.getEjercitoActual()).thenReturn(1);
//        String expected = "No tiene tropas suficientes para atacar.";
//
//        try{
//            assertEquals(expected, ra.atacar(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    @Test
//    public void paisAtacanteNoLePerteneceAlAtacante(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
//        when(p1.getEjercitoActual()).thenReturn(7);
//        when(this.jugador.getPaisesConquistados()).thenReturn(new ArrayList<Pais>());
//        String expected = "No puede atacar desde un país que no le pertenece.";
//        try{
//            assertEquals(expected, ra.atacar(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    @Test
//    public void paisAConquistarYaLePerteneceAlAtacante(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
//        when(p1.getEjercitoActual()).thenReturn(7);
//        when(this.jugador.getPaisesConquistados()).thenReturn(Arrays.asList(p1, p2));
//        String expected = "No puede conquistar un país que ya le pertenece.";
//        try{
//            assertEquals(expected, ra.atacar(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    @Test
//    public void ataqueSePuedeRealizarCorrectamente(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
//        when(p1.getEjercitoActual()).thenReturn(7);
//        when(this.jugador.getPaisesConquistados()).thenReturn(Collections.singletonList(p1));
//        String expected = null;
//        try{
//            assertEquals(expected, ra.atacar(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    /*********************
//     * Test Mover Ejército.
//     * Caso no se pudo mover el ejército: debe devolver el mensaje de error correspondiente.
//     * Caso se pudo mover el ejército: debe devolver null.
//     *********************/
//    @Test
//    public void paisesBelignantesNoLimitrofes2(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(new ArrayList<Pais>());
//        String expected = "No se puede mover tropas a un país que no es límitrofe.";
//
//        try{
//            assertEquals(expected, ra.moverEjercito(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    @Test
//    public void paisAtacanteNoTeniaTropasSuficientesParaAtacar2(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
//        when(p1.getEjercitoActual()).thenReturn(1);
//        String expected = "No puede mover esa cantidad de tropas.";
//
//        try{
//            assertEquals(expected, ra.moverEjercito(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    @Test
//    public void paisAtacanteNoLePerteneciaAlAtacante2(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
//        when(p1.getEjercitoActual()).thenReturn(7);
//        when(this.jugador.tienePais(p1)).thenReturn(false);
//        String expected = "No puede mover tropas a un país que no le pertenece.";
//        try{
//            assertEquals(expected, ra.moverEjercito(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    @Test
//    public void paisAtacanteNoLePerteneciaAlAtacante3(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
//        when(p1.getEjercitoActual()).thenReturn(7);
//        when(this.jugador.tienePais(p1)).thenReturn(true);
//        when(this.jugador.tienePais(p2)).thenReturn(false);
//        String expected = "No puede mover tropas a un país que no le pertenece.";
//        try{
//            assertEquals(expected, ra.moverEjercito(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//
//    @Test
//    public void movimientoSePuedeRealizarCorrectamente(){
//        TurnoAtaque ra = new TurnoAtaque(this.tablero, this.jugador);
//        Pais p1 = this.paisAtacante;
//        Pais p2 = this.paisDefensor;
//        when(p1.getPaisesLimitrofes()).thenReturn(Collections.singletonList(p2));
//        when(p1.getEjercitoActual()).thenReturn(7);
//        when(this.jugador.tienePais(p1)).thenReturn(true);
//        when(this.jugador.tienePais(p2)).thenReturn(true);
//        String expected = null;
//        try{
//            assertEquals(expected, ra.moverEjercito(p1, p2, 2));
//        } catch(Exception e){
//            return;
//        }
//    }
//}
