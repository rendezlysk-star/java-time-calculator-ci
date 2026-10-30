package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gt.edu.umes.proy.calculo.LogicaDelNegocio;

// Pruebas unitarias automatizadas con JUnit.
public class CalculoSegundosTest {
	
    @Test
    @DisplayName("Prueba 1: Letras o parámetros no enteros")
    public void testDetectarParametrosConLetrasExcepcion() {
        LogicaDelNegocio logica = new LogicaDelNegocio();
        String[] parametrosInvalidos = {"1", "3", "abc", "20", "1"};

        boolean esValido = logica.validarParametros(parametrosInvalidos);
        assertFalse(esValido, "La validación debe retornar false cuando se envían letras.");

        assertThrows(NumberFormatException.class, () -> {
            logica.calcularDesdeArgumentos(parametrosInvalidos);
        }, "Debe lanzar NumberFormatException al procesar cadenas no numéricas.");
    }

    @Test
    @DisplayName("Prueba 2: Validar cálculo exacto para los parámetros: 1 3 6 20 1")
    public void testCalculoSegundosParametrosOficiales() {
        LogicaDelNegocio logica = new LogicaDelNegocio();

        long resultadoEsperado = 4996860L;
        long resultadoObtenido = logica.calcularTiempoEnSegundos(1, 3, 6, 20, 1);

        assertEquals(resultadoEsperado, resultadoObtenido,
                "El cálculo en segundos para (1, 3, 6, 20, 1) debe ser exactamente 4996860.");
    }
}