package PilaColaLista;
import java.util.GregorianCalendar;

	import java.util.Calendar;
public class ColaDinamica<T> implements Cola<T> {
	
	
	private class Nodo<T>{
		public T datos;
		public Nodo<T> siguiente;
		
	}
	private Nodo<T> primero;
	private Nodo<T> ultimo;
	
	
	public ColaDinamica(){
		this.primero=this.ultimo=null;
	}
	
	public boolean isEmpty() {
		if(primero==null)
			return true;
		else
		return false;
	}

	public void offer(T obj) {
		Nodo<T> nuevoNodo=new Nodo<T>();
		nuevoNodo.datos=obj;
		nuevoNodo.siguiente=null;
		if(primero==null){
			primero=nuevoNodo;
			ultimo=nuevoNodo;
		}else{
			ultimo.siguiente=nuevoNodo;
			ultimo=nuevoNodo;
		}
		
	}

	public T poll() {
		
		if (primero!=null){
		T datos=(T) primero.datos;
			if (primero==ultimo){
				primero=ultimo=null;
			}else{
				primero=primero.siguiente;
			}return datos;
		}
		return null;
	}

	public T peek() {
		if(primero!=null)
			return (T) primero.datos;
		else
		return null;
	}

	public void empty() {
		
		primero=null;
	}

	public static void main(String[] args) {
		Calendar tIni = new GregorianCalendar() ;
		ColaDinamica<Integer> n1=new ColaDinamica<Integer>();
		System.out.println("INICIO\n\nApilando datos...\nFinalizado.");
		for(int i=0;i<1000000;i++)
			n1.offer(i);
		System.out.println("\nLa cola esta vacia?: "+n1.isEmpty());
		System.out.println("Primer elemento de la cola eliminado: "+n1.poll());
		System.out.println("Mostrar primer elemento de la cola: "+n1.peek());
		n1.empty();
		System.out.println("\nLa cola esta vacia?: "+n1.isEmpty());
		
		Calendar tFin = new GregorianCalendar() ;
		long diff = tFin.getTimeInMillis()-tIni.getTimeInMillis();
		System.out.println("\n\nRendimiento de algoritmo: ");
		System.out.println(diff);
	}
	
}

