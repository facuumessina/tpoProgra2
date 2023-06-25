package tdas;

public interface ConjuntoEspecialTDA {
	
	public class Respuesta {
		public boolean error;
		public int rta;
	}
		
	/**
	* Tarea: Inicializa el conjunto.<p>
	* Costo: Constante<p>
	*/
	public void inicializarConjunto();
	/**
	* Tarea: Valida si el valor agregado ya {@link #pertenece} al conjunto, de lo contrario, agrega el valor al conjunto.<p>
	* Precondiciones: Conjunto inicializado<p>
	* Costo: Lineal<p>
	* @param valor Valor numérico a agregar al conjunto. <p>
	* @return resp devuelve el error en true si no se agrega un nuevo valor, false si se agregó correctamente.
	*/
	public Respuesta agregar(int valor);
	/**
	* Tarea: Elimina un valor del conjunto.<p>
	* Precondiciones: Conjunto inicializado<p>
	* Costo: Lineal<p>
	* @param valor Valor numérico a eliminar del conjunto. <p>
	* @return resp devuelve el error en true si no se realiza una eliminación, false si se eliminó el error.
	*/
	public Respuesta sacar(int valor);
	/**
	* Tarea: Devuelve un valor del conjunto.<p>
	* Precondiciones: Conjunto inicializado y no vacío<p>
	* Costo: Lineal<p>
	* @return Respuesta Si el conjunto no tenía valores, devuelve la Respuesta con error en true, en caso contrario, la Respuesta contiene el error en false y en respuesta el valor.
	*/
	public Respuesta elegir();
	/**
	* Tarea: Validar si un valor pertenece al conjunto.<p>
	* Precondiciones: Conjunto inicializado<p>
	* Costo: Lineal<p>
	* @param valor Valor numérico a validar si pertenece al conjunto. <p>
	* @return resp Devuelve un booleano indicando si un valor pertenece al conjunto.
	*/
	public boolean pertenece(int valor);
	/**
	* Tarea: Validar si el conjunto está vacío.<p>
	* Precondiciones: Conjunto inicializado<p>
	* Costo: Constante<p>
	* @param valor Valor numérico a validar si pertenece al conjunto. <p>
	* @return Devuelve un booleano indicando si el conjunto está vacío o no.
	*/
	public boolean conjuntoVacio();
	}

