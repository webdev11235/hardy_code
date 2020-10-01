package week1.practice2;

public class myCalc implements Calculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
		// TODO Auto-generated method stub
		return a / b;
	}

	@Override
	public int exponent(int x, int e) {
		if (e == 0) {
			return 1;
		}
		else {
			return (x * exponent(x, --e));
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public int fibonacci(int i) {
		if (i == 0 || i == 1) {
			return i;
		}
		else {
			return fibonacci(i - 1) + fibonacci(i - 2);
		}
		// TODO Auto-generated method stub
	}

	@Override
	public int parse (String s) {
		String[] operands = s.split(" ");
		int b = Integer.parseInt(operands[operands.length - 1]);
		int result;
		if (s.contains("fib")) {
			return fibonacci(b);
		}
		
		
		
		
		else {
			int a = Integer.parseInt(operands[0]);
			switch(operands[1]) {
			case "+":
				return add(a, b);
			case "-":
				return subtract(a, b);
			case "*":
				return multiply(a, b);
			case "/":
				return divide(a, b);
			case "^":
				return exponent(a, b);
			default:
				System.out.println("Error: input not recognized");
				return 0;
			}
		}
		
		
		
		
	}

}
