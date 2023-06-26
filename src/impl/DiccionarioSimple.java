package impl;

import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;
import tdas.ColaPrioridadTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

	ColaPrioridadTDA origen = new ColaPrioridad();
	
	/**
	 * @estrategia Se inicia el diccionario a través de la inicialización de la cola con prioridad.
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
	 * @estrategia Se declara una cola con prioridad auxiliar igual a origen para recorrerla en busca de la clave indicada, luego durante el recorrido se determina si sale porque se encontró en el primer lugar, en el último o si no se encontró. Se retornará un booleano determinando si fue encontrado o no.
	 * @tarea Se valida si la prioridad existe.
	 * @parámetros Se recibe la clave a validar.
	 * @devuelve exists: Booleano que representa la existencia o no existencia de la clave en la cola.
	 * @precondiciones Diccionario inicializado.
	 * @postcondiciones El método interno retorna el booleano.
	 * @costo Lineal
	 */
	
	private boolean prioridad2boolean(int clave){
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.InicializarCola();
		
		aux = origen;
		
		int prioridad = 0;
		
		boolean exists;
		
		while (!aux.ColaVacia() && aux.Prioridad()!=clave){ //Se recorre la cola en busca de coincidencia de la clave, en este caso, es la prioridad //Constante
			prioridad = aux.Prioridad();
			aux.Desacolar();
		}// --> Lineal
		
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
	 * @estrategia Se valida a través del método prioridad2boolean si la clave existe, si la clave no existe, se realiza el agregado acolando la prioridad. En caso de existir, se declara una cola auxiliar igual a origen, la misma se recorre hasta encontrar la prioridad indicada, una vez encontrada se realiza el desacolamiento y el posterior acolado para pisar su valor.
	 * @tarea Se agrega al diccionario una nueva entrada asociada a su clave.
	 * @parámetros Se recibe la clave junto con el valor a añadir.
	 * @devuelve nada, método void.
	 * @precondiciones Diccionario inicializado.
	 * @postcondiciones Se realiza el ingreso indicado al diccionario.
	 * @costo Polinómico
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
			
			while (!aux.ColaVacia()) { // Constante
				
				if(aux.Prioridad() == clave) {
					origen.Desacolar();
					origen.AcolarPrioridad(x, clave); //Lineal
				}// --> Lineal
				
				aux.Desacolar();
				
			}// --> Polinómico (Se asume el mayor costo posible ya que es el peor)
		}

	}
	
	/**
	 * @estrategia Se comprueba que la clave ingresada existe a través del método prioridad2boolean, luego si la misma existe, se genera una cola auxiliar y se iguala a origen, para realizar su recorrido en busca de la prioridad, cuando se encuentra la prioridad, se realiza el desacolado en origen.
	 * @tarea Elimina la clave ingresada del diccionario, si la clave no existe, no se realiza ninguna acción.
	 * @parámetros Se recibe la clave a eliminar.
	 * @devuelve nada, método void.
	 * @precondiciones Diccionario inicializado.
	 * @postcondiciones Se realiza la eliminación o no.
	 * @costo Lineal
	 */

	@Override
	public void eliminar(int clave) {
		
		boolean exists = prioridad2boolean(clave);
		
		if(exists) {
			ColaPrioridadTDA aux = new ColaPrioridad();
			aux.InicializarCola();
			
			aux = origen;
			
			while (!aux.ColaVacia()) { // Constante
				
				if(aux.Prioridad() == clave) {
					origen.Desacolar();
				}//Constante
				
				aux.Desacolar();
				
			} // --> Lineal
		}// --> Lineal

	}
	
	/**
	 * @estrategia Se declara una cola auxiliar y se iguala a origen, además se declara una variable valor a retornar inicializada en 0, se recorre la cola mientras no esté vacía, una vez encontrada la prioridad, se asigna el valor numérico a la variable valor y se retorna dicha variable. 
	 * @tarea Recupera el valor numérico de la clave solicitada.
	 * @parámetros Se recibe la clave.
	 * @devuelve valor: Valor numérico asociado a la clave.
	 * @precondiciones pila inicializada y clave existente.
	 * @postcondiciones Se realiza la búsqueda y se retorna el valor numérico asociado a la clave.
	 * @costo Lineal
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
			}// --> Constante
			
			aux.Desacolar();
			
		}// --> Lineal
		
		return valor;
	}
	
	/**
	 * @estrategia Se declara e inicializa el conjunto a retornar, además de inicializar una cola auxiliar e igualarla a origen para recorrer. Se recorrerá todo la cola auxiliar agregando las prioridades al conjunto, finalmente se retornará el conjunto indicado.
	 * @tarea Retorna el conjunto de claves del diccionario.
	 * @parámetros No se recibe ningún parámetro.
	 * @devuelve c: El conjunto de claves del diccionario.
	 * @precondiciones Diccionario inicializado.
	 * @postcondiciones Se realiza el apilado y se mantiene la estructura valores proveída al método.
	 * @costo Polinómico
	 */

	@Override
	public ConjuntoTDA claves() {
		
		ConjuntoTDA c = new Conjunto();
		c.InicializarConjunto();
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.InicializarCola();
		
		aux = origen;
		
		while (!aux.ColaVacia()) { // Constante
			
			c.Agregar(aux.Prioridad()); // Lineal
			aux.Desacolar();
		}// --> Polinómico
		
		return c;
	}

}
