package user;

import tdas.PilaTDA;
import impl.DiccionarioSimple;
import impl.Pila;
import tdas.DiccionarioSimpleTDA;

// Ejercicio 6 //

public class PilaADiccionarioSimple {
	
	/**
	 * @estrategia Para comenzar se inicializan el diccionario simple a retornar en adición a la pila auxiliar, la cual nos ayudará a recorrer el parámetro recibido sin alterar su estructura. Se recorrerá la pila asignando el "valor" tope a la variable. En caso de que el "valor" no pertenecezca una clave dal diccionario, se agregará la clave con valor inicial 1. En caso contrario, si el valor ingresado como clave ya pertenece al conjunto, se recuperará el valor de la clave y se  pisará al anterior añadiendole 1 valor (como su repetición). 
	 * @tarea Crear un diccionario el cual contenga los valores de una pila recibida como parámetro como sus claves y su cantidad de repeticiones como valor.
	 * @parámetros pila: Pila recibida para crear el diccionario.
	 * @devuelve dic: Diccionario generado a partir de los valores de las pilas y sus repeticiones.
	 * @precondiciones: Diccionario inicializado, Pila inicializada y no vacía.
	 * @postcondiciones Se retorna el diccionario simple solicitado.
	 * @costo Polinómico
	 */
	
	public static DiccionarioSimpleTDA pilaADiccionarioSimple (PilaTDA pila) {
		
		DiccionarioSimpleTDA dic = new DiccionarioSimple();
		dic.inicializarDiccionario();
		
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		
		aux = pila;
		
		while(!aux.pilaVacia()) { // constante
			int valor = aux.tope();
			
			if(dic.claves().Pertenece(valor)) { //Lineal
				int repeti = dic.recuperar(valor);
				
				dic.agregar(valor, repeti + 1);
			}else {
				dic.agregar(valor, 1);
			}
			
			aux.desapilar();
		}// --> Polinómico
		
		return dic;
		
	}

}
