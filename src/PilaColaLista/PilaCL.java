package PilaColaLista;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PilaCL <T> implements Pila<T>{

	private Lista <Integer> lista1= new Lista<Integer>();

	public boolean isEmpty() {
		
		return lista1.isEmpty();
	}

	public void push(T dato) {
		
		lista1.pushFront((Integer) dato);
	}

	public T pop() {
		
		return (T) lista1.popFront();
	}

	public T peek() {
		
		return (T) lista1.searchAt(1);
	}

	public void empty() {
		lista1.empty();
		
	}
	
	
	public static void main(String[] args) {
		Calendar tIni = new GregorianCalendar() ;
		PilaCL<Integer> n1=new PilaCL<Integer>();
		System.out.println("INICIO\n\nApilando datos...\nFinalizado.");
		n1.push(1);
		n1.push(9);
		n1.push(6);
		n1.push(1);
		n1.push(5);
		n1.push(7);
		n1.push(3);
		n1.push(8);
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
