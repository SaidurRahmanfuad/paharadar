package com.saidur.paharadar.ui.gurds;

public class gurds {


    private String id;
    private String name;
    private int image;
    private String designation;
    private String status;
    private String phoneNumber;
    private String address;
    private String latitude;
    private String longitude;

    public gurds() {
    }

    public gurds(String id, String name, int image, String designation, String status, String phoneNumber, String address, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.designation = designation;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber(int position) {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber,int position) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
