package lab05;

public class BinarySearchSet {
	/** represent the simple array that holds the list values */
	public double[] storage;
	/** holds the length of the storage array */
	private int capacity;
	/** holds the number of elements in the list */
	private int size;

	/** keep this TRUE for lab **/
	public boolean labFind = false;

	/** default constructor */
	public BinarySearchSet(){
		storage = new double[6];
		capacity = 6;
		size = 0;
	}

	public BinarySearchSet(double[] input){
		storage = new double[6];
		capacity = 6;
		size = 0;
		for(int i = 0; i < input.length; i++) {
			this.insert(input[i]);
		}
	}
	public boolean isEmpty(){
		for(int i = 0; i < storage.length; i++) {
			if(storage[i] != 0) {
				return false;
			}
		}
		return true; //placeholder
	}

	public int size(){
		return size; //placeholder
	}

	public void grow(){
		double growArray[] = new double[capacity*2];
	    System.arraycopy(storage, 0, growArray, 0, capacity);
	    capacity *= 2;
	    storage = growArray;
	}

	public String toString(){
		String mySet = "";
		mySet += "Values in list: ";
		for(int i = 0; i < storage.length; i++) {
			mySet += storage[i] + ", ";
		}
		mySet += "\n";
		mySet += "Size of list: " + size + "\n";
		mySet += "Capacity of list: " + capacity + "\n";
		return mySet;
	}

	public void clear() {
		for(int i = 0; i < capacity; i++) {
			storage[i] = 0.0;
		}
		size = 0;
	}

	public boolean insert(double newVal){
		if(size+1 == capacity) {
			grow();
		}
		int index = findIndex(newVal);
		if(index < 0) {
			index = Math.abs(index)-1;
			double val = newVal;
			for(int i = index; i < storage.length; i++){
				double temp = storage[i];
				storage[i] = val;
				val = temp;
			}
			size++;
			return true;
		}
		return false;
	}

	public boolean remove(double element){
		int index = this.sequentialFind(element);
		if(index > 0) {
			this.size--;
			this.storage[index] = 0.0;
			for(int i = index; i < this.storage.length-1; i++) {
				this.storage[i] = this.storage[i+1];
			}
			return true;
		}
		return false;
	}


	private int sequentialFind(double target) {
		for(int i = 0; i < capacity; i++) {
			if(storage[i] == target) {
				return i;
			}else if(target < storage[i] || storage[i] == 0.0){
				return (-i-1);
			}
		}
		return 0;
	}

	private int binaryFind(double target) {
		int low = 0;
		int high = this.size;
		int mid = 0;
		while(low <= high) {
			mid = (low+high)/2;
			if(this.storage[mid] == target) {
				return mid;
			}else if(target < this.storage[mid]) {
				high = mid -1;
			}else {
				low = mid +1;
			}
		}
		return -mid-1;
	}

	public int findIndex(double target) {
		if (labFind) {
			return sequentialFind(target);
		} else {
			return binaryFind(target);
		}
	}

	public boolean containsAll(double[] elements){
		for(int i = 0; i < elements.length; i++) {
			if(this.binaryFind(elements[i]) < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean contains(double element){
		if(this.binaryFind(element) >= 0) {
			return true;
		}
		return false;
	}

}
