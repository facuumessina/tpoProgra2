package user;

import impl.Conjunto;
import impl.Pila;
import tdas.ConjuntoTDA;
import tdas.PilaTDA;

public class PilaYColaAConjunto {
	
	/**
	 * @estrategia Se inicializan 3 conjuntos, el conjunto a retornar, además de 2 conjuntos auxiliares (uno para la pila y otro para la cola), los cuales almacenarán los valores que contienen para su posterior comparación. Se inicializan una cola y una pila auxiliar y se igualan a los parámetros recibidos para ser recorridos sin modificar su estructura. Se recorre la pila auxiliar para asignar los valores al conjunto de pila, de igual forma para el conjunto de colas y finalmente,se comparará el valor de cada elemento del conjunto Pila con el conjunto Cola a través del método pertenece, en caso de pertenecer, se agregarán al conjunto de repetidos a retornar.  
	 * @tarea Unificar los elementos repetidos de la cola y la pila ingresada en un conjunto.
	 * @parámetros cola: Cola recibida para comparar con pila. pila: Pila recibida para comparar con cola.
	 * @devuelve repetidos: Conjunto con los elementos comunes de la pila y la cola recibida.
	 * @precondiciones: Conjunto inicializado, Pila y Cola recibida inicializada y no vacía.
	 * @postcondiciones Se retorna el conjunto solicitado.
	 * @costo Polinómico
	 */
	
	public static ConjuntoTDA pilaYColaAConjunto(PilaTDA pila, ColaTDA cola) {
		
		ConjuntoTDA repetidos = new Conjunto();
		repetidos.InicializarConjunto();
		
		ConjuntoTDA pilaCon = new Conjunto();
		pilaCon.InicializarConjunto();
		
		Conjunto colaCon = new Conjunto();
		colaCon.InicializarConjunto();
		
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		pilaAux = pila;
		
		ColaTDA colaAux = new Cola();
		colaAux.inicializarCola();
		
		colaAux = cola;
		
		while(!pilaAux.pilaVacia()) {// Constante
			
			int valorPila = pilaAux.tope();
			
			pilaCon.Agregar(valorPila); // Lineal
			
			pilaAux.desapilar();
		}// --> Polinómico (Al ser el peor costo posible, se asume como máximo)
		
		while (!colaAux.colaVacia()) {
			
			int valorCola = colaAux.primero();
			
			colaCon.Agregar(valorCola);
			
			colaAux.desacolar();
		}
		
		while(!pilaCon.ConjuntoVacio()) {
			int valorComun = pilaCon.Elegir();
			
			if(colaCon.Pertenece(valorComun)) {
				
				repetidos.Agregar(valorComun);
				
			}
			
			pilaCon.Sacar(valorComun);
		}
		
		return repetidos;
		
	}

}
