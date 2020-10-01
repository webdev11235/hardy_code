package week1.practice1;

public class Practice1 {
	public static void main(String[] args) {
		fizzBuzz(27);
	}
	
	/*public static void fizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("fizzbuzz");
			}
			else if (i % 3 == 0) {
				System.out.println("fizz");
			}
			else if (i % 5 == 0) {
				System.out.println("buzz");
			}
			else {
				System.out.println(i);
			}
			
		}
	}*/
	
	public static void fizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			String fizzbuzz = "";
			if (i % 3 == 0) {
				fizzbuzz += "fizz";
			}
			if (i % 5 == 0) {
				fizzbuzz += "buzz";
			}
			if (fizzbuzz.length() == 0) {
				System.out.println(i);
			}
			else {
				System.out.println(fizzbuzz);
			}
		}
	}
}
