package com.learn.model;

/**
 * Represents a loan application with details such as application ID, loan amount, loan type, tenure, rate of interest, and credit score.
 */
public class LoanApplication {

	private int applicationId;
	private double loanAmount;
	private String loanType;
	private int tenure;
	private float rateOfInterest;
	private int creditScore;

	public LoanApplication(Builder builder) {
		this.applicationId = builder.applicationId;
		this.loanAmount = builder.loanAmount;
		this.loanType = builder.loanType;
		this.tenure = builder.tenure;
		this.rateOfInterest = builder.rateOfInterest;
		this.creditScore = builder.creditScore;
	}
	public int getCreditScore() {
		return creditScore;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	/**
	 * Builder class for constructing LoanApplication instances.
	 */
	public static class Builder {
		private int applicationId;
		private double loanAmount;
		private String loanType;
		private int tenure;
		private float rateOfInterest;
		private int creditScore;

		/**
		 * Sets the application ID for the loan application.
		 * @param applicationId the application ID
		 * @return the Builder instance
		 */
		public Builder applicationId(int applicationId) {
			this.applicationId = applicationId;
			return this;
		}

		/**
		 * Sets the loan amount for the loan application.
		 * @param loanAmount the loan amount
		 * @return the Builder instance
		 */
		public Builder loanAmount(double loanAmount) {
			this.loanAmount = loanAmount;
			return this;
		}

		/**
		 * Sets the loan type for the loan application.
		 * @param loanType the loan type
		 * @return the Builder instance
		 */
		public Builder loanType(String loanType) {
			this.loanType = loanType;
			return this;
		}

		/**
		 * Sets the tenure for the loan application.
		 * @param tenure the tenure
		 * @return the Builder instance
		 */
		public Builder tenure(int tenure) {
			this.tenure = tenure;
			return this;
		}

		/**
		 * Sets the rate of interest for the loan application.
		 * @param rateOfInterest the rate of interest
		 * @return the Builder instance
		 */
		public Builder rateOfInterest(float rateOfInterest) {
			this.rateOfInterest = rateOfInterest;
			return this;
		}

		/**
		 * Sets the credit score for the loan application.
		 * @param creditScore the credit score
		 * @return the Builder instance
		 */
		public Builder creditScore(int creditScore) {
			this.creditScore = creditScore;
			return this;
		}

		public LoanApplication build() {
			return new LoanApplication(this);
		}
	}

	@Override
	/**
	 * Returns a string representation of the LoanApplication object.
	 * The string includes the application ID, loan amount, loan type, tenure,
	 * rate of interest, and credit score.
	 *
	 * @return a string representation of the LoanApplication object
	 */
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", loanAmount=" + loanAmount + ", loanType="
				+ loanType + ", tenure=" + tenure + ", rateOfInterest=" + rateOfInterest + ", creditScore=" + creditScore
				+ "]";
	}

	
}