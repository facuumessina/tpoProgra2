package impl;

import tdas.ConjuntoEspecialTDA;

/// Ejercicio 1 ////

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo origen;
	
	/**
	 * @tarea Inicializa el conjunto especial.
	 * @parámetros No se reciben parámetros.
	 * @devuelve nada, método void.
	 * @precondiciones
	 * @postcondiciones Conjunto especial inicializado.
	 * @costo Constante
	 */
	
	@Override
	public void inicializarConjunto() {
		origen = null; //Constante
	}
	
	/**
	 * @estrategia En primera instancia, se crea el objeto respuesta. Luego, se verifica a través del método de pertenece si el valor pertenece al conjunto, en caso de no pertenecer, se realiza la creación y asignación del nodo, en adición de la asignación del error como falso. Y si el nodo no pertenece, se establece el error como true y no se realiza el agregado. Finalmente se retornaría el objeto Respuesta con el error presentado.
	 * @tarea Valida si el valor agregado ya {@link #pertenece} al conjunto, de lo contrario, agrega el valor al conjunto.
	 * @parámetros valor: Valor numérico a agregar al conjunto.
	 * @devuelve resp: Devuelve el objeto respuesta con error en true si no se agrega un nuevo valor, false si se agregó correctamente.
	 * @precondiciones Conjunto especial inicializado.
	 * @postcondiciones Se realiza o no la agregación del valor, y se retorna la respuesta.
	 * @costo Lineal
	 */

	@Override
	public Respuesta agregar(int valor) {
		Respuesta resp = new Respuesta();
		if (!this.pertenece(valor)) { // se verifica pertenencia --> 
			Nodo nuevo = new Nodo(); // el nuevo nodo que se agregará
			nuevo.info = valor; // operación elemental --> Constante
			nuevo.sig = origen;// Constante
			origen = nuevo; // Constante
			resp.error = false; // Constante
		}else {
			resp.error = true; // Constante
		}
		return resp;
	}
	
	/**
	 * @estrategia En primera instancia, se crea el objeto respuesta. Luego, se valida si el conjunto es null para luego comenzar la búsqueda del valor a sacar. Si el valor es el primero (origen.info == valor), se realiza la eliminación y se coloca error en false, de lo contrario se continúa la búsqueda hasta su encuentro. En caso de no encontrar el valor, no se realiza la eliminación y se establece el errro como true.
	 * @tarea Elimina un valor del conjunto.
	 * @parámetros valor: Valor numérico a eliminar del conjunto.
	 * @devuelve resp: Retorna el objeto Respuesta con error en true si no se realiza una eliminación, false si se eliminó el error.
	 * @precondiciones Conjunto especial inicializado.
	 * @postcondiciones Se realiza o no la eliminación del valor, y se retorna la respuesta.
	 * @costo Lineal
	 */

	@Override
	public Respuesta sacar(int valor) {
		Respuesta resp = new Respuesta();
		if (origen != null) { //Constante
			if (origen.info == valor) { //es el primero //Constante
				origen = origen.sig; //Constante
				resp.error = false; //Constante
			}else { //es algún otro; lo buscamos
				Nodo aux = origen; //Constante
				while (aux.sig != null && aux.sig.info != valor) { //Constante
					aux = aux.sig; //Constante
				} // --> Lineal
				if (aux.sig != null) {// encontrado //Constante
					aux.sig = aux.sig.sig; //Constante
					resp.error = false; //Constante
				}else {
					resp.error = true;
				}
			} 
		}// --> Lineal
		else {
			resp.error = true; //Constante
		} // --> Constante
		return resp;
	}
	
	/**
	 * @estrategia Se procede en primera instancia a la creación del objeto Respuesta, luego se valida si el conjunto actualmente no esta vacío, en caso afirmativo, se inclouye en el objeto creado el valor numérico elegido junto el error en false, en caso contrario, se incluye solamente el objeto con error en true para finalmente retornar el objeto resp.
	 * @tarea Devuelve un valor del conjunto.
	 * @parámetros No posee parámetros de entrada.
	 * @devuelve resp: Se retorna el objeto Respuesta si el conjunto no tenía valores, devuelve la Respuesta con error en true, en caso contrario, la Respuesta contiene el error en false y en respuesta el valor.
	 * @precondiciones Conjunto especial inicializado y no vacío.
	 * @postcondiciones Se realiza la selección del valor y se envía la respuesta en false si se pudo elegir junto con el número dentro del objeto, en caso contrario, se retorna true.
	 * @costo Constante
	 */

	@Override
	public Respuesta elegir() {
		Respuesta resp = new Respuesta();
		if(!conjuntoVacio()) {  //Constante
			resp.rta = origen.info; //Constante
			resp.error = false; //Constante
		}else {
			resp.error = true;// Constante
		} // --> Constante
		
		return resp;
	}
	
	/**
	 * @tarea Valida si el elemento pertenece al conjunto.
	 * @parámetros valor: Valor numérico a validar su pertenencia al conjunto.
	 * @devuelve resp: Retorna el objeto booleano respuesta con false si no pertenece y true en caso de pertenecer.
	 * @precondiciones Conjunto especial inicializado.
	 * @postcondiciones Se provee el booleano indicando la pertenencia del valor al conjunto.
	 * @costo Lineal
	 */

	@Override
	public boolean pertenece(int valor) {
	boolean resp;
		if (origen != null) {
			if (origen.info == valor) { //es el primero
				resp = true;
			}else { //es algún otro; lo buscamos
				Nodo aux = origen;
				while (aux.sig != null && aux.sig.info != valor) { // constante
					aux = aux.sig; // constante
				} // --> lineal
				if (aux.sig != null) {// encontrado
					resp = true;// constante
				}else {
					resp = false;
				}
				}// --> lineal
			} // --> lineal
		else {
			resp = false;
		} // constante
		return resp;
	}
	
	/**
	 * @tarea Valida si el conjunto es vacío.
	 * @parámetros No se reciben parámetros de entrada
	 * @devuelve un booleano que especifica si el conjunto está vacío o no.
	 * @precondiciones Conjunto especial inicializado.
	 * @postcondiciones Se retorna el booleano solicitado.
	 * @costo Constante
	 */

	@Override
	public boolean conjuntoVacio() {
		return (origen == null);
	}

}