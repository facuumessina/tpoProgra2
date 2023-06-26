package impl;

import tdas.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo c;
	
	/**
	 * @tarea Inicializa el conjunto.
	 * @parámetros No se reciben parámetros.
	 * @devuelve nada, método void.
	 * @precondiciones
	 * @postcondiciones Conjunto inicializado.
	 * @costo Constante
	 */
	
	@Override
	public void InicializarConjunto() {
		c = null;
	}
	
	/**
	 * @tarea Validar si el conjunto se encuentra vacío.
	 * @parámetros No se reciben parámetros.
	 * @devuelve booleano, true si se encuentra vacío y false en caso contrario.
	 * @precondiciones Conjunto inicializado.
	 * @postcondiciones Retorno de valor booleano solicitado.
	 * @costo Constante
	 */

	@Override
	public boolean ConjuntoVacio() {
		return (c == null);
	}
	
	/**
	 * @tarea Se agrega el valor indicado al conjunto en caso de no existir.
	 * @parámetros x: valor numérico a agregar.
	 * @devuelve nada, método void.
	 * @precondiciones Conjunto inicializado.
	 * @postcondiciones Valor agregado al conjunto en caso de no existir.
	 * @costo Lineal
	 */

	@Override
	public void Agregar(int x) {
		/* Verifica que x no este en el conjunto */
		if (!this.Pertenece(x)){ // --> Lineal
		Nodo aux = new Nodo ();
		aux.info = x;
		aux.sig = c;
		c = aux ;
		}// Lineal
	}
	
	/**
	 * @tarea Se elige un valor numérico del conjunto.
	 * @parámetros No se reciben parámetros.
	 * @devuelve int: Valor numérico elegido.
	 * @precondiciones Conjunto inicializado y no vacío.
	 * @postcondiciones Se retorna el valor numérico pedido.
	 * @costo Constante
	 */

	@Override
	public int Elegir() {
		return c.info;
	}
	
	/**
	 * @tarea Se elimina del conjunto el elemento solicitado en caso de que exista.
	 * @parámetros x: Valor numérico a eliminar.
	 * @devuelve nada, método void.
	 * @precondiciones Conjunto inicializado.
	 * @postcondiciones Se elimina el elemento indicado del conjunto.
	 * @costo Lineal
	 */

	@Override
	public void Sacar(int x) {
		
		if (c != null ){
			
			// si es el primer elemento de la lista
			if (c.info == x) {
				c = c.sig ;
			} else {
				Nodo aux = c;
				
				while (aux.sig != null && aux. sig.info !=x) { // Constante
					aux = aux.sig;
				}// --> Lineal
				
				if (aux.sig != null) {
					aux.sig = aux.sig.sig;
					}
			}
			
		}

	}
	
	/**
	 * @tarea Valida si el elemento indicado pertenece al conjunto.
	 * @parámetros x: valor numérico a validar.
	 * @devuelve booleano indicando si el valor pertenece al conjunto.
	 * @precondiciones Conjunto inicializado.
	 * @postcondiciones Se retorna el valor booleano solicitado.
	 * @costo Lineal
	 */

	@Override
	public boolean Pertenece(int x) {
		
		Nodo aux = c;
		
		while ((aux != null ) && (aux.info != x)){// constante
			aux = aux.sig;
		}// --> Lineal
		
		return (aux != null);
	}

}
