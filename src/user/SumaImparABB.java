package user;

import impl.Conjunto;
import tdas.ConjuntoTDA;

public class SumaImparABB {
	
	/**
	 * @estrategia Para la realización de este ejercicio, se optó por la estrategia de recorrer todas las claves del diccionario y obtener los valores correspondientes para cada clave. Luego, se recorre el conjunto de valores obtenido para identificar las repeticiones y acolar en "sinrep" los valores correspondientes sin su repetición.
	 * @tarea Crear una cola que reciba como parámetro un diccionario múltiple y retorne sus valores sin repeticiones.
	 * @parámetros dic: Diccionario múltiple recibido para crear la cola.
	 * @devuelve sinrep: Cola generada a partir del diccionario proveído sin repeticiones de valores.
	 * @precondiciones: Cola inicializada, Diccionario inicializado y no vacío.
	 * @postcondiciones Se retorna la cola solicitada.
	 * @costo Polinómico
	 */
	
	public static int sumaImparABB(ABBTDA a) {
		
		ConjuntoTDA nodosIm = new Conjunto();
		nodosIm.InicializarConjunto();
		
		nodosIm = nodosImpares(a);
		
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
	 * @estrategia Para la realización de este ejercicio, se optó por la estrategia de recorrer todas las claves del diccionario y obtener los valores correspondientes para cada clave. Luego, se recorre el conjunto de valores obtenido para identificar las repeticiones y acolar en "sinrep" los valores correspondientes sin su repetición.
	 * @tarea Crear una cola que reciba como parámetro un diccionario múltiple y retorne sus valores sin repeticiones.
	 * @parámetros dic: Diccionario múltiple recibido para crear la cola.
	 * @devuelve sinrep: Cola generada a partir del diccionario proveído sin repeticiones de valores.
	 * @precondiciones: Cola inicializada, Diccionario inicializado y no vacío.
	 * @postcondiciones Se retorna la cola solicitada.
	 * @costo Polinómico
	 */
	
	public static ConjuntoTDA nodosImpares(ABBTDA a){
		
		ConjuntoTDA r = new Conjunto();
		r.InicializarConjunto();
		
		if (!a.ArbolVacio()){
			if (a.Raiz() % 2 != 0){
				r.agregar(a.Raiz());
			}
			
			ConjuntoTDA rI = nodosImpares(a.HijoIzq());
		
			ConjuntoTDA rD = nodosImpares(a.HijoDer());
		
			while (!rI.ConjuntoVacio()){
				
				int x = rI.Elegir();
				r.Agregar(x);
				rI.Sacar(x);
			}
		
			while (!rD.ConjuntoVacio()){
				
				int x = rD.Elegir();
				r.Agregar(x);
				rD.Sacar(x);
		
			}
		
		}
		
		return r;
}

}
