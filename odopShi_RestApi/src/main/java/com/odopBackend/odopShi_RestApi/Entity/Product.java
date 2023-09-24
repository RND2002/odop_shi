package com.odopBackend.odopShi_RestApi.Entity;

import jakarta.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    private String productName;

    private String descriptions;

    private int price;

    private String productOwner;

    private String district;

    private String category;

    @Column(name = "image")
    @Lob
    private byte[] image;
    
    public Product() {
    	
    }

    public Product(long productId, String productName, String descriptions, int price, String productOwner, String district, String category, byte[] image) {
        this.productId = productId;
        this.productName = productName;
        this.descriptions = descriptions;
        this.price = price;
        this.productOwner = productOwner;
        this.district = district;
        this.category = category;
        this.image = image;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
