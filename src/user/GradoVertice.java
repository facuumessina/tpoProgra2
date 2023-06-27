package user;

import impl.Conjunto;
import tdas.ConjuntoTDA;
import tda.GrafoTDA;

public class GradoVertice {
	
	/**
	 * @estrategia Para la realización del ejercicio, se requiere de la realización de 4 métodos auxiliares. El primero, se encargará de retornar un booleano indicando si existe el vertice recibido como parámetro en el grafo indicado, se utilizará como validación para calcular el grado, en caso de que exista, se obtendrán los conjuntos de salidas y entradas adyacentes a través de 2 métodos auxiliares y para finalmente calcular el grado, a través de un cuarto método auxiliar, se obtendrán los tamaños (cantidad de elementos del conjunto) y se restarán salidas menos entradas tal como se solicita, retornando finalmente el grado.
	 * @tarea Calcular el grado de un vertice de un grafo y retornar dicho valor entero.
	 * @parámetros grafo: Grafo recibido el cual pertenece el vertice a calcular su grado. vertice: Vertice recibido a calcular su grado.
	 * @devuelve grado: Valor entero que representa el grado del vertice.
	 * @precondiciones: Grafo inicializado y no vacío.
	 * @postcondiciones Se retorna el valor entero.
	 * @costo Polinomico
	 */
	
public static int calcularGradoVertice(GrafoTDA grafo, int vertice) {
	    
		int grado = 0;
	    
	    if (existeVertice(grafo, vertice)) { // Polinomico (Ya que el método existeVertice tiene costo Polinomico, se asume ya que es el peor costo asumible en el método)
	        
	    	ConjuntoTDA adyacentesSalida = new Conjunto();
	    	adyacentesSalida.InicializarConjunto();
	    	
	    	adyacentesSalida = adyacentesSalida(grafo, vertice);
	    	
	        ConjuntoTDA adyacentesEntrada = new Conjunto();
	        adyacentesEntrada.InicializarConjunto();
	        
	        adyacentesEntrada = adyacentesEntrada(grafo, vertice);
	        
	        grado = tamañoConjunto(adyacentesSalida) - tamañoConjunto(adyacentesEntrada);
	    }
	    
	    return grado;
	}

	/**
	 * @estrategia Para la realización del siguiente método auxiliar, se inicializará un conjunto el cual contendrá los vertices adyacentes de salida, luego se validará si el vertice existe en el grafo recibido y se recorrerá el conjunto de vertices validando si existe una arista entre el vertice recibido y el conjunto de vertices del grafo, en caso afirmativo, se añadirá al conjunto adyacentes. Se retornará dicho conjunto.
	 * @tarea Crear un conjunto con los vertices adyacentes de salida segun el grafo y vertice recibido.
	 * @parámetros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
	 * @devuelve adyacentes: Conjunto generado que almacenará los vértices adyacentes de salida segun el grafo y vertice recibido.
	 * @precondiciones: Grafo inicializado.
	 * @postcondiciones Se retorna el conjunto de vertices.
	 * @costo Polinómico
	 */
	
	public static ConjuntoTDA adyacentesSalida(GrafoTDA grafo, int vertice) {
	    
		ConjuntoTDA adyacentes = new Conjunto();// Conjunto que almacenar los vértices adyacentes de salida
	    adyacentes.InicializarConjunto();
		
	    if (existeVertice(grafo, vertice)) { // Polinómico (Se asume dicho costo ya que es el peor costo asumible por el método)
	        
	    	ConjuntoTDA vertices = new Conjunto();
	    	vertices.InicializarConjunto();
	        
	        vertices = grafo.Vertices();
	        
	        while (!vertices.ConjuntoVacio()) {
	            int verticeActual = vertices.Elegir();
	            
	            if (grafo.ExisteArista(vertice, verticeActual)) {
	                adyacentes.Agregar(verticeActual);
	            }
	            
	            vertices.Sacar(verticeActual);
	        }
	    }
	    
	    return adyacentes;
	}
	
