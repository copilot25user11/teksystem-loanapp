package com.learn;

import com.learn.model.Customer;
import com.learn.model.LoanApplication;
import com.learn.service.LoanApprovalService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // create a loan application object using builder pattern
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(1)
                .loanAmount(10000)
                .loanType("Personal")
                .tenure(12)
                .rateOfInterest(10)
                .creditScore(700)
                .build();
        System.out.println(loanApplication);

        // create a customer object using builder pattern and 
        //pass the loan application object as a field
        Customer customer = new Customer.Builder()
                .customerId(1)
                .customerName("John")
                .age(30)
                .customerPhone("1234567890")
                .customerEmail("admin@gmail.com")
                .loanApplication(loanApplication)
                .build();
        System.out.println(customer);

        //create a loan approval service object
        //and call the approveLoanApplication method
        //passing the customer object
        //print the result
        LoanApprovalService loanApprovalService = new LoanApprovalService();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        System.out.println("Loan Application Approved: " + result);

     
        
    }
}
