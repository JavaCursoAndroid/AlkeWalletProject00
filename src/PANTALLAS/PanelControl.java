package pantallas;

import herramientas.ConsolaAdministrador;
import herramientas.Utilidades;

public class PanelControl extends Pantalla<Integer>
                             implements OpcionSelector {

    @Override
    protected void showInfo() {

        Utilidades.titulo("Panel de control Usuarios", 50);

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
                ConsolaAdministrador.scanner.nextLine();

        if (!entrada.matches("\\d+")) {

            return -1;
        }

        return Integer.parseInt(entrada);
    }
}