package data_strucuture_and_algorithms.stack;

public class LinkedStack<T> implements StackInterface<T> {
	
	LLNode<T> top;
	
	public LinkedStack() {
		top = null;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException("stack if already full...pop one element befor pushing.");
		}
		if (top != null) {
			LLNode<T> temp = new LLNode<>(element);
			temp.setLink(top);
			top = temp;
		} else {
			top = new LLNode<T>(element);

		}
	}

	@Override
	public void pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack is empty!!");
		}
		top = top.getLink();
	}

	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack is empty!!");
		}
		return (T) top.getInfo();
	}

	@Override
	public boolean isEmpty() {
		if (top == null) {
			return true;
		}
		return false;

	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

}
