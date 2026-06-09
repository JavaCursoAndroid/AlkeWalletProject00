package HERRAMIENTAS;
import DDBB.DataBase;
/**
 * Esta clase denominada MiBoxTool, tiene como finalidad facilitar y reducir
 * la escritura de código repetivo además de aportar claridad a la sintaxis 
 * durante la implementacion de clases y objetos.
 * 
 *  Contiene herramientas como "Titulo" para presentar encabezados , la cual tambien
 *  usa "centrar" para alinear el  texto introducido dentro de cierto ancho de 
 *  pantalla establecido
 *  
 *  Contiene una herramienta de "limpieza" cleanerscreen que simula un reset de pantalla
 *  Contiene una herramienta para "pausar" pausa, la cual simula un flujo más comodo para
 *  visualizar entre transiciones de "pantallas"
 *  
 *  Contiene además algunas funciones especicas implementadas por las pantallas, para depositar,
 *  retirar, y convertir  montos de dinero del usuario, asi como su presentacion en un estado 
 *  de cuenta.
 *  
 */
import DDBB.Cuenta;
public class MiBoxTool {

	// =====================================================
	// CENTRAR TEXTO
	// =====================================================
	/**
	 * Esta utilidad forma parte de titulo, y sirve para centrar u texto dado en un ancho
	 * de pantalla preestablecido
	 *
	 */
	public static String centrar(String texto, int ancho) {

		int espaciosTotales = ancho - texto.length();

		// Protección contra negativos

		if (espaciosTotales < 0) {
			espaciosTotales = 0;
		}

		int izquierda = espaciosTotales / 2;
		int derecha = espaciosTotales - izquierda;

		return " ".repeat(izquierda) + texto + " ".repeat(derecha);
	}

	// =====================================================
	// CREAR TÍTULOS
	// =====================================================
	/**
	 * 
	 * Esta utilidad sirve para crear un encabezado enmarcado y centrado
	 * por consola
	 */
	public static void titulo(String texto, int ancho) {

		System.out.println("*".repeat(ancho));

		// Espacio interior entre los bordes

		int interior = ancho - 2;

		System.out.println("*" + centrar(texto, interior) + "*");

		System.out.println("*".repeat(ancho));
	}

	// =====================================================
	// LIMPIAR PANTALLA
	// =====================================================

	public static void cleanerscreen() {

		for (int i = 0; i < 13; i++) {
			System.out.println();
		}
	}

	// =====================================================
	// PAUSA
	// =====================================================
	/**
	 * 
	 * Esta utilidad sirve para simular una pausa entre las "pantallas" de la app
	 */
	public static void pausa(int milisegundos) {

		try {

			Thread.sleep(milisegundos);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}


	