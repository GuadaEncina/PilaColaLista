package PilaColaLista;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PilaHL<T> extends Lista<T> implements Pila<T>{

	public void push(T dato) {
		this.pushFront(dato);
	}

	public T pop() {
		return this.popFront();
	}

	public T peek() {
		return this.searchAt(1);
	}
	public static void main(String[] args) {
		Calendar tIni = new GregorianCalendar() ;
		PilaHL<Integer> n1=new PilaHL<Integer>();
		System.out.println("INICIO\n\nLa pila esta vacia?: "+n1.isEmpty());
		System.out.println("\n\nApilando datos...\nFinalizado.");
		n1.push(4);
		n1.push(9);
		n1.push(6);
		n1.push(1);
		n1.push(5);
		n1.push(7);
		n1.push(3);
		n1.push(8);
		n1.push(8);
		n1.push(6);
		n1.push(5);
		n1.push(7);
		n1.push(3);
		System.out.println("\nLa pila esta vacia?: "+n1.isEmpty());
		System.out.println("\nDesapilar primer elemento: "+n1.pop());
		System.out.println("\nMostrar primer elemento de la pila: "+n1.peek());
		System.out.println("\nLa pila esta vacia?: "+n1.isEmpty());
		n1.empty();
		System.out.println("\nLa pila esta vacia?: "+n1.isEmpty());
		Calendar tFin = new GregorianCalendar() ;
		long diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("\n\nRendimiento de algoritmo: ");
		System.out.println(diff);
	}
	
}
