package data_strucuture_and_algorithms.stack;

public class ArrayBoundStack<T> implements StackInterface<T> {
	T[] elements;
	final int CAPACITY = 100;
	int topIndex = -1;

	@SuppressWarnings("unchecked")
	public ArrayBoundStack() {
		elements = (T[]) new Object[CAPACITY];
	}

	@SuppressWarnings("unchecked")
	public ArrayBoundStack(int capacity) {
		elements = (T[]) new Object[capacity];
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("Array bound stack is full!!");
		}
		topIndex++;
		elements[topIndex] = element;

	}

	@Override
	public void pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Array stack is empty!! can not pop the element");
		}
		elements[topIndex] = null;
		topIndex--;
	}

	@Override
	public T top() {
		if (isEmpty()) {
			throw new StackUnderflowException("Array stack is empty!! can not pop the element");
		}
		return elements[topIndex];
	}

	@Override
	public boolean isEmpty() {
		return (topIndex == -1);
	}

	@Override
	public boolean isFull() {
		return (topIndex == elements.length - 1);
	}
}
