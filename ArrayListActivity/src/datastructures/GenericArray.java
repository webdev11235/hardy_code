package datastructures;

public class GenericArray<T> {
	Object[] arr;
	int length;
	

	public GenericArray(int length) {
		arr = new Object[length];
		this.length = length;
		// The cool Kevin way
		//tarr = (T[])(new Object[10]);

		// The painful way
		//arr = new Object[10];

		//arr[0] = (Object)t;
		//T otherT = (T)arr[0];
	}

}
