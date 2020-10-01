package datastructures;

public class myArrayList<T> {
	GenericArray arr;
	int length;
	int numOfElmts = 0;
	
	public myArrayList(int length) {
		super();
		this.length = length;
		this.arr = new GenericArray(length);
	}

	public void add(T t) {
		if (arr.arr[arr.arr.length - 1] != null) {
			
			GenericArray newArr = new GenericArray(2 * length);
			for (int i = 0; i < arr.arr.length; i++) {
				newArr.arr[i] = arr.arr[i];
			}
			newArr.arr[arr.arr.length] = (Object) t;
			this.arr = newArr;
			length = arr.arr.length;
			numOfElmts++;
		}
		else {
			arr.arr[numOfElmts] = (Object) t;
			numOfElmts++;
		}
	}

	public T get(int i) {
		return (T) arr.arr[i];
	}

	public int size() {
		return length;
	}

	/*
	 * Split should take arr and split into a number of subarrays.
	 * The number is given by numberOfNewArrays.
	 * 
	 * eg if [1, 5, 6, 5, 7] and input 3
	 * so the output would be: 
	 * [
	 *   [1, 5],
	 *   [6, 5],
	 *   [7, null]
	 * ]
	 */
	/*public T[][] split(int numberOfNewArrays) {
		if (numberOfNewArrays <= numOfElmts) {
	
		}
			
	}*/

}
