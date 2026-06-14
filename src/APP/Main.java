package APP;

import java.util.ArrayList;

import bd.BaseDato;
import herramientas.Utilidades;
import pantallas.ConvertidorDivisa;
import pantallas.MenuPrincipal;
import pantallas.PanelControl;
import pantallas.Pantalla;
import pantallas.PantallaCrearCuenta;
import pantallas.Depositar;
import pantallas.Registro;
import pantallas.Retirar;
import pantallas.Salir;

public class Main {

// Usuario autenticado actualmente

public static String usuarioActual;

// =====================================================
// MENÚ PRINCIPAL
// =====================================================

public static void raiz() {

    ArrayList<Integer> OpsValidas =
            new ArrayList<>();

    OpsValidas.add(1);
    OpsValidas.add(2);
    OpsValidas.add(3);

    int opcion;

    do {

        Pantalla<Integer> menuPrincipal =
                new MenuPrincipal();

        opcion = menuPrincipal.ejecutar();

        if (!OpsValidas.contains(opcion)) {

            System.out.println("\nOpción inválida.");

            Utilidades.pausa(1500);

            continue;
        }

        switch (opcion) {

        // =========================
        // LOGIN
        // =========================

        case 1:

            Pantalla<String> login =
                    new Registro();

            usuarioActual = login.ejecutar();

            rama0(); // Aquí se llama al metodo rama0 que ejecuta las pantallas propias del user

            break;

        // =========================
        // CREAR CUENTA
        // =========================

        case 2:

            Pantalla<Boolean> crearCuenta =
                    new PantallaCrearCuenta();

            crearCuenta.ejecutar();

            break;

        // =========================
        // SALIR
        // =========================

        case 3:

            Pantalla<Void> salir =
                    new Salir();

            salir.ejecutar();

            Utilidades.pausa(3000);

            break;
        }

    } while (opcion != 3);
}

// =====================================================
// PANEL DE CONTROL
// =====================================================

public static void rama0() {

    ArrayList<Integer> OpsValidas =
            new ArrayList<>();

    OpsValidas.add(1);
    OpsValidas.add(2);
    OpsValidas.add(3);
    OpsValidas.add(4);

    int opcion;

    do {

        Pantalla<Integer> panelControl =
                new PanelControl();

        opcion = panelControl.ejecutar();

        if (!OpsValidas.contains(opcion)) {

            System.out.println("\nOpción inválida.");

            Utilidades.pausa(1500);

            continue;
        }

        switch (opcion) {

        // =========================
        // DEPOSITAR
        // =========================

        case 1:

            Pantalla<Double> deposito = new Depositar();

            double montoDepositar = deposito.ejecutar();

            BaseDato.usuarios.get(usuarioActual).depositar(usuarioActual, montoDepositar);

            double saldo =
                    BaseDato.usuarios.get(usuarioActual).getSaldo();
                            
            System.out.println(
                    "\nNuevo saldo: "
                    + saldo
                    + " CLP");

            Utilidades.pausa(2500);

            break;

        // =========================
        // RETIRAR
        // =========================

        case 2:

            Pantalla<Double> retiro =
                    new Retirar();

            double montoRetirar =
                    retiro.ejecutar();

            BaseDato.usuarios.get(usuarioActual).retirar(usuarioActual, montoRetirar);

            saldo =
                    BaseDato.usuarios.get(usuarioActual).getSaldo();

            System.out.println(
                    "\nNuevo saldo: "
                    + saldo
                    + " CLP");

            Utilidades.pausa(2500);

            break;

        // =========================
        // CONVERTIR DIVISA
        // =========================

        case 3:

            Pantalla<Double> conversion =
                    new ConvertidorDivisa();

            double montoConversion =
                    conversion.ejecutar();

            Utilidades.cleanerscreen();

            Utilidades.titulo(
                    "Conversión de divisas",
                    50);

            BaseDato.usuarios.get(usuarioActual).convertDivisa(usuarioActual, montoConversion);

            Utilidades.pausa(10000);

            break;

        // =========================
        // VOLVER AL MENÚ PRINCIPAL
        // =========================

        case 4:

            System.out.println(
                    "\nRegresando al menú principal...");

            Utilidades.pausa(1500);

            break;
        }

    } while (opcion != 4);
}

// =====================================================
// MAIN
// =====================================================

public static void main(String[] args) {

    raiz();
}

}