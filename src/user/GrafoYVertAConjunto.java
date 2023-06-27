package user;

import impl.Conjunto;
import tdas.ConjuntoTDA;

// Ejercicio 10 //

public class GrafoYVertAConjunto {
	
	/**
	* @estrategia Para la realizacion de este ejercicio se opto por: Crear 2 metodos a parte, uno que verifique si el vertice (que luego que pasaremos por paramentro el vertice actual encontrado) es puente de los vertices que nosotros definimos como origen y destino. El otro chequea que existan vertices dentro de nuestro grafo.
	* @tarea Busca vertices, los almacena  dn verticeActual y con el metodo esVerticePuente verifica si es puente del vertice origen o no.
	* @parámetros Grafo creado donde buscar los vertices, 2 numeros enteros del vertice origen y vertice destino.
	* @devuelve Retorna el conjunto VerticesPuente que contiene los vertices que si fueron puente entre el origen y el destino.
	* @precondiciones Conjunto donde almacenar vertices inicializado y grafo inicializado.
	* @postcondiciones Se retorna el conjunto de vertices puente.
	* @costo Polinomico
	*/
	
		public static ConjuntoTDA encontrarVerticesPuente(GrafoTDA grafo, int verticeOrigen, int verticeDestino) {
	    
			ConjuntoTDA verticesPuente = new Conjunto();
			verticesPuente.InicializarConjunto();

			if (existeVertice(grafo,verticeOrigen) && existeVertice(grafo,verticeDestino)) {
		
				ConjuntoTDA vertices = new Conjunto();
				vertices.InicializarConjunto();
		
				vertices = grafo.Vertices();
    
				while (!vertices.ConjuntoVacio()) {
				
					int verticeActual = vertices.Elegir();
					vertices.Sacar(verticeActual); // Lineal
        
					// Verificar si el vértice actual es un vértice puente entre el vértice origen y el vértice destino
			
					if (esVerticePuente(grafo, verticeActual, verticeOrigen, verticeDestino)) {
					
						verticesPuente.Agregar(verticeActual);
					}
				} // --> Polinomico ya que se debe a una iteración de un ciclo con operaciones que poseen costo lineal, se asume por ser el peor costo posible
			}

			return verticesPuente;
		}// --> Polinomico

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

		public static boolean esVerticePuente(GrafoTDA grafo, int vertice, int verticeOrigen, int verticeDestino) {
	
			return (grafo.ExisteArista(verticeOrigen, vertice) && grafo.ExisteArista(vertice, verticeDestino)); // Lineal
		} //--> Lineal

}
