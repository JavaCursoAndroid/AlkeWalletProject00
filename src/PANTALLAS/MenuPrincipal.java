package pantallas;

import herramientas.ConsolaAdministrador;
import herramientas.Utilidades;

public class MenuPrincipal extends Pantalla<Integer>
                                   implements OpcionSelector {

    @Override
    protected void showInfo() {

        Utilidades.titulo("Bienvenido a Alke Wallet DANGELO APP", 50);

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

        String entrada = ConsolaAdministrador.scanner.nextLine();

        if (!entrada.matches("\\d+")) {

            return -1;
        }

        return Integer.parseInt(entrada);
    }
}