package pantallas;

import bd.BaseDato;
import herramientas.ConsolaAdministrador;
import herramientas.Utilidades;

public class Registro extends Pantalla<String>
                           implements Identificar {

    @Override
    protected void showInfo() {

        Utilidades.titulo("Autenticación de usuarios", 50);
    }

    @Override
    protected String capturarDatos() {

        return autenticar();
    }

    @Override
    public String autenticar() {

        while (true) {

            System.out.print("\nIngrese su Nombre de usuario: ");

            String usuario = ConsolaAdministrador.scanner.nextLine();

            System.out.print("\nIngrese su contraseña: ");

            String password = ConsolaAdministrador.scanner.nextLine();

            // VERIFICACION DE EXISTENCIA DE USUARIO EN LA DATA BASE

            if (!BaseDato.usuarios.containsKey(usuario)) {

                System.out.println("\nERROR: El usuario no existe.");

                Utilidades.pausa(2000);

                Utilidades.cleanerscreen();

                showInfo();

                continue;
            }

            // Verificar contraseña

            if (BaseDato.usuarios.get(usuario).getPassword().equals(password)) {

                System.out.println("\nLOGIN EXITOSO.");

                Utilidades.pausa(2000);

                return usuario;
            }

            System.out.println("\nERROR: Contraseña incorrecta.");

            Utilidades.pausa(2000);

            Utilidades.cleanerscreen();

            showInfo();
        }
    }
}