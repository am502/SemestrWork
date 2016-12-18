package ru.itis.inform.models;

/**
 * Created by artur on 08.11.16.
 */
public class CustomerDeal {
    private int customerDealId;
    private Customer customer;
    private String goodName;
    private int lotSize;
    private int price;
    private String paymentMethod;
    private String phoneNumber;
    private String note;

    public CustomerDeal() {
    }

    public CustomerDeal(Builder builder) {
        this.customerDealId = builder.customerDealId;
        this.customer = builder.customer;
        this.goodName = builder.goodName;
        this.lotSize = builder.lotSize;
        this.price = builder.price;
        this.paymentMethod = builder.paymentMethod;
        this.phoneNumber = builder.phoneNumber;
        this.note = builder.note;
    }

    public static class Builder {
        private int customerDealId;
        private Customer customer;
        private String goodName;
        private int lotSize;
        private int price;
        private String paymentMethod;
        private String phoneNumber;
        private String note;

        public Builder customerDealId(int arg) {
            this.customerDealId = arg;
            return this;
        }

        public Builder customer(Customer arg) {
            this.customer = arg;
            return this;
        }

        public Builder goodName(String arg) {
            this.goodName = arg;
            return this;
        }

        public Builder lotSize(int arg) {
            this.lotSize = arg;
            return this;
        }

        public Builder price(int arg) {
            this.price = arg;
            return this;
        }

        public Builder paymentMethod(String arg) {
            this.paymentMethod = arg;
            return this;
        }

        public Builder phoneNumber(String arg) {
            this.phoneNumber = arg;
            return this;
        }

        public Builder note(String arg) {
            this.note = arg;
            return this;
        }

        public CustomerDeal build() {
            return new CustomerDeal(this);
        }
    }

    public int getCustomerDealId() {
        return customerDealId;
    }

    public void setCustomerDealId(int customerDealId) {
        this.customerDealId = customerDealId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
