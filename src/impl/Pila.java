package impl;

import tdas.PilaTDA;

public class Pila implements PilaTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	
	/**
	 * @tarea Inicializa la pila.
	 * @parámetros No se reciben parámetros.
	 * @devuelve nada, método void.
	 * @precondiciones
	 * @postcondiciones Pila inicializada.
	 * @costo Constante
	 */
	
	@Override
	public void inicializarPila() {
		primero = null;

	}
	
	/**
	 * @tarea Apilar el valor indicado como parámetro.
	 * @parámetros dato: Valor numérico a apilar.
	 * @devuelve nada, método void.
	 * @precondiciones Pila inicializada.
	 * @postcondiciones Se apila el valor indicado.
	 * @costo Constante
	 */

	@Override
	public void apilar(int dato) {
		Nodo nuevo = new Nodo();
		nuevo.info = dato;
		nuevo.sig = primero;
		primero = nuevo;
	}
	
	/**
	 * @tarea Desapilar de la pila el último parámetro ingresado.
	 * @parámetros No se reciben parámetros.
	 * @devuelve nada, método void.
	 * @precondiciones Pila inicializada y no vacía.
	 * @postcondiciones Se desapila el último valor ingresado a la pila.
	 * @costo Constante
	 */

	@Override
	public void desapilar() {
		primero = primero.sig;
	}
	
	/**
	 * @tarea Se valida si la pila actualmente se encuentra vacía.
	 * @parámetros No se reciben parámetros.
	 * @devuelve booleano: Indica en false si la pila no se encuentra vacía, caso contrario, se indica true.
	 * @precondiciones Pila inicializada.
	 * @postcondiciones Se retorna el booleano solicitado.
	 * @costo Constante
	 */

	@Override
	public boolean pilaVacia() {
		return (primero == null);
	}
	
	/**
	 * @tarea Se retorna el valor del tope de la pila.
	 * @parámetros No se reciben parámetros.
	 * @devuelve int, se retorna el valor numérico correspondiente al tope de la pila.
	 * @precondiciones Pila inicializada y no vacía.
	 * @postcondiciones Se retorna el valor numérico solicitado.
	 * @costo Constante
	 */

	@Override
	public int tope() {
		return primero.info;
	}

}
