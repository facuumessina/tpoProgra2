package user;

// Ejercicio 9 //

public class TotalHojasParABB {
	
	/**
	* @estrategia Para la realizacion de este ejercicio optamos por crear un metodo (mayor, menor) que recorran nuestro arbol hasta que el 
	* subarbol este vacio, lo que significaria que es una hoja, ya que no tiene mas hijos. Luego verifica que el valor de las mismas 
	* sean divisible por 2 y si así es, lo cuenta en CantHojas.
	* @tarea Crea un arbol, busca las hojas y verifica las que sean pares. Luego imprime la cantidad de hojas con valor par.
	* @parámetros No recibe parametros.
	* @devuelve Retorna la cantidad de hojas que tienen valor par.
	* @precondiciones Arbol inicializado y no vacío.
	* @postcondiciones Se retorna la cantidad de hojas con valor par.
	* @costo Constante
	*/
	
	//Determina la cantidad de nodos hoja con valor par
	public static int nodosPares(ABBTDA a){
		int cantHojas = 0;// constante
		if(a.ArbolVacio()){ // constante
			return 0;
		} // --> Constante
		//extraigo el elemento derecha e izquierda del arbol
		ABBTDA der = a.HijoDer();
		ABBTDA izq = a.HijoIzq();
		//recorro las ramas derecha e izquierda de cada nodo para obtener 
		//las hojas de cada rama
		int mayorIzq = a.mayor(izq); // constante
		int menorIzq = a.menor(izq); // constante
		int mayorDer = a.mayor(der); // constante
		int menorDer = a.menor(der); // constante
		//si el valor es par lo cuento 
		if(mayorIzq %2 == 0) { // constante
			cantHojas++;
		}// --> Constante
		
		if(menorIzq %2 == 0) { // constante 
			cantHojas++;
		} // --> Constante
		
		if(mayorDer %2 == 0) { // constante
			cantHojas++;
		} // --> Constante
		
		if(menorDer %2 == 0) { // constante
			cantHojas++;
		} // --> Constante
		//retorno la cuenta
		return cantHojas;
	}

	public static int mayor(ABBTDA a) {
		if(a.HijoDer().ArbolVacio()) // constante
			return a.Raiz();
		else
			return mayor(a. HijoDer());
	} // --> Constante
	
	public static int menor(ABBTDA a) {
		if(a.HijoIzq().ArbolVacio()) // Constante
			return a.Raiz();
		else
			return menor(a.HijoIzq());
	}// --> Constante

}
