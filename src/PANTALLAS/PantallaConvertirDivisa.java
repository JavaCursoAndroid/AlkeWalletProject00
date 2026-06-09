package PANTALLAS;

import APP.Main;

import DDBB.DataBase;

import HERRAMIENTAS.ConsoleManager;
import HERRAMIENTAS.MiBoxTool;

public class PantallaConvertirDivisa extends Pantalla<Double> {

    @Override
    protected void showInfo() {

        MiBoxTool.titulo("Conversión de divisas", 50);
        DataBase.usuarios.get(Main.usuarioActual).mostrarCuenta(Main.usuarioActual);

        
    }

    @Override
    protected Double capturarDatos() {

        while (true) {

            try {

                System.out.print(
                        "\nIngrese monto a convertir: ");

                String entrada =
                        ConsoleManager.scanner.nextLine();

                entrada = entrada.replace(",", ".");

                double monto =
                        Double.parseDouble(entrada);

                if (monto <= 0) {

                    System.out.println(
                            "\nERROR: Debe ingresar un valor positivo.");

                    MiBoxTool.pausa(2000);

                    continue;
                }

                return monto;

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nERROR: Debe ingresar un número válido.");

                MiBoxTool.pausa(2000);
            }
        }
    }
}