package impl;

import tdas.MultiPilaTDA;
import tdas.PilaTDA;

public class MultiPila implements MultiPilaTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo origen;
	
	/**
	 * @tarea Inserta la pila recibida en el tope de la multipila.
	 * @parámetros Se recibe la pila valores.
	 * @devuelve nada, método void.
	 * @precondiciones pila inicializada.
	 * @postcondiciones Se realiza el apilado y se mantiene la estructura valores proveída al método.
	 * @costo .
	 */
	
	@Override
	public void apilar(PilaTDA valores) {
		PilaTDA aux1 = new Pila();
		aux1.inicializarPila();
		
		while(!valores.pilaVacia()) {
			aux1.apilar(valores.tope());
			valores.desapilar();
		}
		
		while(!aux1.pilaVacia()) {
			Nodo nuevo = new Nodo();
			nuevo.info = aux1.tope();
			valores.apilar(aux1.tope());
			nuevo.sig = origen;
			origen = nuevo;
			aux1.desapilar();
		}
	}
	
	/**
	 * @tarea Desapila la pila recibida por parámetro de la multipila, solo si el tope de la multipila coincide con la pila recibida.
	 * @parámetros Se recibe la pila valores.
	 * @devuelve Nada, método void.
	 * @precondiciones Pila inicializada.
	 * @postcondiciones Se realiza el desapilado en caso de corresponder y se mantiene la estructura valores proveída al método.
	 * @costo ¿
	 */

	@Override
	public void desapilar(PilaTDA valores) {
		PilaTDA aux1 = new Pila();
		aux1.inicializarPila();
		
		while(!valores.pilaVacia() && valores.tope() == origen.info) {
				origen = origen.sig;
				aux1.apilar(valores.tope());
				valores.desapilar();
		}
		
		while(!aux1.pilaVacia()) {
			valores.apilar(aux1.tope());
			aux1.desapilar();
		}
	}
	
	/**
	 * @tarea Devuelve una pila con los valores que estén en el tope de la multipila. La cantidad de valores a devolver se define por parámetro y debe preservarse el orden.
	 * @parámetros cantidad: Cantidad de topes a retornar dentro de la pila
	 * @devuelve topes: Pila que contiene la cantidad de topes solicitados
	 * @precondiciones Pila inicializada
	 * @postcondiciones
	 * @costo 
	 */

	@Override
	public PilaTDA tope(int cantidad) {
		PilaTDA topes = new Pila();
		topes.inicializarPila();
	
		Nodo aux = origen;
		int i =0;
		
		while(aux != null) { // Se recorre la pila actual a través de un nodo auxiliar e iteración para determinar la cantidad de valores
			aux = aux.sig;
			i++;
		}
		
		Nodo aux2 = origen;
		
		if (i<cantidad) {
			while (aux2 != null) {
				topes.apilar(aux2.info);
				aux2 = aux2.sig;
			}
		}else {
			while (cantidad > 0) {
				topes.apilar(aux2.info);
				cantidad--;
			}
		}
		
		return topes;
	}
	
	/**
	 * @tarea Inicializa la multipila
	 * @parámetros No recibe parámetros de entrada
	 * @devuelve Nada, método void
	 * @precondiciones
	 * @postcondiciones
	 * @costo Constante
	 */

	@Override
	public void inicializarPila() {
		origen = null;
	}
	
	/**
	 * @tarea Devuelve un booleano que indica si la pila está vacía.
	 * @parámetros No recibe parámetros de entrada.
	 * @devuelve Devuelve un booleano que indica si la pila está vacía.
	 * @precondiciones Pila inicializada.
	 * @postcondiciones
	 * @costo Constante
	 */

	@Override
	public boolean pilaVacia() {
		return (origen == null);
	}

}