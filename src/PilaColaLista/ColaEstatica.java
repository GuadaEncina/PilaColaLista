package PilaColaLista;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ColaEstatica<T> implements Cola<T> {
	private int size=1000000;
	private int primero;
	private int ultimo;
	private T[] elementos;
	
	@SuppressWarnings("unchecked")
	public ColaEstatica(){
		
		this.primero=this.ultimo=-1;
		this.setElementos((T[]) new Object [size+1]);
		
	}
	
	public boolean isEmpty() {
		if(primero==-1 && ultimo==-1)
		return true;
		else
		return false;
	}
	/*private void resize() {
		T[] aux=(T[])new Object [elementos.length*2];
		for(int i=0;i<elementos.length;i++){
			aux[i]=elementos[i];
		}
		elementos=aux;			
	}*/
	public void offer(T dato) {
		if((ultimo==size-1 && primero==0) || (ultimo+1==primero)) {
			//resize();
			return;
		}
		if(ultimo==size-1 && primero!=0) {
			ultimo=0;
		}
		else {
			ultimo++;
			elementos[ultimo]=dato;
		}
		if(primero==-1){
			primero++;
		}		
	}

	public T poll() {
		T i=null;
		if(!isEmpty())
			i=elementos[primero];
		
		if(primero==ultimo) {
			primero=-1;
			ultimo=-1;
			
		}
		if(primero==size){
			primero=0;
		}
		else {
			primero++;
		}
		return i;
	}

	public T peek() {
		if(isEmpty()){
			return null;
		}
		
		return elementos[primero];
	}

	public void empty() {
		primero=ultimo=-1;
		
	}
	
	public T[] getElementos() {
		return elementos;
	}

	public void setElementos(T[] elementos) {
		this.elementos = elementos;
	}

	

	public static void main(String[] args) {
		Calendar tIni = new GregorianCalendar();
		ColaEstatica<Integer> n1= new ColaEstatica<Integer>();
		System.out.println("INICIO\n\nMostrar primer elemento de la cola: "+n1.peek());
		System.out.println("\n\nApilando datos...\nFinalizado.");
		for(int i=0;i<1000000;i++)
			n1.offer(i);
		System.out.println("\nLa cola esta vacia?: "+n1.isEmpty());
		System.out.println("\nPrimer elemento de la cola eliminado: "+n1.poll());
		System.out.println("\nMostrar primer elemento de la cola: "+n1.peek());
		n1.empty();
		System.out.println("\nLa cola esta vacia?: "+n1.isEmpty());
		System.out.println("\nPrimer elemento de la cola eliminado: "+n1.poll());
		Calendar tFin = new GregorianCalendar() ;
		long diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("\n\nRendimiento de algoritmo: ");
		System.out.println(diff);
	}

	
}
