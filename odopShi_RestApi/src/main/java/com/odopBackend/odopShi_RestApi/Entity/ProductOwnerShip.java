package com.odopBackend.odopShi_RestApi.Entity;

import jakarta.persistence.*;


@Entity
public class ProductOwnerShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductOwnerShip(Long id, Users user, Product product) {
        this.id = id;
        this.user = user;
        this.product = product;
    }

    public ProductOwnerShip() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
