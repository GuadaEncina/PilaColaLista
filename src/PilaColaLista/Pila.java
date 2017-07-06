package PilaColaLista;

public interface Pila<T> {
	public boolean isEmpty();
	public void push (T dato);
	public T pop();
	public T peek();
	public void empty();
}
