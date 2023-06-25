package tdas;


public interface MultiPilaTDA {
	
	/** 
	* Si la multipila actualmente es: (tope) 3 - 5 - 7
	* Y la pila que se recibe es: (tope) 1 - 9
	* La multipila debe quedar: (tope) 1 - 9 - 3 - 5 - 7
	*/
	
	public void apilar (PilaTDA valores);
	
	/** Desapila la pila recibida por parámetro de la multipila,
	* solo si el tope de la multipila coincide con la pila recibida.
	* Si la multipila actualmente es: (tope) 7 - 2 - 8 - 9
	* Y la pila que se recibe es: (tope) 7 - 2
	* La multipila debe quedar: (tope) 8 - 9
	* Si en cambio la pila que se recibe es: (tope) 7 - 2 - 3
	* No deben realizarse cambios en la multipila, dado que no coincide con la pila recibida.
	* 
	* Tarea: Desapila la pila recibida por parámetro de la multipila, solo si el tope de la multipila coincide con la pila recibida.<p>
	* Precondiciones: Pila inicializado<p>
	* Costo: <p>
	* @param valores Pila a desapilar de la multipila. <p>
	*/
	
	public void desapilar (PilaTDA valores);
	
	/** 
	* Si la multipila actualmente es: (tope) 4 - 2 - 9 - 7
	* Y se recibe por parámetro un 2, debe devolverse la pila: (tope) 4 - 2
	* Si se recibe por parámetro un 5, debe devolverse la pila: (tope) 4 - 2 - 9 - 7
	* 
	* Tarea: Devuelve una pila con los valores que estén en el tope de la multipila. La cantidad de valores a devolver se define por parámetro y debe preservarse el orden.
	* Si la cantidad es mayor al tamaño actual de la multipila, se devuelven todos los valores de la multipila.<p>
	* Precondiciones: Pila inicializada<p>
	* Costo: <p>
	* @param valor Valor numérico a agregar al conjunto. <p>
	* @return tope devuelve el error en true si no se agrega un nuevo valor, false si se agregó correctamente.
	*/
	
	public PilaTDA tope (int cantidad);
	
	/** 
	* Tarea: Inicializa la pila.<p>
	* Costo: <p>
	*/
	
	public void inicializarPila();
	
	/** 
	* Tarea: Devuelve un booleano que indica si la pila está vacía.<p>
	* Precondiciones: Pila inicializada<p>
	* Costo: Constante<p>
	* @return Devuelve un booleano que indica si la pila está vacía.
	*/
	
	public boolean pilaVacia();
	}

