package PilaColaLista;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PilaDinamica<T>implements Pila<T>{
	private class Nodo<T>{
	public T dato;
	public Nodo<T> siguiente;
	
	}
	
	private Nodo <T> cima;
	
	public PilaDinamica(){
		this.cima=null;
	}

	public boolean isEmpty() {
		if(cima==null)
		return true;
		else
		return false;
	}


	public void push(T dato) {
		Nodo<T> nuevoNodo=new Nodo<T>();
		nuevoNodo.dato=dato;
		if(cima==null){
		nuevoNodo.siguiente=null;
		cima=nuevoNodo;}
		else{
		nuevoNodo.siguiente=cima;
		cima=nuevoNodo;
		}
		
	}

	public T pop() {
		if (cima!=null){
		T dato=cima.dato;
		cima=cima.siguiente;
		return dato;
		}
		else
		return null;
		
	}

	public T peek() {
		
		if (cima!=null)
		return cima.dato;
		else
		return null;
	
		
	}

	public void empty() {
		cima=null;
		
	}
	
	public static void main(String[] args) {
		Calendar tIni = new GregorianCalendar();
		PilaDinamica<Integer> n1=new PilaDinamica<Integer>();
		System.out.println("INICIO\n\nApilando datos...\nFinalizado.");
		for(int i=0;i<1000000;i++)
			n1.push(i);
		System.out.println("\nDesapilar primer elemento: "+n1.pop());
		
		System.out.println("\nLa pila esta vacia?: "+n1.isEmpty());
		
		System.out.println("\nMostrar primer elemento de la pila: "+n1.peek());
		
		n1.empty();
		
		System.out.println("\nLa pila esta vacia?: "+n1.isEmpty());
		
		System.out.println("\nMostrar primer elemento de la pila: "+n1.peek());
		Calendar tFin = new GregorianCalendar() ;
		long diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("\n\nRendimiento de algoritmo: ");
		System.out.println(diff);
	}


}
