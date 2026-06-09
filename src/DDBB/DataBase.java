package DDBB;

import java.util.HashMap;
import java.util.Map;

// =====================================================
// BASE DE DATOS DE USUARIOS
// =====================================================

/**  Consiste  de una clase la cual su unico servicio es almacenar "usuarios" y permite recobrar
 * la informacion de la cuenta asociada a ese valor de string. Se trata pues de un objeto instanciado
 * tipo HashMap, que guarda un Nombre de usuario (KEY) y un objeto cuenta (VALOR)
 * 
*/
public class  DataBase  {
	
	//Atributos, solo contiene una variable de tipo Map
	
	public static  Map<String, Cuenta> usuarios = new HashMap<>();

}