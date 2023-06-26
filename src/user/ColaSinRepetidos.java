package user;

import impl.Pila;
import tdas.PilaTDA;

public class ColaSinRepetidos {
	
	/**
	 * @estrategia Para este ejercicio, se requiere la inicialización de 2 colas auxiliares y una pila, el objetivo es recorrer la cola aux (representa la cola recibida para no modificar estructuras), la pila aux2 contendría el elemento a comparar siempre si está repetido y finalmente, tenemos la cola aux3 la cual representa un espejo de la cola sinrep (cola a retornar), la cual nos ayudaría a recorrer dicha cola en busca de elementos repetidos.
	 * @tarea Devolver una cola sin repetidos.
	 * @parámetros cola: Cola recibida para eliminar repeticiones en orden.
	 * @devuelve sinrep: Cola sin repeticiones.
	 * @precondiciones: Cola inicializada y no vacía.
	 * @postcondiciones Se retorna la cola solicitada.
	 * @costo Polinómico
	 */
	
		public static ColaTDA ColaSinRepetidos(ColaTDA cola) {
		
			ColaTDA aux = new Cola();
			aux.inicializarCola();
		
			ColaTDA sinrep = new Cola();
			sinrep.inicializarCola();
		
			aux = cola;
		
			PilaTDA aux2 = new Pila();
			aux2.inicializarPila();
		
			ColaTDA aux3 = new Cola();
			aux3.inicializarCola();
		
			sinrep.acolar(aux.primero());
			aux3.acolar(aux.primero());
			aux.desacolar();
		
			while(!aux.colaVacia()) { // se recorre la cola auxiliar // constante
			
				aux2.apilar(aux.primero());
				aux.desacolar();
			
				if(sinrep.primero() != aux2.tope()) { // constante
				
					aux3.desacolar();
				
					while(!aux3.colaVacia()) {
					
						if(aux3.primero() == aux2.tope()) {
						aux3.desacolar();
						}
					}// --> Lineal
				
					if(aux3.colaVacia()) {
						sinrep.acolar(aux2.tope());
						aux3 = sinrep;
					}
	
				}// --> Polinómico (ya que es el peor costo, se asume como máximo)
				else {
					aux.desacolar();
				}
			
			}
		
			return sinrep;
		}


}
