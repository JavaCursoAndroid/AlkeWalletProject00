package pantallas;
import herramientas.Utilidades;

public class Salir extends Pantalla<Void> {

    @Override
    protected void showInfo() {

        Utilidades.titulo("Regresa cuando quieras", 50);
    }

    @Override
    protected Void capturarDatos() {

        return null;
    }
}