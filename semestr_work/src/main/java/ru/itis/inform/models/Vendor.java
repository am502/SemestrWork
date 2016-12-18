package ru.itis.inform.models;

/**
 * Created by artur on 08.11.16.
 */
public class Vendor {
    private int vendorId;
    private User user;
    private String phoneNumber;

    public Vendor() {
    }

    public Vendor(Builder builder) {
        this.vendorId = builder.vendorId;
        this.user = builder.user;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class Builder {
        private int vendorId;
        private User user;
        private String phoneNumber;

        public Builder vendorId(int arg) {
            this.vendorId = arg;
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

        public Vendor build() {
            return new Vendor(this);
        }
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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
