package Students;

import java.io.Serializable;

public class Mark implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numericValue;
	private String alphabetValue;
	private int firstAttestation;
	private int secondAttestation;
	private int finalAttestation;
	
	public Mark() {
		firstAttestation = 0;
		secondAttestation = 0;
		finalAttestation = 0;
	}
	
	public double getOverall() {
		return firstAttestation + secondAttestation + finalAttestation;
	}

	public int getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(int numericValue) {
		this.numericValue = numericValue;
	}

	public String getAlphabetValue() {
		return alphabetValue;
	}
	
	public void calculateAlphabetValue() {
		setAlphabetValue("A-");
	}
	
	public void setAlphabetValue(String alphabetValue) {
		this.alphabetValue = alphabetValue;
	}

	public int getFirstAttestation() {
		return firstAttestation;
	}

	public void setFirstAttestation(int firstAttestation) {
		this.firstAttestation = firstAttestation;
	}

	public int getSecondAttestation() {
		return secondAttestation;
	}

	public void setSecondAttestation(int secondAttestation) {
		this.secondAttestation = secondAttestation;
	}

	public int getFinalAttestation() {
		return finalAttestation;
	}

	public void setFinalAttestation(int finalAttestation) {
		this.finalAttestation = finalAttestation;
	}
	
}
