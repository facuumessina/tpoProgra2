package tdas;


public interface MultiPilaTDA {
	
	/** 
	* Si la multipila actualmente es: (tope) 3 - 5 - 7 <p>
	* Y la pila que se recibe es: (tope) 1 - 9 <p>
	* La multipila debe quedar: (tope) 1 - 9 - 3 - 5 - 7 <p>
	*/
	
	public void apilar (PilaTDA valores);
	
	/** Desapila la pila recibida por parámetro de la multipila, solo si el tope de la multipila coincide con la pila recibida. <p>
	* Si la multipila actualmente es: (tope) 7 - 2 - 8 - 9 <p>
	* Y la pila que se recibe es: (tope) 7 - 2<p>
	* La multipila debe quedar: (tope) 8 - 9 <p>
	* Si en cambio la pila que se recibe es: (tope) 7 - 2 - 3<p>
	* No deben realizarse cambios en la multipila, dado que no coincide con la pila recibida.<p>
	*/
	
	public void desapilar (PilaTDA valores);
	
	/** 
	* Si la multipila actualmente es: (tope) 4 - 2 - 9 - 7 <p>
	* Y se recibe por parámetro un 2, debe devolverse la pila: (tope) 4 - 2 <p>
	* Si se recibe por parámetro un 5, debe devolverse la pila: (tope) 4 - 2 - 9 - 7<p>
	*/
	
	public PilaTDA tope (int cantidad);
	
	public void inicializarPila();
	
	public boolean pilaVacia();
	
}

