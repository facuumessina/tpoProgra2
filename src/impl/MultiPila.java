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
	 * @estrategia Se recorre la pila recibida asignando los valores de tope a la pila auxiliar previamente declarada. Luego se recorre la pila auxiliar mientras los nuevos valores se apilan sobre los ya existentes y a su vez, se vuelven a apilar los valores en la pila recibida para respetar la estructura recibida.
	 * @tarea Inserta la pila recibida en el tope de la multipila.
	 * @parámetros Se recibe la pila valores.
	 * @devuelve nada, método void.
	 * @precondiciones pila inicializada.
	 * @postcondiciones Se realiza el apilado y se mantiene la estructura valores proveída al método.
	 * @costo Lineal
	 */
	
	@Override
	public void apilar(PilaTDA valores) {
		PilaTDA aux1 = new Pila();
		aux1.inicializarPila();
		
		while(!valores.pilaVacia()) {// Constante
			aux1.apilar(valores.tope());
			valores.desapilar();
		}// --> Lineal
		
		while(!aux1.pilaVacia()) {// Constante
			Nodo nuevo = new Nodo();
			nuevo.info = aux1.tope();
			valores.apilar(aux1.tope());
			nuevo.sig = origen;
			origen = nuevo;
			aux1.desapilar();
		}// Lineal
	}
	
	/**
	 * @estrategia Se declara e inicializa una pila auxiliar, se recorre la pila valores mientras la misma no esté vacía y su valor tope coincida con el valor del nodo origen. Mientras eso ocurra, se apilará el valor indicado en la pila auxiliar y se "eliminarán" los nodos coincidentes. Finalmente, se apilarán los valores de la pila auxiliar nuevamente en valores para obtener nuevamente la estructura recibida como parámetro.
	 * @tarea Desapila la pila recibida por parámetro de la multipila, solo si el tope de la multipila coincide con la pila recibida.
	 * @parámetros Se recibe la pila valores.
	 * @devuelve Nada, método void.
	 * @precondiciones Pila inicializada.
	 * @postcondiciones Se realiza el desapilado en caso de corresponder y se mantiene la estructura valores proveída al método.
	 * @costo Lineal
	 */

	@Override
	public void desapilar(PilaTDA valores) {
		PilaTDA aux1 = new Pila();
		aux1.inicializarPila();
		
		while(!valores.pilaVacia() && valores.tope() == origen.info) {// Constante
				origen = origen.sig;
				aux1.apilar(valores.tope());
				valores.desapilar();
		}// --> Lineal
		
		while(!aux1.pilaVacia()) {// Constante
			valores.apilar(aux1.tope());
			aux1.desapilar();
		}// --> Lineal
	}
	
	/**
	 * @estrategia Se declara e inicializa la pila topes a retornar en el método. Luego se declara un nodo auxiliar igual al de origen, y se inicia un contador "i", se recorren los nodos para saber la cantidad de elementos de la pila incrementando el contador. Se declara un segundo nodo auxiliar igualado nuevamente al origen. Luego si la cantidad ingresada es mayor a la cantidad de nodos de la pila, se recorrerán los nodos nuevamnete y se apilaran todos los topes en la pila a retornar. En el otro caso, se inicia un ciclo while mientras que el valor ingresado sea mayor a 0, se realizará el apilado de los valores numéricos de los nodos y se decrementará el valor de cantidad hasta que sea finalmente 0. Se retorna la pila topes solicitada por el método.
	 * @tarea Devuelve una pila con los valores que estén en el tope de la multipila. La cantidad de valores a devolver se define por parámetro y debe preservarse el orden.
	 * @parámetros cantidad: Cantidad de topes a retornar dentro de la pila
	 * @devuelve topes: Pila que contiene la cantidad de topes solicitados
	 * @precondiciones Pila inicializada
	 * @postcondiciones Se retorna la pila con los topes correspondientes solicitada por el método.
	 * @costo Lineal
	 */

	@Override
	public PilaTDA tope(int cantidad) {
		PilaTDA topes = new Pila();
		topes.inicializarPila();
	
		Nodo aux = origen;
		int i =0;
		
		while(aux != null) { // Se recorre la pila actual a través de un nodo auxiliar e iteración para determinar la cantidad de valores //Constante
			aux = aux.sig;
			i++;
		}// --> Lineal
		
		Nodo aux2 = origen;
		
		if (i<cantidad) {
			while (aux2 != null) {
				topes.apilar(aux2.info);
				aux2 = aux2.sig;
			}//Lineal
		}else {
			while (cantidad > 0) {
				topes.apilar(aux2.info);
				cantidad--;
			}//Lineal
		}//Lineal
		
		return topes;
	}
	
	/**
	 * @tarea Inicializa la multipila
	 * @parámetros No recibe parámetros de entrada
	 * @devuelve Nada, método void
	 * @precondiciones
	 * @postcondiciones Multipila inicializada
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
	 * @postcondiciones Se retorna un booleano indicando si la pila se encuentra vacía.
	 * @costo Constante
	 */

	@Override
	public boolean pilaVacia() {
		return (origen == null);
	}

}