package Model;

import java.util.Date;

public class Discount {
    private int discountId;
    private String title, type;
    private double discount;
    private Date startDate, endDate;

    public Discount() {
    }

    public Discount(int discountId, String title, String type, Double discount, Date startDate, Date endDate) {
        this.discountId = discountId;
        this.title = title;
        this.type = type;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Discount(String title, String type, Double discount, Date startDate, Date endDate) {
        this.title = title;
        this.type = type;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountId=" + discountId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", discount=" + discount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
