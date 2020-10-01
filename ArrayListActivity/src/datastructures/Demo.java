package datastructures;
import datastructures.myArrayList;

public class Demo {
	public static void main(String[] args) {
		myArrayList<Integer> array = new myArrayList<>(5);
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		//array.add("blah");
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array.get(i));
		}
		array.add(6);
		System.out.println(array.numOfElmts);
		System.out.println(array.length);
		
		myArrayList<String> array1 = new myArrayList<String>(3);
		array1.add("blah");
		array1.add(1);
		array1.add("cap");
		System.out.println(array1.get(2));
		array1.add("dap");
		System.out.println(array1.numOfElmts);
		System.out.println(array1.length);
		
	}
	
	

}
