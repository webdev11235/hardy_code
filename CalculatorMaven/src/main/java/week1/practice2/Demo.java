package week1.practice2;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Calculator myCalculator = new myCalc();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Calculator operation");
		String s = scan.nextLine();
		System.out.println("The answer is: " + myCalculator.parse(s));
	}
}
