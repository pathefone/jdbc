package com.company;

public class Airport {
    private int biz_id;
    private String biz_name;
    private String address;
    private String city;
// paieskai, redagavimui
    public Airport(int biz_id, String biz_name, String address, String city) {
        this.biz_id = biz_id;
        this.biz_name = biz_name;
        this.address = address;
        this.city = city;
    }
// naujo iraso kurimui
    public Airport(String biz_name, String address, String city) {
        this.biz_name = biz_name;
        this.address = address;
        this.city = city;
    }

    public int getBiz_id() {
        return biz_id;
    }

    public String getBiz_name() {
        return biz_name;
    }

    public void setBiz_name(String biz_name) {
        this.biz_name = biz_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "biz_id=" + biz_id +
                ", biz_name='" + biz_name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
