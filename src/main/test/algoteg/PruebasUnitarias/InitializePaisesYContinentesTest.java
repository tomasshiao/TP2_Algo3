package algoteg.PruebasUnitarias;

import algoteg.Continente;
import algoteg.Pais;
import algoteg.datosJuego.InitializePaisesYContinentes;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        int cantidadContinentes = 0;
        for(Continente c: todosLosContinentes)
            cantidadContinentes++;
        assertEquals(6, cantidadContinentes);
    }

    @Test
    public void alInicializarHay50Paises(){
        this.todosLosPaises = init.getTodosLosPaises();
        int cantidadPaises = 0;
        for(Pais p: todosLosPaises)
            cantidadPaises++;
        assertEquals(50, cantidadPaises);
    }
}
