package com.learn.model;

/*
 * class with CustomerId,customerName, age,customerPhone,   
 * customerEmail, LoanApplication as fields
 * create a Builder class for this class as a static inner class
 * with the same fields and a build method that returns an object of Customer
 * Add builder as a constructor in Customer class
 */

public class Customer {
    
    private int customerId;
    private String customerName;
    private int age;
    private String customerPhone;
    private String customerEmail;
    private LoanApplication loanApplication;

    public Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
        this.age = builder.age;
        this.customerPhone = builder.customerPhone;
        this.customerEmail = builder.customerEmail;
        this.loanApplication = builder.loanApplication;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class Builder {
        private int customerId;
        private String customerName;
        private int age;
        private String customerPhone;
        private String customerEmail;
        private LoanApplication loanApplication;

        public Builder customerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder customerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder loanApplication(LoanApplication loanApplication) {
            this.loanApplication = loanApplication;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", age=" + age
                + ", customerPhone=" + customerPhone + ", customerEmail=" + customerEmail + ", loanApplication="
                + loanApplication + "]";
    }

}

