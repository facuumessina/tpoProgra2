package user;

import impl.Conjunto;
import tdas.ConjuntoTDA;

public class GrafoYVertAConjunto {
	
		public static ConjuntoTDA encontrarVerticesPuente(GrafoTDA grafo, int verticeOrigen, int verticeDestino) {
	    
			ConjuntoTDA verticesPuente = new Conjunto();
			verticesPuente.InicializarConjunto();

			if (existeVertice(grafo,verticeOrigen) && existeVertice(grafo,verticeDestino)) {
		
				ConjuntoTDA vertices = new Conjunto();
				vertices.InicializarConjunto();
		
				vertices = grafo.Vertices();
    
				while (!vertices.ConjuntoVacio()) {
				
					int verticeActual = vertices.Elegir();
					vertices.Sacar(verticeActual);
        
					// Verificar si el vértice actual es un vértice puente entre el vértice origen y el vértice destino
			
					if (esVerticePuente(grafo, verticeActual, verticeOrigen, verticeDestino)) {
					
						verticesPuente.agregar(verticeActual);
					}
				}
			}

			return verticesPuente;
		}

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
	
			return (grafo.ExisteArista(verticeOrigen, vertice) && grafo.ExisteArista(vertice, verticeDestino));
		}

}
