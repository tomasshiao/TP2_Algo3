package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaludTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE}) // six numbers
    public void comienzaConTantosPuntosDeSaludComoSeIndiquePorParametro(int puntos) {
        Salud salud = new Salud(puntos);
        assertEquals(salud.puntos(), puntos);
    }
}