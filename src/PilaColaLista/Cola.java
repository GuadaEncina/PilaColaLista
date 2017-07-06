package PilaColaLista;

public interface Cola <T>{
	public boolean isEmpty();
	public void offer(T dato);
	public T poll();
	public T peek();
	public void empty();
	
}
