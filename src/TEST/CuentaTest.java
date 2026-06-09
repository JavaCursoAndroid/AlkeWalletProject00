package TEST;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import DDBB.Cuenta;
import DDBB.DataBase;
import HERRAMIENTAS.MiBoxTool;

class CuentaTest {

	// VERIFICA  EL METODO DEPOSITAR DINERO
	
		@Test
		void testDepositarValido() {

		    DataBase.usuarios.clear();

		    Cuenta cuenta = new Cuenta("Pepito","1234");

		    DataBase.usuarios.put("juan", cuenta);

		    DataBase.usuarios.get("juan").depositar("juan", 500);

		    assertEquals(500, DataBase.usuarios.get("juan").getSaldo());
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

		    DataBase.usuarios.clear();

		    Cuenta cuenta = new Cuenta("Juan","1234");
		    cuenta.setSaldo(1000);

		    DataBase.usuarios.put("Juan", cuenta);

		    boolean resultado = cuenta.retirar("Juan", 500);

		    assertTrue(resultado);
		    assertEquals(500, DataBase.usuarios.get("Juan").getSaldo());
		}
		
		@Test
		void testRetirarFondosInsuficientes() {

		    DataBase.usuarios.clear();

		    Cuenta cuenta = new Cuenta("Ruperto","1234");
		    cuenta.setSaldo(1000);

		    DataBase.usuarios.put("Ruperto", cuenta);

		    boolean resultado = cuenta.retirar("Ruperto", 1500);

		    assertFalse(resultado);
		    assertEquals(1000, DataBase.usuarios.get("Ruperto").getSaldo());
		}
		
		@Test
		void testRetirarSaldoCompleto() {

		    DataBase.usuarios.clear();

		    Cuenta cuenta = new Cuenta("Carol","1234");
		    cuenta.setSaldo(1000);

		    DataBase.usuarios.put("Carol", cuenta);

		    boolean resultado = cuenta.retirar("Carol", 1000);

		    assertTrue(resultado);
		    assertEquals(0, DataBase.usuarios.get("Carol").getSaldo());
		}

			// VERIFICA  EL METODO CONVERTIR DIVISA
			
			
			@Test
			void testConvertDivisaValido() {

			    DataBase.usuarios.clear();

			    Cuenta cuenta = new Cuenta("Pedro","1234");
			    cuenta.setSaldo(100000);

			    DataBase.usuarios.put("Pedro", cuenta);

			    boolean resultado = cuenta.convertDivisa("Pedro", 1000);

			    assertTrue(resultado);
			}
			
			@Test
			void testConvertDivisaMontoNegativo() {

				DataBase.usuarios.clear();

			    Cuenta cuenta = new Cuenta("Pedro","1234");
			    cuenta.setSaldo(100000);

			    DataBase.usuarios.put("Pedro", cuenta);

			    boolean resultado = cuenta.convertDivisa("Pedro", -1000);

			    assertFalse(resultado);
			}
		@Test
			void testConvertDivisaMontoCero() {

				DataBase.usuarios.clear();

			    Cuenta cuenta = new Cuenta("Pedro","1234");
			    cuenta.setSaldo(100000);

			    DataBase.usuarios.put("Pedro", cuenta);

			    boolean resultado = cuenta.convertDivisa("Pedro", 0);

			    assertTrue(resultado);
			}
			
			//METODO MOSTRAR CUENTA
			@Test
			void testMostrarCuenta() {

			    DataBase.usuarios.clear();

			    Cuenta cuenta = new Cuenta("Alicia","1234");
			    cuenta.setSaldo(5000);

			    DataBase.usuarios.put("Alicia", cuenta);

			    ByteArrayOutputStream salida = new ByteArrayOutputStream();
			    System.setOut(new PrintStream(salida));

			    cuenta.mostrarCuenta("Alicia");

			    String resultado = salida.toString();

			    assertTrue(resultado.contains("Alicia"));
			    assertTrue(resultado.contains(String.valueOf(cuenta.getNumeroCuenta())));
			    assertTrue(resultado.contains("5000"));
			}

}
