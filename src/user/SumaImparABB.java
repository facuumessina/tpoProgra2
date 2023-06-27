package user;

import impl.Conjunto;
import tdas.ConjuntoTDA;

public class SumaImparABB {
	
	/**
	 * @estrategia Para la realización de este método, se inicializará un conjunto el cual contendrá a los nodos impares recibidos por el método auxiliar nodosImpares, se declararan dos variables enteras, los cuales una contendrá el elemento extraído del conjunto y la otra la suma de los elementos extraídos del conjunto. Se recorrerá el conjunto obtenido sacando y sumando los valores hasta obtener el total "sum" con todos los valores impares del ABB.
	 * @tarea Crear un metodo que retorne la suma de todos los elementos de valor impar del ABB.
	 * @parámetros a: ABB recibido para realizar el método.
	 * @devuelve sum: Suma de todos los nodos impares del ABB.
	 * @precondiciones: Arbol inicializado.
	 * @postcondiciones Se retorna el valor entero solicitado.
	 * @costo Polinomico
	 */
	
	public static int sumaImparABB(ABBTDA a) {
		
		ConjuntoTDA nodosIm = new Conjunto();
		nodosIm.InicializarConjunto();
		
		nodosIm = nodosImpares(a); // Polinomico --> se asume ya que es el peor costo asumible por el método
		
		int sum = 0;
		int g;
		
		while(!nodosIm.ConjuntoVacio()) {
			
			g = nodosIm.Elegir();
			sum += g;
			nodosIm.Sacar(g);
		}
		
		return sum;
	}
	
	/**
	 * @estrategia A través de la recursividad, se validará que los nodos del arbol (y sus respectivos sub-arboles) sean impares (resto distinto de 0), en ese caso, se añadirán al conjunto r a retornar. 
	 * @tarea Generar un conjunto el cual contenga todos los nodos impares del arbol.
	 * @parámetros a: ABB recibido para generar el conjunto.
	 * @devuelve r: Conjunto generado a partir de los nodos impares del ABB.
	 * @precondiciones: ABB inicializado.
	 * @postcondiciones Se retorna el conjunto solicitado.
	 * @costo Polinómico
	 */
	
	public static ConjuntoTDA nodosImpares(ABBTDA a){
		
		ConjuntoTDA r = new Conjunto();
		r.InicializarConjunto();
		
		if (!a.ArbolVacio()){// constante
			
			if (a.Raiz() % 2 != 0){
				r.agregar(a.Raiz());
			}
			
			ConjuntoTDA rI = new Conjunto();
			rI.InicializarConjunto();
					
			rI = nodosImpares(a.HijoIzq());
		
			ConjuntoTDA rD = new Conjunto();
			rD.InicializarConjunto();
					
			rD = nodosImpares(a.HijoDer());
		
			while (!rI.ConjuntoVacio()){// constante
				
				int x = rI.Elegir();
				r.Agregar(x);
				rI.Sacar(x);// lineal
			}// --> Polinómico (Ya que se debe a una iteración de un ciclo con operaciones que poseen costo lineal, se asume por ser el peor costo posible)
		
			while (!rD.ConjuntoVacio()){
				
				int x = rD.Elegir();
				r.Agregar(x);
				rD.Sacar(x);
		
			}
		
		}
		
		return r;
}

}
