package week1.practice2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

	public class Driver1 {
		
		public static void main(String[] args) {
			
			System.out.println("Welcome to the Calculator!");
			System.out.println("Enter your command below:");
			Scanner scan = new Scanner(System.in);
			
			while (true) {	
				System.out.println("Press enter to exit");
				String s = scan.nextLine();
				if (s.length() == 0) {
					scan.close();
					break;
				}
				else {
					try {
						calculate(s);
					}
					catch (Exception e) {
						System.out.println("Invalid input");
					}
					
				}		
			}
		}
		
		public static void calculate(String s) {
			Calculator myCalc = new myCalc();
			System.out.println("The answer is: " + myCalc.parse(s));
		}
	}