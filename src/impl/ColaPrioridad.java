package impl;

import tdas.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

	class NodoPrioridad{
		int info;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad mayorPrioridad;
	
	/**
	 * @tarea Inicializa la cola prioridad.
	 * @parámetros No se reciben parámetros.
	 * @devuelve nada, método void.
	 * @precondiciones
	 * @postcondiciones Cola prioridad inicializada.
	 * @costo Constante
	 */
	
	@Override
	public void InicializarCola() {
		mayorPrioridad = null;

	}
	
	/**
	 * @tarea Acolar el elemento según la prioridad indicada.
	 * @parámetros x: Valor numérico a acolar, prioridad: Prioridad en la cual acolar el valor indicado.
	 * @devuelve nada, método void.
	 * @precondiciones Cola prioridad inicializada
	 * @postcondiciones Valor acolado según prioridad indicada.
	 * @costo Lineal
	 */

	@Override
	public void AcolarPrioridad(int x, int prioridad) {
		
		// Creo el nuevo nodo que voy a acolar
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info = x;
		nuevo.prioridad = prioridad;
		
		// Si la cola esta vacıa o bien es mas prioritario que el primero hay que agregarlo al principio
		
		if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		}
		else {
		// Sabemos que mayorPrioridad no es null
			NodoPrioridad aux = mayorPrioridad;
			while(aux.sig != null && aux .sig. prioridad >= prioridad){ // Constante
				aux = aux .sig;
		}// --> Lineal
		
		nuevo.sig = aux.sig;
		aux.sig = nuevo;
		}// --> Lineal
	}
	
	/**
	 * @tarea Desacola el elemento.
	 * @parámetros No se reciben parámetros.
	 * @devuelve nada, método void.
	 * @precondiciones Cola prioridad inicializada y no vacía.
	 * @postcondiciones Elemento de mayor prioridad desacolado.
	 * @costo Constante
	 */

	@Override
	public void Desacolar() {
		mayorPrioridad = mayorPrioridad.sig;

	}
	
	/**
	 * @tarea Retorna el primer elemento de mayor prioridad de la cola.
	 * @parámetros No se reciben parámetros.
	 * @devuelve int, valor numérico de mayor prioridad.
	 * @precondiciones Cola prioridad inicializada y no vacía.
	 * @postcondiciones Retorna el primer elemento de mayor prioridad de la cola.
	 * @costo Constante
	 */

	@Override
	public int Primero() {
		return mayorPrioridad.info;
	}
	
	/**
	 * @tarea Verifica si la cola esta vacía.
	 * @parámetros No se reciben parámetros.
	 * @devuelve booleano, el booleano indica en true si la cola es vacía y caso contrario en false.
	 * @precondiciones Cola prioridad inicializada.
	 * @postcondiciones Se retorna el booleano indicado.
	 * @costo Constante
	 */

	@Override
	public boolean ColaVacia() {
		return (mayorPrioridad == null);
	}
	
	/**
	 * @tarea Se retorna el valor de la prioridad mas alta de la cola.
	 * @parámetros No se reciben parámetros.
	 * @devuelve int, valor de la prioridad mas alta de la cola.
	 * @precondiciones Cola prioridad inicializada y no vacía.
	 * @postcondiciones Se retorna el valor de prioridad mas alto.
	 * @costo Constante
	 */

	@Override
	public int Prioridad() {
		return mayorPrioridad.prioridad;
	}

}
