package Model;

public class Address {
    private int addressId;
    private String city, district, subDistrict, postal_code;
    private Double deliveryFee;

    public Address() {
    }

    public Address(int addressId, String city, String district, String subDistrict, String postal_code, Double deliveryFee) {
        this.addressId = addressId;
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postal_code = postal_code;
        this.deliveryFee = deliveryFee;
    }

    public Address(String city, String district, String subDistrict, String postal_code, Double deliveryFee) {
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.postal_code = postal_code;
        this.deliveryFee = deliveryFee;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", subDistrict='" + subDistrict + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", deliveryFee=" + deliveryFee +
                '}';
    }
    public void output()
    {
        System.out.printf("%15s %30s %30s %15s %15s %10s\n",addressId, city, district, subDistrict, postal_code, deliveryFee);

    }
}
