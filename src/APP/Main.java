package APP;

import java.util.ArrayList;

import DDBB.DataBase;
import HERRAMIENTAS.MiBoxTool;

import PANTALLAS.Pantalla;
import PANTALLAS.PantallaControl;
import PANTALLAS.PantallaConvertirDivisa;
import PANTALLAS.PantallaCrearCuenta;
import PANTALLAS.PantallaDepositar;
import PANTALLAS.PantallaLogin;
import PANTALLAS.PantallaMenuPrincipal;
import PANTALLAS.PantallaRetirar;
import PANTALLAS.PantallaSalir;

public class Main {

// Usuario autenticado actualmente

public static String usuarioActual;

// =====================================================
// MENÚ PRINCIPAL
// =====================================================

public static void principal() {

    ArrayList<Integer> OpsValidas =
            new ArrayList<>();

    OpsValidas.add(1);
    OpsValidas.add(2);
    OpsValidas.add(3);

    int opcion;

    do {

        Pantalla<Integer> menuPrincipal =
                new PantallaMenuPrincipal();

        opcion = menuPrincipal.ejecutar();

        if (!OpsValidas.contains(opcion)) {

            System.out.println("\nOpción inválida.");

            MiBoxTool.pausa(1500);

            continue;
        }

        switch (opcion) {

        // =========================
        // LOGIN
        // =========================

        case 1:

            Pantalla<String> login =
                    new PantallaLogin();

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
                    new PantallaSalir();

            salir.ejecutar();

            MiBoxTool.pausa(3000);

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
                new PantallaControl();

        opcion = panelControl.ejecutar();

        if (!OpsValidas.contains(opcion)) {

            System.out.println("\nOpción inválida.");

            MiBoxTool.pausa(1500);

            continue;
        }

        switch (opcion) {

        // =========================
        // DEPOSITAR
        // =========================

        case 1:

            Pantalla<Double> deposito = new PantallaDepositar();

            double montoDepositar = deposito.ejecutar();

            DataBase.usuarios.get(usuarioActual).depositar(usuarioActual, montoDepositar);

            double saldo =
                    DataBase.usuarios.get(usuarioActual).getSaldo();
                            
            System.out.println(
                    "\nNuevo saldo: "
                    + saldo
                    + " CLP");

            MiBoxTool.pausa(2500);

            break;

        // =========================
        // RETIRAR
        // =========================

        case 2:

            Pantalla<Double> retiro =
                    new PantallaRetirar();

            double montoRetirar =
                    retiro.ejecutar();

            DataBase.usuarios.get(usuarioActual).retirar(usuarioActual, montoRetirar);

            saldo =
                    DataBase.usuarios.get(usuarioActual).getSaldo();

            System.out.println(
                    "\nNuevo saldo: "
                    + saldo
                    + " CLP");

            MiBoxTool.pausa(2500);

            break;

        // =========================
        // CONVERTIR DIVISA
        // =========================

        case 3:

            Pantalla<Double> conversion =
                    new PantallaConvertirDivisa();

            double montoConversion =
                    conversion.ejecutar();

            MiBoxTool.cleanerscreen();

            MiBoxTool.titulo(
                    "Conversión de divisas",
                    50);

            DataBase.usuarios.get(usuarioActual).convertDivisa(usuarioActual, montoConversion);

            MiBoxTool.pausa(10000);

            break;

        // =========================
        // VOLVER AL MENÚ PRINCIPAL
        // =========================

        case 4:

            System.out.println(
                    "\nRegresando al menú principal...");

            MiBoxTool.pausa(1500);

            break;
        }

    } while (opcion != 4);
}

// =====================================================
// MAIN
// =====================================================

public static void main(String[] args) {

    principal();
}

}