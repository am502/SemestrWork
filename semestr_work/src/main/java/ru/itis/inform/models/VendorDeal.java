package ru.itis.inform.models;

/**
 * Created by artur on 08.11.16.
 */
public class VendorDeal {
    private int vendorDealId;
    private Vendor vendor;
    private String goodName;
    private int lotSizeWholesale;
    private int price;
    private String conditionsSale;
    private String paymentMethod;
    private String phoneNumber;
    private String note;

    public VendorDeal() {
    }

    public VendorDeal(Builder builder) {
        this.vendorDealId = builder.vendorDealId;
        this.vendor = builder.vendor;
        this.goodName = builder.goodName;
        this.lotSizeWholesale = builder.lotSizeWholesale;
        this.price = builder.price;
        this.conditionsSale = builder.conditionsSale;
        this.paymentMethod = builder.paymentMethod;
        this.phoneNumber = builder.phoneNumber;
        this.note = builder.note;
    }

    public static class Builder {
        private int vendorDealId;
        private Vendor vendor;
        private String goodName;
        private int lotSizeWholesale;
        private int price;
        private String conditionsSale;
        private String paymentMethod;
        private String phoneNumber;
        private String note;

        public Builder vendorDealId(int arg) {
            this.vendorDealId = arg;
            return this;
        }

        public Builder vendor(Vendor arg) {
            this.vendor = arg;
            return this;
        }

        public Builder goodName(String arg) {
            this.goodName = arg;
            return this;
        }

        public Builder lotSizeWholesale(int arg) {
            this.lotSizeWholesale = arg;
            return this;
        }

        public Builder price(int arg) {
            this.price = arg;
            return this;
        }

        public Builder conditionsSale(String arg) {
            this.conditionsSale = arg;
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

        public VendorDeal build() {
            return new VendorDeal(this);
        }
    }

    public int getVendorDealId() {
        return vendorDealId;
    }

    public void setVendorDealId(int vendorDealId) {
        this.vendorDealId = vendorDealId;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getLotSizeWholesale() {
        return lotSizeWholesale;
    }

    public void setLotSizeWholesale(int lotSizeWholesale) {
        this.lotSizeWholesale = lotSizeWholesale;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getConditionsSale() {
        return conditionsSale;
    }

    public void setConditionsSale(String conditionsSale) {
        this.conditionsSale = conditionsSale;
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
