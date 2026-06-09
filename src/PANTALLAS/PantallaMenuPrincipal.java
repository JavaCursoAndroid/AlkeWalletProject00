package PANTALLAS;

import HERRAMIENTAS.ConsoleManager;
import HERRAMIENTAS.MiBoxTool;

public class PantallaMenuPrincipal extends Pantalla<Integer>
                                   implements OptionSelector {

    @Override
    protected void showInfo() {

        MiBoxTool.titulo("Bienvenido a Alke Wallet DANGELO APP", 50);

        System.out.println("\nEscoja una de las siguientes opciones:");
        System.out.println("\n1) Ingresar a su cuenta");
        System.out.println("\n2) Crear una cuenta");
        System.out.println("\n3) Salir");
    }

    @Override
    protected Integer capturarDatos() {

        return seleccionarOpcion();
    }

    @Override
    public int seleccionarOpcion() {

        System.out.print("\nEstá ingresando: ");

        String entrada = ConsoleManager.scanner.nextLine();

        if (!entrada.matches("\\d+")) {

            return -1;
        }

        return Integer.parseInt(entrada);
    }
}