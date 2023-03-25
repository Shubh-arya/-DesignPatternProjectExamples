package data_strucuture_and_algorithms.stack;

public interface StackInterface<T> {

	void push(T element) throws StackOverflowException;

	void pop() throws StackUnderflowException;

	T top() throws StackUnderflowException;

	boolean isEmpty();

	boolean isFull();
}
