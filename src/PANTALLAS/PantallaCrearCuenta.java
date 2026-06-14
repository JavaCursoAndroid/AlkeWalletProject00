package pantallas;

import bd.Cuenta;
import bd.BaseDato;
import herramientas.ConsolaAdministrador;
import herramientas.Utilidades;

public class PantallaCrearCuenta extends Pantalla<Boolean> {
	
	//Implementación del método abstracto
    @Override
    protected void showInfo() {

        Utilidades.titulo("Creación de cuenta", 50);
    }

    @Override
    protected Boolean capturarDatos() {

        while (true) {

            System.out.print("\nCree un Nombre de usuario: ");

            String usuario = ConsolaAdministrador.scanner.nextLine();

            if (BaseDato.usuarios.containsKey(usuario)) {

                System.out.println(
                        "\nERROR: El nombre de usuario ya existe.");

                Utilidades.pausa(2000);

                Utilidades.cleanerscreen();

                showInfo();

                continue;
            }

            System.out.print("\nCrear contraseña: ");

            String password = ConsolaAdministrador.scanner.nextLine();
            
            // SE AÑADRE EL NUEVO USUARIO Y CONTRASEÑA A LA "BASE DE DATOS"
            BaseDato.usuarios.put(
                    usuario,
                    new Cuenta(usuario, password)); // Creacion del objeto cuenta asociado al password

            System.out.println ("\nCuenta creada con éxito.");

            Utilidades.pausa(2000);

            return true;
        }
    }
}