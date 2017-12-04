package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		this.top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}
		T[] array = this.top.toArray();
		T elemento = array[this.top.size()-1];
		this.top.removeLast();
		return elemento;
	}

	@Override
	public T top() {
		
		T elemento;
		if (this.isEmpty()) {
			elemento = null;
		} else {
			T[] array = this.top.toArray();
			elemento = array[this.top.size()-1];
		}
		return elemento;
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == size;
	}
}
