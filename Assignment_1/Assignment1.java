import java.util.*;

class Assignment1 {
	// Task 1
	public static int Minimum(int n, int[] arr) {
		if (n == 1) return arr[0];
		int min = Minimum(n - 1, arr);
		return (min > arr[n-1]) ? arr[n-1] : min;
	}

	// Task 2
	public static float Average(int n, int[] arr) {
		return (float)Sum(n, arr) / n;
	}

	private static int Sum(int n, int[] arr) {
		if (n <= 0) return 0;
		int sum = arr[n - 1] + Sum(n - 1, arr);
		return sum;

	}

	// Task 3
	public static boolean Prime(int n) {
		if (n <= 1) return false;
		return Prime(n, 2);
	}

	private static boolean Prime(int n, int d) {
		if (n % d == 0) return false; 
		if (d * d > n) {
			return true;
		}
		return Prime(n, d + 1);

	}

	// Task 4
	public static int Factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else if (n < 0 || n > 20) {
			return 0;
		}
		return n * Factorial(n - 1);
	}

	// Problem 5
	public static int Fibonacci(int n) {
		switch(n) {
			case 0:
				return 0;
			case 1:
				return 1;
			default:
				return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}

	// Problem 6
	public static int Power(int n, int a) {
		if (a < 0) {
			return 0;
		} else if (a == 0) {
			return 1;
		} else if (a == 1) {
			return n;
		}
		return n * Power(n, a - 1); 
	}

	// Problem 7
	public static List<String> Permutation(String s) {
		List<String> res = new ArrayList<>();
		if (s.isEmpty()) return res;
		if (s.length() == 1) {
			res.add(s);
			return res;
		}

		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(0, i) + s.substring(i + 1);
			List<String> sub = Permutation(str);
			for (String string : sub) {
				res.add(s.charAt(i) + string);
			}
		}
		return res;
	}

	// Problem 8
	private static boolean isNumerical(String s, int index) {
	if (index == s.length()) {
		return true;
	}
	if (s.charAt(index) >= 48 && s.charAt(index) <= 57) {
		s.charAt(index);
		return isNumerical(s, index + 1);
	} else {
		return false;
	}
	}

	public static boolean isNumerical(String s) {
		return isNumerical(s, 0);
	}

	// Problem 9
	public static int Binomial(int n, int k) {
		if (k > n) return 0;
		if ((k == 0) || (k == n)) return 1;
		return Binomial(n - 1, k - 1) + Binomial(n - 1, k);
	}

	public static int BinomialEasy(int n, int k) {
		return (Factorial(n))/(Factorial(k)*Factorial(n-k));
	}

	// Problem 10
	public static int GCD(int a, int b) {
		if (b == 0) return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) {
		// Problem 1
		System.out.println("Problem 1:");
		System.out.println(Minimum(5, new int[]{10, 1, 32, 3, 45}));
		System.out.println();

		// Problem 2
		System.out.println("Problem 2:");
		System.out.println(Average(4, new int[]{3, 2, 4, 1}));
		System.out.println();

		// Problem 3
		System.out.println("Problem 3:");
		if (Prime(7)) {
			System.out.println("Prime");
		} else {
			System.out.println("Composite");
		}

		if (Prime(10)) {
			System.out.println("Prime");
		} else {
			System.out.println("Composite");
		}

		System.out.println();

		// Problem 4
		System.out.println("Problem 4:");
		System.out.println(Factorial(5));
		System.out.println();

		// Problem 5
		System.out.println("Problem 5:");
		System.out.println(Fibonacci(5));
		System.out.println(Fibonacci(17));
		System.out.println();

		// Problem 6
		System.out.println("Problem 6:");
		System.out.println(Power(2, 10));
		System.out.println();

		// Problem 7
		System.out.println("Problem 7:");
		System.out.println(Permutation("IOX"));
		System.out.println();

		// Problem 8
		System.out.println("Problem 8:");
		if (isNumerical("123456")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		if (isNumerical("123a12")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		System.out.println();

		// Problem 9
		System.out.println("Problem 9:");
		System.out.println(Binomial(2, 1));
		System.out.println(Binomial(7, 3));
		System.out.println();

		// Problem 10
		System.out.println("Problem 10:");
		System.out.println(GCD(32, 48));
		System.out.println(GCD(10, 7));
		System.out.println();
	}
}
