package PilaColaLista;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ColaCL<T> implements Cola<T> {
	private Lista <Integer> lista1;

	public ColaCL(){
		lista1= new Lista<Integer>();
	}
	public boolean isEmpty() {
		
		return lista1.isEmpty();
	}

	public void offer(T dato) {
		
		lista1.pushBack((Integer) dato);
	}

	public T poll() {
		
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
		ColaCL<Integer> n1=new ColaCL<Integer>();
		System.out.println("INICIO\n\nApilando datos...\nFinalizado.");
		n1.offer(2);
		n1.offer(3);
		n1.offer(5);
		n1.offer(4);
		n1.offer(9);
		n1.offer(7);
		n1.offer(5);
		n1.offer(7);
		System.out.println("\nLa cola esta vacia?: "+n1.isEmpty());
		System.out.println("\nPrimer elemento borrado: "+n1.poll());
		System.out.println("\nMostrar primer elemento: "+n1.peek());
		n1.empty();
		System.out.println("\nLa cola esta vacia?: "+n1.isEmpty());
		Calendar tFin = new GregorianCalendar() ;
		long diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("\n\nRendimiento de algoritmo: ");
		System.out.println(diff);
	}


}
