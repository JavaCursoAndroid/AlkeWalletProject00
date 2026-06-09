package PANTALLAS;

import DDBB.DataBase;

import HERRAMIENTAS.ConsoleManager;
import HERRAMIENTAS.MiBoxTool;

public class PantallaLogin extends Pantalla<String>
                           implements Identity {

    @Override
    protected void showInfo() {

        MiBoxTool.titulo("Autenticación de usuarios", 50);
    }

    @Override
    protected String capturarDatos() {

        return autenticar();
    }

    @Override
    public String autenticar() {

        while (true) {

            System.out.print("\nIngrese su Nombre de usuario: ");

            String usuario = ConsoleManager.scanner.nextLine();

            System.out.print("\nIngrese su contraseña: ");

            String password = ConsoleManager.scanner.nextLine();

            // VERIFICACION DE EXISTENCIA DE USUARIO EN LA DATA BASE

            if (!DataBase.usuarios.containsKey(usuario)) {

                System.out.println("\nERROR: El usuario no existe.");

                MiBoxTool.pausa(2000);

                MiBoxTool.cleanerscreen();

                showInfo();

                continue;
            }

            // Verificar contraseña

            if (DataBase.usuarios.get(usuario).getPassword().equals(password)) {

                System.out.println("\nLOGIN EXITOSO.");

                MiBoxTool.pausa(2000);

                return usuario;
            }

            System.out.println("\nERROR: Contraseña incorrecta.");

            MiBoxTool.pausa(2000);

            MiBoxTool.cleanerscreen();

            showInfo();
        }
    }
}