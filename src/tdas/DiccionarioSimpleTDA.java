package tdas;


public interface DiccionarioSimpleTDA {
	
	void inicializarDiccionario();
	void agregar(int clave, int x);
	void eliminar(int clave);
	int recuperar(int clave);
	ConjuntoTDA claves();

}
