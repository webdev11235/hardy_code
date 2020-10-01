package week1.practice2;

public class Driver {
	public static void main(String[] args) {
		Calculator myCalculator = new myCalc();
		int val1 = 4;
		int val2 = 2;
		System.out.println(myCalculator.add(val1, val2));
		System.out.println(myCalculator.divide(val1, val2));
		System.out.println(myCalculator.exponent(val1, 0));
		System.out.println(myCalculator.fibonacci(5));
		System.out.println(myCalculator.multiply(val1, val2));
		System.out.println(myCalculator.parse("2 ^ 5"));
		System.out.println(myCalculator.subtract(val1, val2));
		System.out.println(myCalculator.parse("fib 5"));
	}
}
