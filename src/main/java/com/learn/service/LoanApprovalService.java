package com.learn.service;

import com.learn.model.Customer;
import com.learn.model.LoanApplication;

public class LoanApprovalService {

    /*
     * create a method approveLoanApplication that takes a Customer object as a parameter
     * and returns a boolean value
     * The method should return true if the loan application is approved
     * and false if the loan application is rejected
     * The loan application should be approved if the credit score is 
     * greater than 700
 
     * and the loan amount is less than 1000000
     * and the tenure is less than 20
     * and the age is greater than  18 and less than 81
     */
    public boolean approveLoanApplication(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        LoanApplication loanApplication = customer.getLoanApplication();
        if (loanApplication == null) {
            throw new IllegalArgumentException("LoanApplication cannot be null");
        }

        try {
            int creditScore = loanApplication.getCreditScore();
            double loanAmount = loanApplication.getLoanAmount();
            int tenure = loanApplication.getTenure();
            int age = customer.getAge();

            System.out.println("Debug: Credit Score = " + creditScore);
            System.out.println("Debug: Loan Amount = " + loanAmount);
            System.out.println("Debug: Tenure = " + tenure);
            System.out.println("Debug: Age = " + age);

            // Check if the credit score is greater than 700
            boolean isCreditScoreValid = creditScore > 700;
            // Check if the loan amount is less than 1000000
            boolean isLoanAmountValid = loanAmount < 1000000;
            // Check if the tenure is less than 20 years
            boolean isTenureValid = tenure < 20;
            // Check if the age is greater than 18 and less than 81
            boolean isAgeValid = age > 18 && age < 81;

            if (isCreditScoreValid && isLoanAmountValid && isTenureValid && isAgeValid) {
            return true;
            }
        } catch (Exception e) {
            // Log the exception (if logging is set up) and handle it appropriately
            System.err.println("Error while approving loan application: " + e.getMessage());
        }

        return false;
    }

}
