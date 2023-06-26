package impl;

import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;
import tdas.ColaPrioridadTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

	ColaPrioridadTDA origen = new ColaPrioridad();
	
	/**
	 * @tarea Inicia el diccionario.
	 * @parámetros No se reciben parámetros.
	 * @devuelve nada, método void.
	 * @precondiciones
	 * @postcondiciones Diccionario inicializado.
	 * @costo Constante
	 */
	
	@Override
	public void inicializarDiccionario() {
		origen.InicializarCola();
	}
	
	/**
	 * @tarea Se valida si la prioridad existe
	 * @parámetros Se recibe la clave a validar.
	 * @devuelve exists: Booleano que representa la existencia o no existencia de la clave en la cola.
	 * @precondiciones Diccionario inicializado.
	 * @postcondiciones El método interno retorna el booleano.
	 * @costo .
	 */
	
	private boolean prioridad2boolean(int clave){
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.InicializarCola();
		
		aux = origen;
		
		int prioridad = 0;
		
		boolean exists;
		
		while (!aux.ColaVacia() && aux.Prioridad()!=clave){ //Se recorre la cola en busca de coincidencia de la clave, en este caso, es la prioridad
			prioridad = aux.Prioridad();
			aux.Desacolar();
		}
		
		if(!aux.ColaVacia()) { // validamos si salió debido a que se terminó de recorrer la cola 
			exists  = true;
		}else if(prioridad == clave){ // se encontró la prioridad en el último lugar de la cola
			exists = true;
		}else { // No se encontró la prioridad
			exists = false;
		}
		
		return exists;
		
		}
	
	/**
	 * @tarea Se agrega al diccionario una nueva entrada asociada a su clave.
	 * @parámetros Se recibe la clave junto con el valor a añadir.
	 * @devuelve nada, método void.
	 * @precondiciones Diccionario inicializado.
	 * @postcondiciones Se realiza el ingreso indicado al diccionario.
	 * @costo .
	 */

	@Override
	public void agregar(int clave, int x) {
		
		boolean exists = prioridad2boolean(clave);
		
		if(!exists) { // Si la clave a añadir no existe, se realiza el agregado normal
			origen.AcolarPrioridad(x, clave);
		}else { // Se recorre la cola en busca de la clave existente para pisar su valor
			ColaPrioridadTDA aux = new ColaPrioridad();
			aux.InicializarCola();
			
			aux = origen;
			
			while (!aux.ColaVacia()) {
				
				if(aux.Prioridad() == clave) {
					origen.Desacolar();
					origen.AcolarPrioridad(x, clave);
				}
				
				aux.Desacolar();
				
			}
		}

	}
	
	/**
	 * @tarea Elimina la clave ingresada del diccionario, si la clave no existe, no se realiza ninguna acción.
	 * @parámetros Se recibe la clave a eliminar.
	 * @devuelve nada, método void.
	 * @precondiciones Diccionario inicializado.
	 * @postcondiciones Se realiza la eliminación o no.
	 * @costo .
	 */

	@Override
	public void eliminar(int clave) {
		
		boolean exists = prioridad2boolean(clave);
		
		if(exists) {
			ColaPrioridadTDA aux = new ColaPrioridad();
			aux.InicializarCola();
			
			aux = origen;
			
			while (!aux.ColaVacia()) {
				
				if(aux.Prioridad() == clave) {
					origen.Desacolar();
				}
				
				aux.Desacolar();
				
			}
		}

	}
	
	/**
	 * @tarea Recupera el valor numérico de la clave solicitada.
	 * @parámetros Se recibe la clave.
	 * @devuelve valor: Valor numérico asociado a la clave.
	 * @precondiciones pila inicializada y clave existente.
	 * @postcondiciones Se realiza la búsqueda y se retorna el valor numérico asociado a la clave.
	 * @costo .
	 */

	@Override
	public int recuperar(int clave) {
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.InicializarCola();
		
		aux = origen;
		
		int valor = 0;
		
		while (!aux.ColaVacia()) {
			
			if(aux.Prioridad() == clave) {
				valor = aux.Primero();
			}
			
			aux.Desacolar();
			
		}
		
		return valor;
	}
	
	/**
	 * @tarea Retorna el conjunto de claves del diccionario.
	 * @parámetros No se recibe ningún parámetro.
	 * @devuelve c: El conjunto de claves del diccionario.
	 * @precondiciones Diccionario inicializado.
	 * @postcondiciones Se realiza el apilado y se mantiene la estructura valores proveída al método.
	 * @costo .
	 */

	@Override
	public ConjuntoTDA claves() {
		
		ConjuntoTDA c = new Conjunto();
		c.InicializarConjunto();
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.InicializarCola();
		
		aux = origen;
		
		while (!aux.ColaVacia()) {
			
			c.Agregar(aux.Prioridad());
			aux.Desacolar();
		}
		
		return c;
	}

}
