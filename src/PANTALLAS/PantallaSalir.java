package PANTALLAS;
import HERRAMIENTAS.MiBoxTool;

public class PantallaSalir extends Pantalla<Void> {

    @Override
    protected void showInfo() {

        MiBoxTool.titulo("Regresa cuando quieras", 50);
    }

    @Override
    protected Void capturarDatos() {

        return null;
    }
}