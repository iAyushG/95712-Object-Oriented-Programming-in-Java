package practice11;

public abstract class Series {
	abstract int getNthNumber(int n);
}

class Factorial extends Series {
	
	@Override
	int getNthNumber(int n) {
		int factorial = 1;
		if (n == 0) {
			factorial = 1;
		}
		else if (n > 0) {
			factorial = n * getNthNumber(n-1);
		}
		return factorial;
	}
}

class Fibonacci extends Series {

	@Override
	int getNthNumber(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1 || n == 2) {
			return 1;
		}
		else {
			int a = 1, b = 1, temp;
			for (int i = 3; i <= n; i++) {
				temp = a + b;
				a = b;
				b = temp;
			}
			return b;
		}
	}
}

class Prime extends Series {

	@Override
	int getNthNumber(int n) {
		if (n <= 0) {
            return -1; // Invalid input
        }

        int count = 0;
        int number = 1; // Start from the first number

        while (true) {
            number++;
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
                if (count == n) {
                    return number; // Found the nth prime number
                }
            }
        }
	}
}