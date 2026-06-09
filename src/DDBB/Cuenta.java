package DDBB;

/**
 * 
 * Es la clase diseñada para almacenar la información de usuario y contraseña por el usuario
 * que se crea una cuenta en la aplicacion. Posee un atributo estatic "ultimoNumeroCuenta"
 * para que no existan cuenta iguales en la aplicacion.
 * 
 * @param password es el atributo que se crea junto con la cuenta y sirve durante
 * el proceso de login
 */
public class Cuenta {
	
	//Atributos
    private static int ultimoNumeroCuenta = 999999; // Compartido por todas las cuentas
    private int numeroCuenta;
    private String titular;
    private String password;
    private double saldo;
    
    //Constructor

    public Cuenta(String titular, String password) {

        ultimoNumeroCuenta++;
        this.titular = titular + " Pro user"; // en esta version pro es free!
        this.numeroCuenta = ultimoNumeroCuenta;
        this.password = password;
        this.setSaldo(0);
    }
    
    // GETTERS 
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public String getPassword() {
		return password;
	}

	public String getTitular() {
		return titular;
	}
	public double getSaldo() {
		return saldo;
	}


	// SETTERS 
	
	public void setSaldo(double saldo) {
	this.saldo = saldo;
	}
	// =====================================================
	// DEPOSITAR DINERO
	// =====================================================
	/**
	 * Esta método implementa la capacidad para ingresar montos en la variable "saldo" de "Cuenta"
	 * @param usuario Corresponde al nombre de usuario en el hashMap de la "DataBase"
	 * @param deposito cantidad especificada por el usuario activo de la aplicacion
	 */
	public void depositar(String usuario, double deposito) {

		DataBase.usuarios.get(usuario).setSaldo(DataBase.usuarios.get(usuario).getSaldo() + deposito);
	}
    

	// =====================================================
	// RETIRAR DINERO
	// =====================================================
	/**
	 * Método que permite VALIDAR retirar fondo asociados a una cuenta
	 * almacenada en la DataBase de la aplicacion. La OPERACION DE RETIRAR SE IMPLEMENTA DESDE
	 * PantallaRetirar.
	 * @param usuario nombre de la cuenta donde se depositara un monto
	 * @param deposito cantidad especificada por el usuario activo de la aplicacion
	 */
	public boolean retirar(String usuario, double retiro) {

		double saldoActual = DataBase.usuarios.get(usuario).getSaldo();

		// Validar fondos suficientes

		if (retiro > saldoActual) {

			return false;
		}

		DataBase.usuarios.get(usuario).setSaldo(DataBase.usuarios.get(usuario).getSaldo() - retiro);

		return true;
	}
		
	
	
	// =====================================================
	// INFORMACION DE CUENTA
	// =====================================================
	/**
	 * 
	 * Este método sirve para mostrar un layout de información basica de la cuenta
	 * 
	 * @param usuario el nombre de usuario de quien se mostrará la información
	 */
	public  void mostrarCuenta(String usuario) {


	    System.out.println("\n========================");
	    System.out.println("Usuario		: " + DataBase.usuarios.get(usuario).getTitular());
	    System.out.println("N° Cuenta	: " + DataBase.usuarios.get(usuario).getNumeroCuenta());
	    System.out.println("Saldo		: " + DataBase.usuarios.get(usuario).getSaldo()+ " CLP");
	    System.out.println("========================");
	}
	
	// =====================================================
		// CONVERTIDOR DE DIVISAS
		// =====================================================
		/**
		 * 
		 * Esta utilidad sirve como una calculadora util de conversion de divisas para
		 * el usuario y NO representa a una transaccion real sobre sus fondos.
		 * @param usuario nombre de la cuenta creada para el usuario del mismo nonmbre
		 * @param monto una cantidad cualquiera en formato double 
		 */
		public  boolean convertDivisa(String usuario, double monto) {

			Double saldoActual = DataBase.usuarios.get(usuario).getSaldo();

			// Validar el monto de entrada

			if (monto < 0) {
				System.out.println("Ingrese un valor de monto válido ");

				return false;
			}
			System.out.println("Su saldo actual es : "+ saldoActual+"CLP");
			System.out.println("El valor del monto en dolares es : "+(monto*0.0011 )+"USD");
			System.out.println("El valor del monto en euros es : "+(monto*0.00096)+"€");
			System.out.println("El valor del monto en yuans es : "+(monto*0.0075)+"CNY");

			return true;
		}


	
}