package ru.itis.inform.models;

/**
 * Created by artur on 08.11.16.
 */
public class Archive {
    private int vendorId;
    private int customerId;
    private String goodName;
    private String sellDate;
    private int price;
    private String comment;

    public Archive() {
    }

    public Archive(Builder builder) {
        this.vendorId = builder.vendorId;
        this.customerId = builder.customerId;
        this.goodName = builder.goodName;
        this.sellDate = builder.sellDate;
        this.price = builder.price;
        this.comment = builder.comment;
    }

    public static class Builder {
        private int vendorId;
        private int customerId;
        private String goodName;
        private String sellDate;
        private int price;
        private String comment;

        public Builder vendorId(int arg) {
            this.vendorId = arg;
            return this;
        }

        public Builder customerId(int arg) {
            this.customerId = arg;
            return this;
        }

        public Builder goodName(String arg) {
            this.goodName = arg;
            return this;
        }

        public Builder sellDate(String arg) {
            this.sellDate = arg;
            return this;
        }

        public Builder price(int arg) {
            this.price = arg;
            return this;
        }

        public Builder comment(String arg) {
            this.comment = arg;
            return this;
        }

        public Archive build() {
            return new Archive(this);
        }
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
