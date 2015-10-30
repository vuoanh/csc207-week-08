
public class LinkedList  <T> implements List <T>{
	private Node<T> first;
	
	// Hide the Node class
	private class Node<T>{
		public T value;
		public Node next;
		// Constructor
		public Node(T value, Node<T> next){
			this.value = value;
			this.next = next;
		}
		public Node(T value){
			this(value, null);
		}
	}
	
	// call constructor, first node is null
	public LinkedList(){
		first = null;
	}
	
	
	@Override
	public void add(T value) {
		Node<T> newNode = new Node<T>(value, first);
		if (first == null){
			first = newNode;
		}
		else {
			Node<T> iter = first;
			// walk iter to the end of the list
			while(iter.next != null){
				iter = iter.next;
			}
			iter.next = newNode;
		}
	}

	@Override
	public void remove(T value) {
		// TODO
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// Free the pointer
		first = null; // garbage collector will take care the rest
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(T variable, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int indexOf(T variable) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T variable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long size() {
		int ret = 0;
		Node<T> iter = first;
		while (iter != null){
			iter = iter.next;
			ret++;
		}
		return ret;
	}
	
}
