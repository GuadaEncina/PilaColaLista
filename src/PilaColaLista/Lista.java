package PilaColaLista;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Lista<T> {
	private class Nodo<T>{
		public T dato;
		public Nodo<T> siguiente;
		
		public Nodo(T dato) {
			this.dato=dato;
			this.siguiente=null;
		}
		public Nodo (T dato, Nodo<T> siguiente){
			this.dato=dato;
			this.siguiente=siguiente;
			}
		
	}
	
	private Nodo<T> primero;
	private Nodo<T> ultimo;
	private int size;
	
	public Lista(){
		this.primero=this.ultimo=null;
		this.size=0;
	}
	public boolean isEmpty(){
		if(primero==null){
			return true;
		}else
			return false;
	}
	public void empty(){
		primero=null;
		size=0;
	}
	public void pushFront(T dato){
		
		primero=new Nodo<T>(dato,primero);
		if(ultimo==null){
			ultimo=primero;
		}
		size++;
	}
	public int size(){
		return size;
	}
	public void pushBack(T dato){
		Nodo<T> nuevoNodo= new Nodo<T>(dato);
		if(isEmpty()){
			primero=ultimo=nuevoNodo;
		}else{
			ultimo.siguiente=nuevoNodo;
			ultimo=ultimo.siguiente;
		}
		size++;
	}

	public T popFront(){
		
		if (!isEmpty()){
			T dato= primero.dato;
			primero=primero.siguiente;
			size--;
			if(primero==ultimo)
				
			ultimo=null;
			
			return dato;
		}else
			
			return null;
		}
		
	public T popBack(){
		if(!isEmpty()){
			T dato=ultimo.dato;
			if(primero==ultimo){
			primero=ultimo=null;
			}else{
			Nodo<T> nuevoNodo=primero;
			while(nuevoNodo.siguiente!=ultimo){
			nuevoNodo=nuevoNodo.siguiente;
			}
			ultimo=nuevoNodo;
			ultimo.siguiente=null;

			}
			return dato;

		}else
			return null;
	}
	public boolean search(T dato){
		Nodo<T> nuevoNodo=primero;
		boolean encuentra=false;
		while(nuevoNodo!=null && encuentra==false){
		if(nuevoNodo.dato==dato)
			encuentra=true;	
			nuevoNodo=nuevoNodo.siguiente;
		}
		return encuentra;
	}
	
	public void insertAt(T dato, int pos){
		Nodo<T> nuevoNodo=primero;
		Nodo<T>aux=null;
		Nodo<T> auxNodo=primero;
		int cont=1;
		if (pos<1|| pos>=size()){
			System.out.println("Error");
		}else{
			if(pos==1){
				pushFront(dato);
			}else 
				if (pos==size-1){
					pushBack(dato);
				}else{
					while(nuevoNodo!=null){
						if(pos==cont){
							aux=new Nodo<T>(dato,nuevoNodo);
							auxNodo.siguiente=aux;
						}
						auxNodo=nuevoNodo;
						cont ++;
						nuevoNodo=nuevoNodo.siguiente;
					}
				}
		}
	}
		

		
	
	public void mostrarLista(){
		Nodo<T> nuevoNodo=primero;
		while(nuevoNodo!=null){
		System.out.println(nuevoNodo.dato);
		nuevoNodo=nuevoNodo.siguiente;
		}
	}
	public T searchAt (int pos){

		Nodo<T> nuevoNodo=primero;
		int cont=1;
		T devuelve = null;
		if(pos<1|| pos>size()){
		System.out.println("La posicion no es correcta");
		}else{
			while(nuevoNodo!=null){
				if(pos==cont){
					devuelve=nuevoNodo.dato;
				}
				nuevoNodo=nuevoNodo.siguiente;
				cont++;
			}
		}
		return devuelve;
	}
	public void eraseAt(int pos){
		Nodo<T> nuevoNodo=primero;
		Nodo <T> aux= null;
		int cont=1;
		if (pos<1|| pos>=size()){
		System.out.println("Error");
		}else{
		while(nuevoNodo!=null){
		if(pos==cont){
		if (aux==null){
			primero=primero.siguiente;
		}else{
			aux.siguiente=nuevoNodo.siguiente;
		}
		nuevoNodo=null;
		}else{
			aux=nuevoNodo;
			nuevoNodo=nuevoNodo.siguiente;
			cont++;
		}
		}
		}
	}
	public void remove(T dato){
		if(!isEmpty()){
		if(primero==ultimo && dato==primero.dato){
		primero=ultimo=null;
		}else if(dato==primero.dato){
		primero=primero.siguiente;
		}else{
		Nodo<T> aux=primero;
		Nodo<T> nuevoNodo=primero.siguiente;
		while(nuevoNodo!=null    &&    nuevoNodo.dato!=dato){
		aux=aux.siguiente;
		nuevoNodo=nuevoNodo.siguiente;
		}
		if(nuevoNodo!=null){
		aux.siguiente=nuevoNodo.siguiente;
		if(nuevoNodo==ultimo) 
			ultimo=aux;
		}
		}
		}
	}
	public void reverse(){
		Nodo<T> nuevoNodo=primero;
		Nodo<T> aux=null;
		while(nuevoNodo.siguiente!=null){
		aux=nuevoNodo.siguiente;
		nuevoNodo.siguiente=aux.siguiente;
		aux.siguiente=primero;
		primero=aux;
		
		}
		}



	
	public static void main(String[] args) {
		Calendar tIni = new GregorianCalendar();
		Lista <Integer> n1= new Lista<Integer>();
		System.out.println("INICIO");
		System.out.println("\n\nLa lista esta vacia?:  "+n1.isEmpty());
		System.out.println("\nCargando datos...");
		n1.pushFront(1);
		n1.pushFront(2);
		n1.pushFront(3);
		n1.pushFront(4);
		System.out.println("\nMostrar Lista:");
		n1.mostrarLista();
		System.out.println("\nEl valor 2 esta en la lista?:  "+n1.search(2));
		System.out.println("\nPrimer elemento borrado: "+n1.popFront());
		System.out.println("\n\nLa lista esta vacia?:  "+n1.isEmpty());
		System.out.println("\nCantidad de elementos en la lista:  "+n1.size());
		n1.empty();
		System.out.println("\n\nLa lista esta vacia?:  "+n1.isEmpty());
		System.out.println(n1.size());
		n1.pushBack(7);
		n1.pushBack(54);
		n1.pushBack(9);
		n1.pushBack(435);
		n1.pushBack(66);
		n1.pushBack(5);
		n1.pushBack(33);
		n1.pushBack(19);
		n1.pushBack(74);
		n1.pushBack(65);
		System.out.println("\nEl valor 2 esta en la lista?:  "+n1.search(4));
		System.out.println("\nCantidad de elementos en la lista:  "+n1.size());
		System.out.println("\nPrimer elemento borrado: "+n1.popFront());
		System.out.println("\nMostrar Lista:");
		n1.mostrarLista();
		System.out.println("\nCantidad de elementos en la lista:  "+n1.size());
		System.out.println("\nBuscar elemento en la posicion 3:  "+n1.searchAt(3));
		System.out.println("\nUltimo elemento borrado: "+n1.popBack());
		System.out.println("\nUltimo elemento borrado: "+n1.popBack());
		System.out.println("\nCantidad de elementos en la lista:  "+n1.size());
		n1.insertAt(4,2);
		System.out.println("\nMostrar Lista:");
		n1.mostrarLista();
		System.out.println("\nBuscar elemento en la posicion 4:  "+n1.searchAt(4));
		n1.eraseAt(6);
		System.out.println("\nMostrar Lista:");
		n1.mostrarLista();
		System.out.println("\nBorrar elemento 33");
		n1.remove(33);
		System.out.println("\nMostrar Lista:");
		n1.mostrarLista();
		System.out.println("\nInvertir los elementos de la Lista...");
		n1.reverse();
		System.out.println("\nMostrar Lista:");
		n1.mostrarLista();
		Calendar tFin = new GregorianCalendar() ;
		long diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("\n\nRendimiento de algoritmo: ");
		System.out.println(diff);
	}
	



}
