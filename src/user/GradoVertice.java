package user;

import impl.Conjunto;
import tdas.ConjuntoTDA;
import tda.GrafoTDA;

public class GradoVertice {
	
public static int calcularGradoVertice(GrafoTDA grafo, int vertice) {
	    
		int grado = 0;
	    
	    if (existeVertice(grafo, vertice)) {
	        
	    	ConjuntoTDA adyacentesSalida = adyacentesSalida(grafo, vertice);
	        ConjuntoTDA adyacentesEntrada = adyacentesEntrada(grafo, vertice);
	        
	        grado = tamañoConjunto(adyacentesSalida) - tamañoConjunto(adyacentesEntrada);
	    }
	    
	    return grado;
	}
	
	public static ConjuntoTDA adyacentesSalida(GrafoTDA grafo, int vertice) {
	    
		ConjuntoTDA adyacentes = new Conjunto(); // Conjunto que almacenar los vértices adyacentes de salida
	    
	    if (existeVertice(grafo, vertice)) {
	        ConjuntoTDA vertices = grafo.Vertices();
	        
	        while (!vertices.ConjuntoVacio()) {
	            int verticeActual = vertices.Elegir();
	            
	            if (grafo.ExisteArista(vertice, verticeActual)) {
	                adyacentes.Agregar(verticeActual);
	            }
	            
	            vertices.sacar(verticeActual);
	        }
	    }
	    
	    return adyacentes;
	}

	public static ConjuntoTDA adyacentesEntrada(GrafoTDA grafo, int vertice) {
	    
		ConjuntoTDA adyacentes = new Conjunto(); // Conjunto que almacena los vértices adyacentes de entrada
	    
	    if (existeVertice(grafo, vertice)) {
	        ConjuntoTDA vertices = grafo.Vertices();
	        
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
	
	public static boolean existeVertice(GrafoTDA grafo, int vertice) {
	    
		ConjuntoTDA vertices = grafo.Vertices();
	    
	    while (!vertices.ConjuntoVacio()) {
	        int verticeActual = vertices.Elegir();
	        vertices.Sacar(verticeActual);
	        
	        if (verticeActual == vertice) {
	            return true;
	        }
	    }
	    
	    return false;
	}
	
	public static int tamañoConjunto(ConjuntoTDA c) {
		
		int contador = 0;
		
		ConjuntoTDA aux = new Conjunto();
		aux.InicializarConjunto();
		
		aux = c;
		
		while (!aux.ConjuntoVacio()) {
	        	aux.Sacar(aux.Elegir());
	        	contador++;
	    }
		
		return contador;
		
	}

}
