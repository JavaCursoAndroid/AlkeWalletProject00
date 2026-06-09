package PANTALLAS;

import DDBB.Cuenta;
import DDBB.DataBase;

import HERRAMIENTAS.ConsoleManager;
import HERRAMIENTAS.MiBoxTool;

public class PantallaCrearCuenta extends Pantalla<Boolean> {
	
	//Implementación del método abstracto
    @Override
    protected void showInfo() {

        MiBoxTool.titulo("Creación de cuenta", 50);
    }

    @Override
    protected Boolean capturarDatos() {

        while (true) {

            System.out.print("\nCree un Nombre de usuario: ");

            String usuario = ConsoleManager.scanner.nextLine();

            if (DataBase.usuarios.containsKey(usuario)) {

                System.out.println(
                        "\nERROR: El nombre de usuario ya existe.");

                MiBoxTool.pausa(2000);

                MiBoxTool.cleanerscreen();

                showInfo();

                continue;
            }

            System.out.print("\nCrear contraseña: ");

            String password = ConsoleManager.scanner.nextLine();
            
            // SE AÑADRE EL NUEVO USUARIO Y CONTRASEÑA A LA "BASE DE DATOS"
            DataBase.usuarios.put(
                    usuario,
                    new Cuenta(usuario, password)); // Creacion del objeto cuenta asociado al password

            System.out.println ("\nCuenta creada con éxito.");

            MiBoxTool.pausa(2000);

            return true;
        }
    }
}