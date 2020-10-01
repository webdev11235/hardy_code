package com.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class demo {
	public static void main(String[] args) {
		ArrayList<String> myStrList = new ArrayList<String>();
		myStrList.add("my");
		myStrList.add("name");
		myStrList.add("is");
		myStrList.add("William");
		HashSet<Integer> myIntSet = new HashSet<Integer>();
		myIntSet.add(1);
		myIntSet.add(2);
		myIntSet.add(3);
		myIntSet.add(4);
		LinkedList<Boolean> boolList = new LinkedList<Boolean>();
		boolList.add(true);
		boolList.add(true);
		boolList.add(false);
		boolList.add(false);
		GenericTest.printCollection(myStrList);
		GenericTest.printCollection(myIntSet);
		GenericTest.printCollection(boolList);

		
	}

}
