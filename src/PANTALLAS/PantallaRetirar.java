package PANTALLAS;

import APP.Main;

/**  Consiste  de una clase la cual su unico servicio es almacenar "usuarios" y permite recobrar
 * la informacion de la cuenta asociada a ese valor de string. Se trata pues de un objeto instanciado
 * tipo HashMap, que guarda un Nombre de usuario (KEY) y un objeto cuenta (VALOR)
 * 
*/
import DDBB.DataBase;

import HERRAMIENTAS.ConsoleManager;
import HERRAMIENTAS.MiBoxTool;

public class PantallaRetirar extends Pantalla<Double> {

    @Override
    protected void showInfo() {

        MiBoxTool.titulo("Retiro de fondos", 50);

        DataBase.usuarios.get(Main.usuarioActual).mostrarCuenta(Main.usuarioActual);
    }

    @Override
    protected Double capturarDatos() {

        while (true) {

            try {

                System.out.print(
                        "\nIngrese monto a retirar: ");

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

                double saldo =
                        DataBase.usuarios.get(Main.usuarioActual).getSaldo();

                if (monto > saldo) {

                    System.out.println("\nERROR: Fondos insuficientes.");

                    MiBoxTool.pausa(2000);

                    continue;
                }

                return monto;

            } catch (NumberFormatException e) {

                System.out.println("\nERROR: Debe ingresar un número válido.");

                MiBoxTool.pausa(2000);
            }
        }
    }
}