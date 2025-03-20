package com.learn.service;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.learn.model.Customer;
import com.learn.model.LoanApplication;



public class LoanApprovalServiceTest {

    private LoanApprovalService loanApprovalService;

    @BeforeEach
    public void setUp() {
        loanApprovalService = new LoanApprovalService();
    }

    @Test
    public void testApproveLoanApplication_ValidApplication_ShouldReturnTrue() {
        //create LoanApplication object using builder pattern
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(1)
                .loanAmount(10000)
                .loanType("Personal")
                .tenure(12)
                .rateOfInterest(10)
                .creditScore(750)
                .build();
        //Customer object using builder pattern and pass the loan application object as a field
        Customer customer = new Customer.Builder()
                .customerId(1)
                .customerName("John")
                .age(30)
                .customerPhone("1234567890")
                .customerEmail("john@gmail.com")
                .loanApplication(loanApplication)
                .build();
       boolean result = loanApprovalService.approveLoanApplication(customer);
        assertTrue(result);
    }
    @Test
    public void testApproveLoanApplication_InvalidCreditScore_ShouldReturnFalse() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(2)
                .loanAmount(50000)
                .loanType("Home")
                .tenure(15)
                .rateOfInterest(8)
                .creditScore(650)
                .build();
        Customer customer = new Customer.Builder()
                .customerId(2)
                .customerName("Jane")
                .age(40)
                .customerPhone("0987654321")
                .customerEmail("jane@gmail.com")
                .loanApplication(loanApplication)
                .build();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }

    @Test
    public void testApproveLoanApplication_InvalidLoanAmount_ShouldReturnFalse() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(3)
                .loanAmount(1500000)
                .loanType("Business")
                .tenure(10)
                .rateOfInterest(12)
                .creditScore(720)
                .build();
        Customer customer = new Customer.Builder()
                .customerId(3)
                .customerName("Alice")
                .age(35)
                .customerPhone("1122334455")
                .customerEmail("alice@gmail.com")
                .loanApplication(loanApplication)
                .build();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }

    @Test
    public void testApproveLoanApplication_InvalidTenure_ShouldReturnFalse() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(4)
                .loanAmount(80000)
                .loanType("Car")
                .tenure(25)
                .rateOfInterest(9)
                .creditScore(710)
                .build();
        Customer customer = new Customer.Builder()
                .customerId(4)
                .customerName("Bob")
                .age(45)
                .customerPhone("2233445566")
                .customerEmail("bob@gmail.com")
                .loanApplication(loanApplication)
                .build();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }

    @Test
    public void testApproveLoanApplication_InvalidAge_ShouldReturnFalse() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(5)
                .loanAmount(90000)
                .loanType("Education")
                .tenure(5)
                .rateOfInterest(7)
                .creditScore(730)
                .build();
        Customer customer = new Customer.Builder()
                .customerId(5)
                .customerName("Charlie")
                .age(85)
                .customerPhone("3344556677")
                .customerEmail("charlie@gmail.com")
                .loanApplication(loanApplication)
                .build();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }


    @Test
    public void testApproveLoanApplication_BoundaryCreditScore_ShouldReturnFalse() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(6)
                .loanAmount(20000)
                .loanType("Personal")
                .tenure(10)
                .rateOfInterest(9)
                .creditScore(700) // Assuming 700 is the boundary for approval
                .build();
        Customer customer = new Customer.Builder()
                .customerId(6)
                .customerName("David")
                .age(28)
                .customerPhone("4455667788")
                .customerEmail("david@gmail.com")
                .loanApplication(loanApplication)
                .build();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }

    @Test
    public void testApproveLoanApplication_BoundaryLoanAmount_ShouldReturnFalse() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(7)
                .loanAmount(1000000) // Assuming 1000000 is the maximum loan amount for approval
                .loanType("Business")
                .tenure(20)
                .rateOfInterest(11)
                .creditScore(750)
                .build();
        Customer customer = new Customer.Builder()
                .customerId(7)
                .customerName("Eve")
                .age(32)
                .customerPhone("5566778899")
                .customerEmail("eve@gmail.com")
                .loanApplication(loanApplication)
                .build();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }

    @Test
    public void testApproveLoanApplication_BoundaryTenure_ShouldReturnFalse() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(8)
                .loanAmount(50000)
                .loanType("Car")
                .tenure(20) // Assuming 20 years is the maximum tenure for approval
                .rateOfInterest(8)
                .creditScore(720)
                .build();
        Customer customer = new Customer.Builder()
                .customerId(8)
                .customerName("Frank")
                .age(38)
                .customerPhone("6677889900")
                .customerEmail("frank@gmail.com")
                .loanApplication(loanApplication)
                .build();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }

    @Test
    public void testApproveLoanApplication_BoundaryAge_ShouldReturnFalse() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(9)
                .loanAmount(30000)
                .loanType("Education")
                .tenure(5)
                .rateOfInterest(6)
                .creditScore(710)
                .build();
        Customer customer = new Customer.Builder()
                .customerId(9)
                .customerName("Grace")
                .age(18) // Assuming 18 is the minimum age for approval
                .customerPhone("7788990011")
                .customerEmail("grace@gmail.com")
                .loanApplication(loanApplication)
                .build();
        boolean result = loanApprovalService.approveLoanApplication(customer);
        assertFalse(result);
    }
}