/*
 * NAME: AYUSH GUPTA
 * Andrew ID: ayushgu2
 * @author: ayush
 */

package lab3;

public class MixedFraction extends Fraction {

	int naturalNumber;
	
	// Non-Default Constructor
	MixedFraction(int naturalNumber, int numerator, int denominator) {
		super(numerator, denominator);
		this.naturalNumber = naturalNumber;
	}
	
	@Override
	public String toString() {
		return naturalNumber + " " + numerator + "/" + denominator;
	}
	
	@Override
	public double toDecimal() {
		return (double) (naturalNumber * denominator + numerator) / denominator;
	}
	
	public Fraction toFraction() {
		int newNumerator = (naturalNumber * denominator) + numerator;
		Fraction newFraction = new Fraction(newNumerator, denominator);
		return newFraction;
	}
	
	public Fraction add(MixedFraction mf) {
		Fraction thisFraction = this.toFraction();
		Fraction mfFraction = mf.toFraction();
		
		Fraction resultFraction = thisFraction.add(mfFraction);
		
		return resultFraction;
	}
}