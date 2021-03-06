package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		
		int size = 0;
		SingleLinkedListNode<T> auxiliar = this.head;
		while (!auxiliar.isNIL()) {
			size++;
			auxiliar = auxiliar.getNext();
		}
		return size;		
	}

	@Override
	public T search(T element) {
		
		SingleLinkedListNode<T> auxiliar = this.head;
		while (!(auxiliar.isNIL() || auxiliar.getData().equals(element))) {
			auxiliar = auxiliar.getNext();
		}
		return auxiliar.getData();		
	}

	@Override
	public void insert(T element) {
		
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, 
											new SingleLinkedListNode<>());
		if (this.isEmpty()) {
			this.head = newNode; 
		} else {
			SingleLinkedListNode<T> auxiliar = this.head;
			
			while (!auxiliar.getNext().isNIL()) {
				auxiliar = auxiliar.getNext();
			}
			auxiliar.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		
		if (!this.isEmpty()) {
			if (this.head.getData().equals(element)) {
				this.head = this.head.getNext(); 
			} else {
				SingleLinkedListNode<T> auxiliar = head;
				
				while (!auxiliar.getNext().getData().equals(element)) {
					auxiliar = auxiliar.getNext();
				}
				auxiliar.next = auxiliar.getNext().getNext();
			}	
		}
	}

	@Override
	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.size()];
		int i = 0;
		SingleLinkedListNode<T> auxiliar = this.head;
		while (!auxiliar.isNIL()) {
			array[i] = auxiliar.getData();
			i++;
			auxiliar = auxiliar.getNext();
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
