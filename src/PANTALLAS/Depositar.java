package pantallas;

import APP.Main;
import bd.BaseDato;
import herramientas.ConsolaAdministrador;
import herramientas.Utilidades;

public class Depositar extends Pantalla<Double> {

    @Override
    protected void showInfo() {

    	Utilidades.titulo("Depósito de fondos", 50);

    	BaseDato.usuarios.get(Main.usuarioActual).mostrarCuenta(Main.usuarioActual);
    }

    @Override
    protected Double capturarDatos() {

        while (true) {

            try {

                System.out.print(
                        "\nIngrese monto a depositar: ");

                String entrada =
                        ConsolaAdministrador.scanner.nextLine();

                entrada = entrada.replace(",", ".");

                double monto =
                        Double.parseDouble(entrada);

                if (monto <= 0) {

                    System.out.println(
                            "\nERROR: Debe ingresar un valor positivo.");

                    Utilidades.pausa(2000);

                    continue;
                }

                return monto;

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nERROR: Debe ingresar un número válido.");

                Utilidades.pausa(2000);
            }
        }
    }
}