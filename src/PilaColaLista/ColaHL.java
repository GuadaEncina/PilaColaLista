package PilaColaLista;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ColaHL<T> extends Lista<T> implements Cola<T>{

	public void offer(T dato) {
		this.pushBack(dato);
		
	}

	public T poll() {
		
		return this.popFront();
	}

	public T peek() {
		
		return this.searchAt(1);
	}
	public static void main(String[] args) {
		Calendar tIni = new GregorianCalendar() ;
		ColaHL<Integer> n1=new ColaHL<Integer>();
		n1.offer(2);
		n1.offer(3);
		n1.offer(5);
		n1.offer(4);
		n1.offer(9);
		n1.offer(7);
		n1.offer(5);
		n1.offer(7);
		System.out.println(n1.isEmpty());
		System.out.println("Primer elemento borrado: "+n1.poll());
		System.out.println("Mostrar primer elemento: "+n1.peek());
		n1.empty();
		System.out.println(n1.isEmpty());
		Calendar tFin = new GregorianCalendar() ;
		long diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("\n\nRendimiento de algoritmo: ");
		System.out.println(diff);
	}

}
