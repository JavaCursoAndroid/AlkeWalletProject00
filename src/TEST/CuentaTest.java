package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import bd.Cuenta;
import bd.BaseDato;
import herramientas.Utilidades;

class CuentaTest {

	// VERIFICA  EL METODO DEPOSITAR DINERO
	
		@Test
		void testDepositarValido() {

		    BaseDato.usuarios.clear();

		    Cuenta cuenta = new Cuenta("Pepito","1234");

		    BaseDato.usuarios.put("juan", cuenta);

		    BaseDato.usuarios.get("juan").depositar("juan", 500);

		    assertEquals(500, BaseDato.usuarios.get("juan").getSaldo());
		}
		
		@Test
		void testNumeroCuentaIncrementaAutomaticamente() {

		    Cuenta c1 = new Cuenta("Carlos","1111");
		    Cuenta c2 = new Cuenta("Hemilio","2222");

		    assertEquals(c1.getNumeroCuenta() + 1, c2.getNumeroCuenta());
		}

		// VERIFICA  EL METODO RETIRAR DINERO
		@Test
		void testRetirarValido() {

		    BaseDato.usuarios.clear();

		    Cuenta cuenta = new Cuenta("Juan","1234");
		    cuenta.setSaldo(1000);

		    BaseDato.usuarios.put("Juan", cuenta);

		    boolean resultado = cuenta.retirar("Juan", 500);

		    assertTrue(resultado);
		    assertEquals(500, BaseDato.usuarios.get("Juan").getSaldo());
		}
		
		@Test
		void testRetirarFondosInsuficientes() {

		    BaseDato.usuarios.clear();

		    Cuenta cuenta = new Cuenta("Ruperto","1234");
		    cuenta.setSaldo(1000);

		    BaseDato.usuarios.put("Ruperto", cuenta);

		    boolean resultado = cuenta.retirar("Ruperto", 1500);

		    assertFalse(resultado);
		    assertEquals(1000, BaseDato.usuarios.get("Ruperto").getSaldo());
		}
		
		@Test
		void testRetirarSaldoCompleto() {

		    BaseDato.usuarios.clear();

		    Cuenta cuenta = new Cuenta("Carol","1234");
		    cuenta.setSaldo(1000);

		    BaseDato.usuarios.put("Carol", cuenta);

		    boolean resultado = cuenta.retirar("Carol", 1000);

		    assertTrue(resultado);
		    assertEquals(0, BaseDato.usuarios.get("Carol").getSaldo());
		}

			// VERIFICA  EL METODO CONVERTIR DIVISA
			
			
			@Test
			void testConvertDivisaValido() {

			    BaseDato.usuarios.clear();

			    Cuenta cuenta = new Cuenta("Pedro","1234");
			    cuenta.setSaldo(100000);

			    BaseDato.usuarios.put("Pedro", cuenta);

			    boolean resultado = cuenta.convertDivisa("Pedro", 1000);

			    assertTrue(resultado);
			}
			
			@Test
			void testConvertDivisaMontoNegativo() {

				BaseDato.usuarios.clear();

			    Cuenta cuenta = new Cuenta("Pedro","1234");
			    cuenta.setSaldo(100000);

			    BaseDato.usuarios.put("Pedro", cuenta);

			    boolean resultado = cuenta.convertDivisa("Pedro", -1000);

			    assertFalse(resultado);
			}
		@Test
			void testConvertDivisaMontoCero() {

				BaseDato.usuarios.clear();

			    Cuenta cuenta = new Cuenta("Pedro","1234");
			    cuenta.setSaldo(100000);

			    BaseDato.usuarios.put("Pedro", cuenta);

			    boolean resultado = cuenta.convertDivisa("Pedro", 0);

			    assertTrue(resultado);
			}
			
			//METODO MOSTRAR CUENTA
			@Test
			void testMostrarCuenta() {

			    BaseDato.usuarios.clear();

			    Cuenta cuenta = new Cuenta("Alicia","1234");
			    cuenta.setSaldo(5000);

			    BaseDato.usuarios.put("Alicia", cuenta);

			    ByteArrayOutputStream salida = new ByteArrayOutputStream();
			    System.setOut(new PrintStream(salida));

			    cuenta.mostrarCuenta("Alicia");

			    String resultado = salida.toString();

			    assertTrue(resultado.contains("Alicia"));
			    assertTrue(resultado.contains(String.valueOf(cuenta.getNumeroCuenta())));
			    assertTrue(resultado.contains("5000"));
			}

}
