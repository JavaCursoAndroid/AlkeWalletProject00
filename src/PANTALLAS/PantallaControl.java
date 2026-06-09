package PANTALLAS;

import HERRAMIENTAS.ConsoleManager;
import HERRAMIENTAS.MiBoxTool;

public class PantallaControl extends Pantalla<Integer>
                             implements OptionSelector {

    @Override
    protected void showInfo() {

        MiBoxTool.titulo("Panel de control Usuarios", 50);

        System.out.println("\nEscoja una de las siguientes opciones:");

        System.out.println("\n1) Depositar Valores");
        System.out.println("\n2) Retirar Valores");
        System.out.println("\n3) Convertir Divisas");
        System.out.println("\n4) Salir a menú principal");
    }

    @Override
    protected Integer capturarDatos() {

        return seleccionarOpcion();
    }

    @Override
    public int seleccionarOpcion() {

        System.out.print("\nEstá ingresando: ");

        String entrada =
                ConsoleManager.scanner.nextLine();

        if (!entrada.matches("\\d+")) {

            return -1;
        }

        return Integer.parseInt(entrada);
    }
}