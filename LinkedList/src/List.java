

public interface List<T>{
	public void add(T value);
	public void remove(T value);
	public void remove(int index);
	public void clear();
	public T get(int index);
	public void set(T value, int index);
	public int indexOf(T value);
	public boolean contains(T value);
	public boolean isEmpty();
	public long size();
	
	
	
}
