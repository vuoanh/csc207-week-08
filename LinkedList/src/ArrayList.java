

public class ArrayList<T> implements List<T>{
	private int size;
	private T[] arr;
	
	@Override
	public void add(T value) {
		if (size + 1 > arr.length){
			T[] tmpArr = (T[]) new Object[arr.length * 2];
			for (int i = 0; i < this.arr.length; i++){
				arr[i] = tmpArr[i];
			}
			this.arr = tmpArr;
		}
		arr[size++] = value;
	}

	@Override
	public void remove(T value) {
		for (int i = 0; i < size; i++){
			if (this.arr[i]).compareTo(value) == 0){
				

			}
		}


	}

	@Override
	public void remove (int index) {
        if (index == size) {
            size--;
            return;
        }
        for (int i=index+1; i<size; i++) {
            arr[i] = arr[i+1];
        }
    }

	@Override
	public void clear() {
		size = 0;

	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(T value, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0){
			return true;
		} else {return false;}
	}

	@Override
	public long size() {
		return size;
	}

	@Override
	public T Iterator() {
		// TODO Auto-generated method stub
		return null;
	}


}
