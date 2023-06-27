package user;

import impl.Conjunto;
import tdas.ConjuntoTDA;

// Ejercicio 7//

public class DiccionarioMultipleACola {
	
	/**
	 * @estrategia Para la realización de este ejercicio, se optó por la estrategia de recorrer todas las claves del diccionario y obtener los valores correspondientes para cada clave. Luego, se recorre el conjunto de valores obtenido para identificar las repeticiones y acolar en "sinrep" los valores correspondientes sin su repetición.
	 * @tarea Crear una cola que reciba como parámetro un diccionario múltiple y retorne sus valores sin repeticiones.
	 * @parámetros dic: Diccionario múltiple recibido para crear la cola.
	 * @devuelve sinrep: Cola generada a partir del diccionario proveído sin repeticiones de valores.
	 * @precondiciones: Cola inicializada, Diccionario inicializado y no vacío.
	 * @postcondiciones Se retorna la cola solicitada.
	 * @costo Polinómico
	 */
	
public static ColaTDA diccionarioMultipleACola(DiccionarioMultipleTDA dic) {
		
		ColaTDA sinrep = new Cola();
		sinrep.inicializarCola();
		
		ConjuntoTDA clavesdic = new Conjunto();
		clavesdic.InicializarConjunto();
		
		while(!clavesdic.ConjuntoVacio()) {
			int clave = clavesdic.Elegir();
			
			ConjuntoTDA valores = new Conjunto();
			valores.InicializarConjunto();
			
			valores = dic.recuperar(clave);
			
			while(!valores.ConjuntoVacio()) {
				
				int valor = valores.Elegir();
				
				if(!valores.Pertenece(valor)) {
					
					sinrep.acolar(valor);
					
				}
				
				valores.Sacar(valor);
				
			}
			
			clavesdic.Sacar(clave);
	
		}// --> Costo polinómico ya que tenemos una iteración dentro de otra iteración.
			
		return sinrep;
		
	}

}
