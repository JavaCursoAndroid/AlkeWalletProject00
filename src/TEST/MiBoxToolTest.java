package TEST;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import DDBB.Cuenta;
import DDBB.DataBase;
import HERRAMIENTAS.MiBoxTool;

class MiBoxToolTest {
	
	// VERIFICA 3 CASOS PARA EL METODO CENTRAR

   // @Test
    //void testRestar() {
        //Calculadora c = new Calculadora();
        //assertEquals(1, c.restar(3, 2));
    //} 
	
	@Test
	void testCentrarValido() {
	    assertEquals(" hola ", MiBoxTool.centrar("hola", 6));
	}
	
	@Test
	void testCentrarMismoAncho() {    
	    assertEquals("hola", MiBoxTool.centrar("hola", 4));
	}
	
	@Test
	void testCentrarAnchoMenorQueTexto() {
	    assertEquals("hola", MiBoxTool.centrar("hola", 3));
	}
	/**
	 * VERIFICA 4 CASOS PARA EL METODO TITULO
	 */
	@Test
	void testTituloTextoCorto() {
	    ByteArrayOutputStream salida = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(salida));

	    MiBoxTool.titulo("Hola", 8);

	    String esperado =
	            "********\n" +
	            "* Hola *\n" +
	            "********\n";

	    assertEquals(esperado.replace("\n", System.lineSeparator()),
	                 salida.toString());
	}
	
	@Test
	void testTituloAnchoMayor() {
	    ByteArrayOutputStream salida = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(salida));

	    MiBoxTool.titulo("Java", 12);

	    String resultado = salida.toString();

	    assertTrue(resultado.contains("Java"));
	}
	@Test
	void testTituloTextoVacio() {
	    ByteArrayOutputStream salida = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(salida));

	    MiBoxTool.titulo("", 6);

	    String resultado = salida.toString();

	    assertFalse(resultado.isEmpty());
	}
	@Test
	void testTituloTresLineas() {
	    ByteArrayOutputStream salida = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(salida));

	    MiBoxTool.titulo("Test", 10);

	    String[] lineas = salida.toString().split(System.lineSeparator());

	    assertEquals(3, lineas.length);
	}
	
	// VERIFICA  EL METODO LIMPIAR PANTALLA
	
	@Test
	void testCleanerScreenImprime13Saltos() {

	    ByteArrayOutputStream salida = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(salida));

	    MiBoxTool.cleanerscreen();

	    String resultado = salida.toString();

	    long cantidadSaltos =
	            resultado.chars()
	                     .filter(c -> c == '\n')
	                     .count();

	    assertEquals(13, cantidadSaltos);
	}

	    
}
