import colaConPrioridad.*;
import conjuntoCompleto.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner lector = new Scanner(System.in);
    	ColaPrioridad clientes = new ColaPrioridad();
    	clientes.inicializarCola();
    	
    	////			INGRESO DE VALORES			////
    	System.out.println("Ingrese un numero de cliente(Entero)\nPara Salir ingrese \"-1\"");
    	int nCliente = lector.nextInt();
    	int cant = 0; //contador para detener el ingreso de datos en 15
    	int tipoCliente;
    	while(nCliente != -1 && cant < 15) { //loop de ingreso de datos
    		cant++;
    		System.out.println("Ingrese el tipo de cliente:\nPara Cliente Empresa ingrese 1\nPara Cliente particular ingrese 2\nPara los No Clientes ingrese 3");
    		tipoCliente = lector.nextInt();
    		while((tipoCliente != 1) && (tipoCliente != 2) && (tipoCliente != 3)) { // Validador de tipo de cliente
    			System.out.println("### ERROR EN EL TIPO DE CLIENTE ###");
    			System.out.println("Ingrese el tipo de cliente:\nPara Cliente Empresa ingrese 1\nPara Cliente particular ingrese 2\nPara los No Clientes ingrese 3");
    			tipoCliente = lector.nextInt();
    		}
    		clientes.acolarPrioridad(nCliente, tipoCliente);
    		if(cant <  151) {
    			System.out.println("Ingrese un numero de cliente(Entero)\nPara Salir ingrese \"-1\"");//Pedir nuevo cliente o salir
            	nCliente = lector.nextInt();
    		}
    	}
    	lector.close();
    	
    	////			SEPARAR CLIENTES POR TIPO			////
    	
    	//Primero se raliza una copia de la cola clientes//
    	ColaPrioridad aux = new ColaPrioridad();
		aux.inicializarCola();
		ColaPrioridad copiaClientes = new ColaPrioridad();
		copiaClientes.inicializarCola();
		while(!clientes.colaVacia()) {
			aux.acolarPrioridad(clientes.primero(), clientes.prioridad());
			copiaClientes.acolarPrioridad(clientes.primero(), clientes.prioridad());
			clientes.desacolar();
		}
		while(!aux.colaVacia()) {
			clientes.acolarPrioridad(aux.primero(), aux.prioridad());
			aux.desacolar();
		}
    	int auxPrioridad;
    	int auxNCliente;
       	
    	/// Se crean Conjutos para agrupar a los clientes por tipo
    	Conjunto conjuntoEmpresa = new Conjunto();
    	Conjunto conjuntoParticularCliente = new Conjunto();
    	Conjunto conjuntoParticularNoCliente = new Conjunto();
    	conjuntoEmpresa.inicializarConjunto();
    	conjuntoParticularCliente.inicializarConjunto();
    	conjuntoParticularNoCliente.inicializarConjunto();
    	
    	// Loop para analizar los tipos y agregarlo al conjunto correspondiente
    	while(!copiaClientes.colaVacia()) {
    		auxPrioridad = copiaClientes.prioridad();
    		auxNCliente = copiaClientes.primero();
    		copiaClientes.desacolar();
    		
    		//Separamos a los clientes por tipo asignandolo a su conjunto
    		if (auxPrioridad == 1) {
    			conjuntoEmpresa.agregar(auxNCliente);
    		}else if (auxPrioridad == 2) {
    			conjuntoParticularCliente.agregar(auxNCliente);
    		}else {
    			conjuntoParticularNoCliente.agregar(auxNCliente);
    		}
    		
    		}
    	//Mostrando conjuntos para validar //
    	System.out.println("Conjunto empresa: " );
		conjuntoEmpresa = mostrarConjuntoRegresarCopia(conjuntoEmpresa);
		System.out.println("Conjunto empresa: " );
		conjuntoEmpresa = mostrarConjuntoRegresarCopia(conjuntoEmpresa);
		System.out.println("Conjunto particulares: " );
		conjuntoParticularCliente = mostrarConjuntoRegresarCopia(conjuntoParticularCliente);
		System.out.println("Conjunto no clientes: " );
		conjuntoParticularNoCliente = mostrarConjuntoRegresarCopia(conjuntoParticularNoCliente);
	
    }
    public static Conjunto mostrarConjuntoRegresarCopia(Conjunto x ) {
    	Conjunto aux = new Conjunto();
    	aux.inicializarConjunto();
    	while(!x.conjuntoVacio()) {
    		int elemento = x.elegir();
    		System.out.println("el numero de cliente es: " + elemento);
    		aux.agregar(elemento);
    		x.sacar(elemento);
    	}
    	return aux;
    }
}
