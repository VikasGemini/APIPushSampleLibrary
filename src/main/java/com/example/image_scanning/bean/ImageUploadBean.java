package com.example.image_scanning.bean;

public class ImageUploadBean {
    private String base64string ;
    private String waybill ;
    private String entity ;

    public String getBase64string() {
        return base64string;
    }

    public void setBase64string(String base64string) {
        this.base64string = base64string;
    }

    public String getWaybill() {
        return waybill;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
}
