package impl;

import tdas.PilaTDA;

public class Pila implements PilaTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	
	@Override
	public void inicializarPila() {
		primero = null;

	}

	@Override
	public void apilar(int dato) {
		Nodo nuevo = new Nodo();
		nuevo.info = dato;
		nuevo.sig = primero;
		primero = nuevo;
	}

	@Override
	public void desapilar() {
		primero = primero.sig;
	}

	@Override
	public boolean pilaVacia() {
		return (primero == null);
	}

	@Override
	public int tope() {
		return primero.info;
	}

}
