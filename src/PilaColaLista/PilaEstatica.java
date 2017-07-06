package PilaColaLista;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PilaEstatica<T> implements Pila<T>{
	private T []unVector=null;
	private int cima;
	static final int TAM_POR_DEFECTO=1;

	@SuppressWarnings("unchecked")
	public PilaEstatica(){
		this.cima=-1;
		this.unVector=(T[]) new Object[TAM_POR_DEFECTO];
	}
	
	public void push(T obj) {
		if (cima==unVector.length-1){
			resize();
		}
		unVector[++cima]=obj;
		
	}
	private void resize(){
	
		@SuppressWarnings("unchecked")
		T[] aux= (T[]) new Object[unVector.length*2];
		for(int i=0;i<unVector.length;i++){
			aux[i]=unVector[i];
		}
		unVector=aux;
	}
	public boolean isEmpty() {
		if(cima==-1)
			return true;
		else
			return false;
	}

	
	public T pop() {
		if (cima>-1)
			return unVector[cima--];
		else
			return null;
	}

	
	public T peek() {
		if(cima>-1)
			return unVector[cima];
		else
		    return null;
	}

	
	public void empty() {
		cima=-1;
		
	}
	public int getcima() {
		return cima;
	}
	public void setcima(int cima) {
		this.cima = cima;
	}
	public T[] getUnVector() {
		return unVector;
	}
	public void setUnVector(T[] unVector) {
		this.unVector = unVector;
	}

	public static void main(String[] args) {
		Calendar tIni = new GregorianCalendar() ;
		PilaEstatica<Integer> n1=new PilaEstatica<Integer>();
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