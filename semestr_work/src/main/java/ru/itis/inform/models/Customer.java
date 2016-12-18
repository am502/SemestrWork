package ru.itis.inform.models;

/**
 * Created by artur on 08.11.16.
 */
public class Customer {
    private int customerId;
    private User user;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.user = builder.user;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class Builder {
        private int customerId;
        private User user;
        private String phoneNumber;

        public Builder customerId(int arg) {
            this.customerId = arg;
            return this;
        }

        public Builder user(User arg) {
            this.user = arg;
            return this;
        }

        public Builder phoneNumber(String arg) {
            this.phoneNumber = arg;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
