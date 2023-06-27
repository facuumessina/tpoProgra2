package user;

import impl.Conjunto;
import impl.Pila;
import tdas.ConjuntoTDA;
import tdas.PilaTDA;

// Ejercicio 4///

public class ColaSinRepetidos {
	
	/**
	 * @estrategia Para la realización del ejercicio, se requerirá la inicialización de una cola auxiliar para no modificar la estructura recibida, la inicialización de la estructura a retornar y adicionalmente, la inicialización de un conjunto el cual contendrá los valores numéricos repetidos de la cola. Se recorrerá la cola asignando a la variable "valor" el primer valor de la cola, luego se validará si el valor no pertenece al conjunto inicializado, en ese caso, se acolará el elemento a la cola a retornar y se agregará al conjunto. Finalmente una vez recorrida la cola auxiliar, se retornará la cola solicitada sin repeticiones.
	 * @tarea Devolver una cola sin repetidos.
	 * @parámetros cola: Cola recibida para eliminar repeticiones en orden.
	 * @devuelve sinrep: Cola sin repeticiones.
	 * @precondiciones: Cola inicializada y no vacía.
	 * @postcondiciones Se retorna la cola solicitada.
	 * @costo Polinómico
	 */
	
		public static ColaTDA colaSinRepetidos(ColaTDA cola) {
		
			ColaTDA sinrep = new Cola();
			sinrep.inicializarCola();
			
			ColaTDA aux = new Cola(); // Cola identica al parámetro recibido
			aux.inicializarCola();
			
			aux = cola;
			
			ConjuntoTDA repetidos = new Conjunto(); // Conjunto con los elementos repetidos
			repetidos.InicializarConjunto();
			
			while(!aux.colaVacia()) { // Constante
				
				int valor = aux.primero();
				
				if(!repetidos.Pertenece(valor)) {// Lineal
					sinrep.acolar(valor);
					repetidos.Agregar(valor);
				}// --> Lineal
				
				aux.desacolar();
				
			}// --> Polinómico
			
			return sinrep;
		}


}
