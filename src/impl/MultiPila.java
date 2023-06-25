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
	 * @costo nulo
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
	 * @tarea hola
	 * @parámetros
	 * @devuelve
	 * @precondiciones
	 * @postcondiciones
	 * @costo nulo
	 */

	@Override
	public PilaTDA tope(int cantidad) {
		PilaTDA topes = new Pila();
		
		
		
		return topes;
	}
	
	/**
	 * @tarea hola
	 * @parámetros
	 * @devuelve
	 * @precondiciones
	 * @postcondiciones
	 * @costo nulo
	 */

	@Override
	public void inicializarPila() {
		origen = null;
	}
	
	/**
	 * @tarea hola
	 * @parámetros
	 * @devuelve
	 * @precondiciones
	 * @postcondiciones
	 * @costo nulo
	 */

	@Override
	public boolean pilaVacia() {
		return (origen == null);
	}

}