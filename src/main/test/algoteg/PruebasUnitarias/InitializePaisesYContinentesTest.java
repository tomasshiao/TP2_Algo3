package algoteg.PruebasUnitarias;

import algoteg.modelo.Continente;
import algoteg.modelo.Pais;
import algoteg.datosJuego.InitializePaisesYContinentes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InitializePaisesYContinentesTest {

    InitializePaisesYContinentes init = new InitializePaisesYContinentes();
    List<Continente> todosLosContinentes = new ArrayList<>();
    List<Pais> todosLosPaises = new ArrayList<>();

    Pais paisMock = mock(Pais.class);
    Continente continenteMock = mock(Continente.class);

    @Test
    public void alInicializarHayUnTotalDeSeisContientes(){
        this.todosLosContinentes = init.getTodosLosContinentes();
        assertEquals(6, this.todosLosContinentes.size());
    }

    @Test
    public void alInicializarHay50Paises(){
        this.todosLosPaises = init.getTodosLosPaises();
        assertEquals(50, this.todosLosPaises.size());
    }
}
