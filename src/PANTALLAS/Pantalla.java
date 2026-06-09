package PANTALLAS;

import HERRAMIENTAS.MiBoxTool;

/**
 * Pantalas es una clase abstracta creada para que de ella
 * deriven las "interfaces" de la app en cado estado de la misma.
 * 
 * Esta clase contiene el método "ejecutar" el cual contiene a su vez a
 * el método "cleanerscreen" que pertenece al package "HERRAMIENTAS"
 * y simula un reset para que las distintas "interfaces de usuario"
 * no se sobre encimen demasiado. 
 * 
 * Además contiene 2 métodos abstractos: "showInfo" y "capturarDatos". El primero 
 * describe cada pantalla vista por el usuario, indicando opciones si las hay o
 * bien requiriendo la interaccion del usuario por medio de alguna instruccion simple
 * de insercion de datos por consola
 * 
 */
public abstract class Pantalla<T> {

    public final T ejecutar() {

        MiBoxTool.cleanerscreen();

        showInfo();

        return capturarDatos();
    }
    
    /**
     * Muestra la información correspondiente a la pantalla.
     */
    protected abstract void showInfo();
    
    /**
     * Captura los datos ingresados por el usuario.
     *
     * @return Datos procesados por la pantalla.
     */
    protected abstract T capturarDatos();

}