	/**
	 * @estrategia Para la realización del siguiente método auxiliar, se inicializará un conjunto el cual contendrá los vertices adyacentes de entrada, luego se validará si el vertice existe en el grafo recibido y se recorrerá el conjunto de vertices validando si existe una arista entre el vertice recibido y el conjunto de vertices del grafo, en caso afirmativo, se añadirá al conjunto adyacentes. Se retornará dicho conjunto.
	 * @tarea Crear un conjunto con los vertices adyacentes de entrada segun el grafo y vertice recibido.
	 * @parámetros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
	 * @devuelve adyacentes: Conjunto generado que almacenará los vértices adyacentes de entrada segun el grafo y vertice recibido.
	 * @precondiciones: Grafo inicializado.
	 * @postcondiciones Se retorna el conjunto de vertices.
	 * @costo Polinómico
	 */

	public static ConjuntoTDA adyacentesEntrada(GrafoTDA grafo, int vertice) {
	    
		ConjuntoTDA adyacentes = new Conjunto();// Conjunto que almacena los vértices adyacentes de entrada
		adyacentes.InicializarConjunto();
	    
	    if (existeVertice(grafo, vertice)) {// Polinomico (Se asume dicho costo ya que es el peor costo que podemos asumir en el método)
	        
	    	ConjuntoTDA vertices = new Conjunto();
	        vertices.InicializarConjunto();
	        
	        vertices = grafo.Vertices();
	        
	        while (!vertices.ConjuntoVacio()) {
	            int verticeActual = vertices.Elegir();
	            
	            if (grafo.ExisteArista(verticeActual, vertice)) {
	                adyacentes.Agregar(verticeActual);
	            }
	            
	            vertices.Sacar(verticeActual);
	        }
	    }
	    
	    return adyacentes;
	}
	
	/**
	 * @estrategia Para la realización de este método auxiliar, se inicializará un nuevo conjunto el cual contendrá los vertices del grafo recibido, se utilizará el conjunto como validación mientras este no esté vacío para recorrer el conjunto y validar si el vertice recibido se encuentra en dicho conjunto.
	 * @tarea Validar si existe el vertice recibido en el grafo recibido.
	 * @parámetros grafo: Grafo recibido a validar. vertice: Vertice recibido a validar.
	 * @devuelve boolean: retorna true si se encuentra el vertice en el conjunto de vertices, de lo contrario, false.
	 * @precondiciones: Grafo inicializado.
	 * @postcondiciones Se retorna el booleano solicitado.
	 * @costo Polinomico
	 */
	
	public static boolean existeVertice(GrafoTDA grafo, int vertice) {
	    
		ConjuntoTDA vertices = new Conjunto();
		vertices.InicializarConjunto();
		
		vertices = grafo.Vertices();
	    
	    while (!vertices.ConjuntoVacio()) {// Constante
	        int verticeActual = vertices.Elegir(); // Constante
	        vertices.Sacar(verticeActual); // Lineal
	        
	        if (verticeActual == vertice) { // Constante
	            return true;
	        }
	    }// --> Polinomico
	    
	    return false;
	}
	
	/**
	 * @estrategia Se recibe un conjunto, el cual es igualado a un aux para no modificar la estructura recibida como parámetro, y se recorrerá el conjunto sacando elementos y a su vez, se sumará un contador por cada elemento retirado. Finalmente, se retornará el contador.
	 * @tarea Calcular la cantidad de elementos que posee un conjunto.
	 * @parámetros c: Conjunto recibido a calcular.
	 * @devuelve contador: Cantidad de elementos del conjunto.
	 * @precondiciones: Conjunto inicializado.
	 * @postcondiciones Se retorna el entero solicitado.
	 * @costo Polinomico
	 */
	
	public static int tamañoConjunto(ConjuntoTDA c) {
		
		int contador = 0;
		
		ConjuntoTDA aux = new Conjunto();
		aux.InicializarConjunto();
		
		aux = c;
		
		while (!aux.ConjuntoVacio()) {// Constante
	        	aux.Sacar(aux.Elegir()); // Lineal
	        	contador++;
	    }// --> Polinomico
		
		return contador;
		
	}

}
