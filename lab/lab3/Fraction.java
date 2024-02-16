/*
 * NAME: AYUSH GUPTA
 * Andrew ID: ayushgu2
 * @author: ayush
 */

package lab3;

public class Fraction {

	int numerator;
	int denominator;
	
	// Default Constructor
	public Fraction() {
		this.numerator = 1;
		this.denominator = 1;
	}
	
	// Non-Default Constructor
	Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	double toDecimal() {
		if (numerator == 0 && denominator == 0) {
			return Double.NaN;
		}
		else if (denominator == 0) {
			return Double.POSITIVE_INFINITY;
		}
		return (double) numerator / denominator;
	}
	
	Fraction add(Fraction fraction) {
		int resultNumerator = (this.numerator * fraction.denominator) + (this.denominator * fraction.numerator);
		int resultDenominator = this.denominator * fraction.denominator;
		
		int gcd = findGCD(resultNumerator, resultDenominator);
		
		if (gcd < 0) {
			gcd = -gcd;
		}
		
		return new Fraction((resultNumerator / gcd), (resultDenominator / gcd));
	}
	
	int findGCD(int n, int d) {
		if (n == 0) {
			return 1;
		}
		
		if (d == 0) {
			return n;
		}
		
		return findGCD(d, (n % d));
	}
}