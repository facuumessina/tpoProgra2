package impl;

import tda.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo origen;
	
	@Override
	public void inicializarConjunto() {
		origen = null;
	}

	@Override
	public Respuesta agregar(int valor) {
		Respuesta resp = new Respuesta();
		if (!this.pertenece(valor)) { // se verifica pertenencia
			Nodo nuevo = new Nodo(); // el nuevo nodo que se agregará
			nuevo.info = valor;
			nuevo.sig = origen;
			origen = nuevo;
			resp.error = false;
		}else {
			resp.error = true;
		}
		return resp;
	}

	@Override
	public Respuesta sacar(int valor) {
		Respuesta resp = new Respuesta();
		if (origen != null) {
			if (origen.info == valor) { //es el primero
				origen = origen.sig;
				resp.error = false;
			}else { //es algún otro; lo buscamos
				Nodo aux = origen;
				while (aux.sig != null && aux.sig.info != valor) {
					aux = aux.sig;
				}
				if (aux.sig != null) {// encontrado
					aux.sig = aux.sig.sig;
					resp.error = false;
				}
			}
		}else {
			resp.error = true;
		}
		return resp;
	}

	@Override
	public Respuesta elegir() {
		Respuesta resp = new Respuesta();
		if(!conjuntoVacio()) {
			resp.rta = origen.info;
			resp.error = false;
		}else {
			resp.error = true;
		}
		
		return resp;
	}

	@Override
	public boolean pertenece(int valor) {
	boolean resp;
		if (origen != null) {
			if (origen.info == valor) { //es el primero
				resp = true;
			}else { //es algún otro; lo buscamos
				Nodo aux = origen;
				while (aux.sig != null && aux.sig.info != valor) {
					aux = aux.sig;
				}
				if (aux.sig != null) {// encontrado
					resp = true;
				}else {
					resp = false;
				}
				}
			}else {
			resp = false;
		}
		return resp;
	}

	@Override
	public boolean conjuntoVacio() {
		return origen == null;
	}

}